package cn.edu.guet.bean;

import java.sql.Timestamp;

public class WaterOrder {
    private int waterOrderId;
    private String username;
    private String buildingId;
    private String roomId;
    private int number;
    private double amount;
    private Timestamp orderTime;

    public int getWaterOrderId() {
        return waterOrderId;
    }

    public void setWaterOrderId(int waterOrderId) {
        this.waterOrderId = waterOrderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "WaterOrder{" +
                "waterOrderId=" + waterOrderId +
                ", username='" + username + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", number=" + number +
                ", amount=" + amount +
                ", orderTime=" + orderTime +
                '}';
    }
}
