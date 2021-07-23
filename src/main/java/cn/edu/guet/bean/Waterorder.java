package cn.edu.guet.bean;

import java.util.Date;

public class WaterOrder {
    private String woId;
    private String buid;
    private int woNum;
    private String woRoom;
    private int woMoney;
    private String woUser;
    private Date woTime;

    public Date getWoTime() {
        return woTime;
    }

    public void setWoTime(Date woTime) {
        this.woTime = woTime;
    }

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

    public String getWoUser() {
        return woUser;
    }

    public void setWoUser(String woUser) {
        this.woUser = woUser;
    }
}
