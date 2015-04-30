package dk.cphbusiness.upload;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseController implements Controller {
  private String username = "aka";
  private String password = "aka";
  private String driver = "oracle.jdbc.driver.OracleDriver";
  private String url = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:DAT";

  public DatabaseController() {
    try {
      Class.forName(driver);
      } 
    catch (ClassNotFoundException ex) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  
  @Override
  public void save(Picture picture) {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      String sql = "INSERT INTO PICTURES (NAME, TYPE, DATA) VALUES (?, ?, ?)";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, picture.getName());
      statement.setString(2, picture.getType());
      statement.setBlob(3, picture.getData());
      statement.executeUpdate();
      }
    catch (SQLException ex) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

  @Override
  public Picture load(String name) {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      String sql = "SELECT * FROM PICTURES WHERE NAME = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      try (ResultSet results = statement.executeQuery()) {
        if (results.next()) {
          return new Picture(
              name,
              results.getString("TYPE"),
              results.getBlob("DATA").getBinaryStream()
              );
          }
        return null;
        }
      }
    catch (SQLException ex) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
      return null;
      }
    }
  
  }
