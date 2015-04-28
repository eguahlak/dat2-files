package dk.cphbusiness.upload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "UploadServlet", urlPatterns = {"/Upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
  private static final String PATH = "/Users/anders/tmp";
  
  @Override
  protected void service(
      HttpServletRequest request, 
      HttpServletResponse response
      ) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    Part part = request.getPart("file");
    out.print("<pre>");
    out.println("Name: "+part.getName());
    out.println("File: "+part.getSubmittedFileName());
    for (String headerName : part.getHeaderNames()) {
      out.println("  "+headerName+":");
      for (String header : part.getHeaders(headerName)) {
        out.println("    "+header);
        }
      }
    
    // The following lines only makes sense for text files.
    BufferedReader in = new BufferedReader(new InputStreamReader(part.getInputStream()));
    String line = in.readLine();
    while (line != null) {
      out.println("| "+line);
      line = in.readLine();
      }
    out.println("</pre>");
    }

  }
