package cn.edu.guet.bean;

import java.security.Timestamp;

public class Loginlog {
    private String logId;
    private String logUser;
    private Timestamp logTime;

    public Loginlog() {
    }

    public Loginlog(String logId, String logUser, Timestamp logTime) {
        this.logId = logId;
        this.logUser = logUser;
        this.logTime = logTime;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public Timestamp getLogTime() {
        return logTime;
    }

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }

    @Override
    public String toString() {
        return "Loginlog{" +
                "logId='" + logId + '\'' +
                ", logUser='" + logUser + '\'' +
                ", logTime=" + logTime +
                '}';
    }
}
