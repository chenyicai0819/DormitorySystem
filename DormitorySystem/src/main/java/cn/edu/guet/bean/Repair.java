package cn.edu.guet.bean;

import java.sql.Timestamp;

public class Repair {
    private String reId;
    private String reNames;
    private String reText;
    private String reClass;
    private String reRoom;
    private String rePhone;
    private Timestamp reTime;
    private String reStatus;
    private String reUser;

    public Repair() {
    }

    public Repair(String reId, String reNames, String reClass, String reText, String reRoom, String rePhone, Timestamp reTime, String reStatus, String reUser) {
        this.reId = reId;
        this.reNames = reNames;
        this.reClass = reClass;
        this.reText = reText;
        this.reRoom = reRoom;
        this.rePhone = rePhone;
        this.reTime = reTime;
        this.reStatus = reStatus;
        this.reUser = reUser;
    }

    public String getReText() {
        return reText;
    }

    public void setReText(String reText) {
        this.reText = reText;
    }

    public String getReId() {
        return reId;
    }

    public void setReId(String reId) {
        this.reId = reId;
    }

    public String getReNames() {
        return reNames;
    }

    public void setReNames(String reNames) {
        this.reNames = reNames;
    }

    public String getReClass() {
        return reClass;
    }

    public void setReClass(String reClass) {
        this.reClass = reClass;
    }

    public String getReRoom() {
        return reRoom;
    }

    public void setReRoom(String reRoom) {
        this.reRoom = reRoom;
    }

    public String getRePhone() {
        return rePhone;
    }

    public void setRePhone(String rePhone) {
        this.rePhone = rePhone;
    }

    public Timestamp getReTime() {
        return reTime;
    }

    public void setReTime(Timestamp reTime) {
        this.reTime = reTime;
    }

    public String getReStatus() {
        return reStatus;
    }

    public void setReStatus(String reStatus) {
        this.reStatus = reStatus;
    }

    public String getReUser() {
        return reUser;
    }

    public void setReUser(String reUser) {
        this.reUser = reUser;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "reId='" + reId + '\'' +
                ", reNames='" + reNames + '\'' +
                ", reClass='" + reClass + '\'' +
                ", reText='" + reText + '\'' +
                ", reRoom='" + reRoom + '\'' +
                ", rePhone='" + rePhone + '\'' +
                ", reTime=" + reTime +
                ", reStatus='" + reStatus + '\'' +
                ", reUser='" + reUser + '\'' +
                '}';
    }
}
