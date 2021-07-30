package cn.edu.guet.bean;

import java.sql.Timestamp;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.bean
 * @date 2021/7/16 20:19
 * @since 1.0
 */
public class Message {
    private String messageId;
    private String sendId;
    private String receiveId;
    private String title;
    private String content;
    private String isRead = "0";
    private Timestamp sendTime;

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", sendId='" + sendId + '\'' +
                ", receiveId='" + receiveId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isRead='" + isRead + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
