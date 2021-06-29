package cn.edu.guet.bean;

public class Water {
    private String wid;
    private String buid;

    private int wnum;

    public Water() {
    }

    public Water(String wid, String buid, int wnum) {
        this.wid = wid;
        this.buid = buid;
        this.wnum = wnum;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getBuid() {
        return buid;
    }

    public void setBuid(String buid) {
        this.buid = buid;
    }

    public int getWnum() {
        return wnum;
    }

    public void setWnum(int wnum) {
        this.wnum = wnum;
    }

    @Override
    public String toString() {
        return "Water{" +
                "wid='" + wid + '\'' +
                ", buid='" + buid + '\'' +
                ", wnum=" + wnum +
                '}';
    }
}
