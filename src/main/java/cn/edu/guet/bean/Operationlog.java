package cn.edu.guet.bean;

import java.security.Timestamp;

public class Operationlog {
    private String opId;
    private String opName;
    private Timestamp opTime;

    public Operationlog() {
    }

    public Operationlog(String opId, String opName, Timestamp opTime) {
        this.opId = opId;
        this.opName = opName;
        this.opTime = opTime;
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public Timestamp getOpTime() {
        return opTime;
    }

    public void setOpTime(Timestamp opTime) {
        this.opTime = opTime;
    }

    @Override
    public String toString() {
        return "Operationlog{" +
                "opId='" + opId + '\'' +
                ", opName='" + opName + '\'' +
                ", opTime=" + opTime +
                '}';
    }
}
