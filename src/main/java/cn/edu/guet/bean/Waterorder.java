package cn.edu.guet.bean;

import java.sql.Timestamp;

public class Waterorder {
    private int woId;
    private String woUser;
    private String buid;
    private String woRoom;
    private int woNum;
    private double woMoney;
    private Timestamp woTime;

  public int getWoId() {
    return woId;
  }

  public void setWoId(int woId) {
    this.woId = woId;
  }

  public String getWoUser() {
    return woUser;
  }

  public void setWoUser(String woUser) {
    this.woUser = woUser;
  }

  public String getBuid() {
    return buid;
  }

  public void setBuid(String buid) {
    this.buid = buid;
  }

  public String getWoRoom() {
    return woRoom;
  }

  public void setWoRoom(String woRoom) {
    this.woRoom = woRoom;
  }

  public int getWoNum() {
    return woNum;
  }

  public void setWoNum(int woNum) {
    this.woNum = woNum;
  }

  public double getWoMoney() {
    return woMoney;
  }

  public void setWoMoney(double woMoney) {
    this.woMoney = woMoney;
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
      "woId=" + woId +
      ", woUser='" + woUser + '\'' +
      ", buid='" + buid + '\'' +
      ", woRoom='" + woRoom + '\'' +
      ", woNum=" + woNum +
      ", woMoney=" + woMoney +
      ", woTime=" + woTime +
      '}';
  }
}
