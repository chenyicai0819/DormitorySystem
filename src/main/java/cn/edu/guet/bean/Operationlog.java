package cn.edu.guet.bean;

import java.security.Timestamp;

public class Operationlog {
    private String opId;
    private String opName;
    private String opUser;
    private Timestamp opTime;

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

    public String getOpUser() {
        return opUser;
    }

    public void setOpUser(String opUser) {
        this.opUser = opUser;
    }

    public Timestamp getOpTime() {
        return opTime;
    }

    public void setOpTime(Timestamp opTime) {
        this.opTime = opTime;
    }

    @Override
    public String toString() {
        return "OperationlogMapper{" +
                "opId='" + opId + '\'' +
                ", opName='" + opName + '\'' +
                ", opUser='" + opUser + '\'' +
                ", opTime=" + opTime +
                '}';
    }
}
