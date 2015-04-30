package dk.cphbusiness.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "PictureSaveServlet", urlPatterns = {"/PictureSaveServlet"})
@MultipartConfig
public class PictureSaveServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Controller controller = new DatabaseController();
    
    Part part = request.getPart("file");
    String name = part.getSubmittedFileName();
    String type = part.getHeader("content-type");
    InputStream data = part.getInputStream();
    
    Picture picture = new Picture(name, type, data);
    controller.save(picture);
    
    // ---
    
   
    
    }
  
  

  }
