package cn.edu.guet.bean;

import java.security.Timestamp;

public class Board {
    private String boId;
    private String boName;
    private Timestamp boTime;
    private String boContent;

    public Board() {
    }

    public Board(String boId, String boName, Timestamp boTime, String boContent) {
        this.boId = boId;
        this.boName = boName;
        this.boTime = boTime;
        this.boContent = boContent;
    }

    public String getBoContent() {
        return boContent;
    }

    public void setBoContent(String boContent) {
        this.boContent = boContent;
    }

    public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

    public String getBoName() {
        return boName;
    }

    public void setBoName(String boName) {
        this.boName = boName;
    }

    public Timestamp getBoTime() {
        return boTime;
    }

    public void setBoTime(Timestamp boTime) {
        this.boTime = boTime;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boId='" + boId + '\'' +
                ", boName='" + boName + '\'' +
                ", boTime=" + boTime +
                ", boContent='" + boContent + '\'' +
                '}';
    }
}
