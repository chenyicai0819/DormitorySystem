package cn.edu.guet.bean;

import java.security.Timestamp;

public class Waterorder {
    private String woId;
    private String buid;
    private int woNum;
    private String woRoom;
    private int woMoney;
    private Timestamp woTime;
    private String woUser;

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId;
    }

    public String getBuid() {
        return buid;
    }

    public void setBuid(String buid) {
        this.buid = buid;
    }

    public int getWoNum() {
        return woNum;
    }

    public void setWoNum(int woNum) {
        this.woNum = woNum;
    }

    public String getWoRoom() {
        return woRoom;
    }

    public void setWoRoom(String woRoom) {
        this.woRoom = woRoom;
    }

    public int getWoMoney() {
        return woMoney;
    }

    public void setWoMoney(int woMoney) {
        this.woMoney = woMoney;
    }

    public Timestamp getWoTime() {
        return woTime;
    }

    public void setWoTime(Timestamp woTime) {
        this.woTime = woTime;
    }

    public String getWoUser() {
        return woUser;
    }

    public void setWoUser(String woUser) {
        this.woUser = woUser;
    }

    @Override
    public String toString() {
        return "Waterorder{" +
                "woId='" + woId + '\'' +
                ", buid='" + buid + '\'' +
                ", woNum=" + woNum +
                ", woRoom='" + woRoom + '\'' +
                ", woMoney=" + woMoney +
                ", woTime=" + woTime +
                ", woUser='" + woUser + '\'' +
                '}';
    }
}
