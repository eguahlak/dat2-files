package dk.cphbusiness.upload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PictureLoadServlet", urlPatterns = {"/PictureLoadServlet"})
@MultipartConfig
public class PictureLoadServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Controller controller = new DatabaseController();
    
    String name = request.getParameter("name");
    Picture picture = controller.load(name);
    response.setContentType(picture.getType());
    response.getOutputStream().write(picture.getData());
    
    }  
  
  }
