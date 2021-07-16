package cn.edu.guet.bean;

import java.sql.Timestamp;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.bean
 * @date 2021/7/16 20:19
 * @since 1.0
 */
public class Messages {
    private String messId;
    private String sendId;
    private String receiveId;
    private String messTitle;
    private String messContent;
    private String isRead;
    private Timestamp messTime;

    public String getMessId() {
        return messId;
    }

    public void setMessId(String messId) {
        this.messId = messId;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getMessTitle() {
        return messTitle;
    }

    public void setMessTitle(String messTitle) {
        this.messTitle = messTitle;
    }

    public String getMessContent() {
        return messContent;
    }

    public void setMessContent(String messContent) {
        this.messContent = messContent;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public Timestamp getMessTime() {
        return messTime;
    }

    public void setMessTime(Timestamp messTime) {
        this.messTime = messTime;
    }

    @Override
    public String toString() {
        return "messages{" +
                "messId='" + messId + '\'' +
                ", sendId='" + sendId + '\'' +
                ", receiveId='" + receiveId + '\'' +
                ", messTitle='" + messTitle + '\'' +
                ", messContent='" + messContent + '\'' +
                ", isRead='" + isRead + '\'' +
                ", messTime=" + messTime +
                '}';
    }
}
