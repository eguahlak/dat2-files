package dk.cphbusiness.upload;

public interface Controller {
  void save(Picture picture);
  Picture load(String name);
  }
