package dk.cphbusiness.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

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
  public void load(String name, HttpServletResponse response) {
    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      String sql = "SELECT * FROM PICTURES WHERE NAME = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, name);
      try (ResultSet results = statement.executeQuery()) {
        if (results.next()) {
              response.setContentType(results.getString("TYPE"));
              try (OutputStream out = response.getOutputStream()) {
                try (InputStream in = results.getBinaryStream("DATA")) {
                  byte[] buffer = new byte[1024];
                  int count = 0;
                  do {
                    count = in.read(buffer);
                    out.write(buffer, 0, count);
                    }
                  while (count == 1024);
                  }
                } 
              catch (IOException ex) {
                Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        }
      }
    catch (SQLException ex) {
      Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  
  }
