package cn.edu.guet.bean;

public class Room {
    private String rId;
    private String rBed;
    private String buid;
    private String hpeople;

  public String getHpeople() {
    return hpeople;
  }

  public void setHpeople(String hpeople) {
    this.hpeople = hpeople;
  }

  public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getrBed() {
        return rBed;
    }

    public void setrBed(String rBed) {
        this.rBed = rBed;
    }

    public String getBuid() {
        return buid;
    }

    public void setBuid(String buid) {
        this.buid = buid;
    }

}
