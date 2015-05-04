package dk.cphbusiness.upload;

import javax.servlet.http.HttpServletResponse;

public interface Controller {
  void save(Picture picture);
  void load(String name, HttpServletResponse response);
  }
