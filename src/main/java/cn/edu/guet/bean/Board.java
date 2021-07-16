package cn.edu.guet.bean;

import java.sql.Timestamp;

public class Board {
    private String boId;
    private String boName;
    private String boContent;
    private Timestamp boTime;
    private String boUser;

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

    public String getBoContent() {
        return boContent;
    }

    public void setBoContent(String boContent) {
        this.boContent = boContent;
    }

    public Timestamp getBoTime() {
        return boTime;
    }

    public void setBoTime(Timestamp boTime) {
        this.boTime = boTime;
    }

    public String getBoUser() {
        return boUser;
    }

    public void setBoUser(String boUser) {
        this.boUser = boUser;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boId='" + boId + '\'' +
                ", boName='" + boName + '\'' +
                ", boContent='" + boContent + '\'' +
                ", boTime=" + boTime +
                ", boUser='" + boUser + '\'' +
                '}';
    }
}
