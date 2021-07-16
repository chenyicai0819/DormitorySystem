package cn.edu.guet.bean;

public class Room {
    private String rId;
    private String rBed;
    private String buid;

    public Room() {
    }

    public Room(String rId, String rBed, String buid) {
        this.rId = rId;
        this.rBed = rBed;
        this.buid = buid;
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

    @Override
    public String toString() {
        return "Room{" +
                "rId='" + rId + '\'' +
                ", rBed='" + rBed + '\'' +
                ", buid='" + buid + '\'' +
                '}';
    }
}
