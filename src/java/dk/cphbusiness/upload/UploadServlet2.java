package dk.cphbusiness.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "UploadServlet2", urlPatterns = {"/Upload2"})
@MultipartConfig
public class UploadServlet2 extends HttpServlet {
  private static final String PATH = "/Users/anders/tmp";
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response
      ) throws ServletException, IOException {

    Part part = request.getPart("file");
    String contentType = part.getHeader("content-type");
    
    
//    response.setContentType("image/jpeg");
    response.setContentType(contentType);
    try (OutputStream out = response.getOutputStream()) {
      InputStream in = part.getInputStream();

      byte[] buffer = new byte[1024];
      int count = 0;
      do {
        count = in.read(buffer);
        out.write(buffer, 0, count);
        }
      while (count == 1024);
      in.close();
      }
    }
    
  }
