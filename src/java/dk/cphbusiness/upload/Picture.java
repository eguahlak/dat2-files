package dk.cphbusiness.upload;

import java.io.InputStream;

public class Picture {
  private final String name;
  private final String type;
  private final InputStream data;

  public Picture(String name, String type, InputStream data) {
    this.name = name;
    this.type = type;
    this.data = data;
    }

  public String getName() {
    return name;
    }

  public String getType() {
    return type;
    }

  public InputStream getData() {
    return data;
    }
  
  }
