package cn.edu.guet.bean;

public class Room {
    private String rId;
    private String bBed;
    private String buid;
    private String isMan;

    public Room() {
    }

    public Room(String rId, String bBed, String buid, String isMan) {
        this.rId = rId;
        this.bBed = bBed;
        this.buid = buid;
        this.isMan = isMan;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getbBed() {
        return bBed;
    }

    public void setbBed(String bBed) {
        this.bBed = bBed;
    }

    public String getBuid() {
        return buid;
    }

    public void setBuid(String buid) {
        this.buid = buid;
    }

    public String getIsMan() {
        return isMan;
    }

    public void setIsMan(String isMan) {
        this.isMan = isMan;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rId='" + rId + '\'' +
                ", bBed='" + bBed + '\'' +
                ", buid='" + buid + '\'' +
                ", isMan='" + isMan + '\'' +
                '}';
    }
}
