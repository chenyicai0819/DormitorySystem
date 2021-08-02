package cn.edu.guet.bean;

public class Apply {
    private String applyId;
    private String message;
    private String reply;
    private String sqlMessage;

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

  public String getSqlMessage() {
    return sqlMessage;
  }

  public void setSqlMessage(String sqlMessage) {
    this.sqlMessage = sqlMessage;
  }
}
