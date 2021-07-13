package cn.edu.guet.bean;

import java.sql.Timestamp;

public class Waterorder {
    private String waterOrderId;
    private String studentId;
    private String buildingId;
    private String roomId;
    private int number;
    private int amount;
    private Timestamp createTime;

    public Waterorder() {
    }

    public Waterorder(String waterOrderId, String studentId, String buildingId, String roomId, int number, int amount, Timestamp createTime) {
        this.waterOrderId = waterOrderId;
        this.studentId = studentId;
        this.buildingId = buildingId;
        this.roomId = roomId;
        this.number = number;
        this.amount = amount;
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    public String getWaterOrderId() {
        return waterOrderId;
    }

    public void setWaterOrderId(String waterOrderId) {
        this.waterOrderId = waterOrderId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
