package cn.edu.guet.bean;

import java.security.Timestamp;

public class Waterorder {
    private String woId;
    private String wid;
    private int woNum;
    private String woRoom;
    private int woMoney;
    private Timestamp woTime;

    public Waterorder() {
    }

    public Waterorder(String woId, String wid, int woNum, String woRoom, int woMoney, Timestamp woTime) {
        this.woId = woId;
        this.wid = wid;
        this.woNum = woNum;
        this.woRoom = woRoom;
        this.woMoney = woMoney;
        this.woTime = woTime;
    }

    public int getWoMoney() {
        return woMoney;
    }

    public void setWoMoney(int woMoney) {
        this.woMoney = woMoney;
    }

    public String getWoId() {
        return woId;
    }

    public void setWoId(String woId) {
        this.woId = woId;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
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

    public Timestamp getWoTime() {
        return woTime;
    }

    public void setWoTime(Timestamp woTime) {
        this.woTime = woTime;
    }

    @Override
    public String toString() {
        return "Waterorder{" +
                "woId='" + woId + '\'' +
                ", wid='" + wid + '\'' +
                ", woNum=" + woNum +
                ", woRoom='" + woRoom + '\'' +
                ", woMoney=" + woMoney +
                ", woTime=" + woTime +
                '}';
    }
}
