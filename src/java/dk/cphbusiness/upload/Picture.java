package dk.cphbusiness.upload;

public class Picture {
  private final String name;
  private final String type;
  private final byte[] data;

  public Picture(String name, String type, byte[] data) {
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

  public byte[] getData() {
    return data;
    }
  
  }
