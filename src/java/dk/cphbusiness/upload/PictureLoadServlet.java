package dk.cphbusiness.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "PictureLoadServlet", urlPatterns = {"/PictureLoadServlet"})
@MultipartConfig
public class PictureLoadServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Controller controller = new DatabaseController();
    
    String name = request.getParameter("name");
    
    Picture picture = controller.load(name);

    response.setContentType(picture.getType());
    try (OutputStream out = response.getOutputStream()) {
      try (InputStream in = picture.getData()) {
        byte[] buffer = new byte[1024];
        int count = 0;
        do {
          count = in.read(buffer);
          out.write(buffer, 0, count);
          }
        while (count == 1024);
        }
      }
    
    
    // ---
    
   
    
    }
  

  }
