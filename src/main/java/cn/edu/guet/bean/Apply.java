package cn.edu.guet.bean;

public class Apply {
    private String applyId;
    private String message;
    private String reply;

    public Apply(){};

    public Apply(String applyId, String message, String reply) {
        this.applyId = applyId;
        this.message = message;
        this.reply = reply;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
