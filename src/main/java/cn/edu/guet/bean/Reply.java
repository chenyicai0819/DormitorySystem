package cn.edu.guet.bean;

public class Reply {
    private String repId;
    private String fId;
    private String dId;
    private String repContent;

    public Reply() {
    }

    public Reply(String repId, String fId, String dId, String repContent) {
        this.repId = repId;
        this.fId = fId;
        this.dId = dId;
        this.repContent = repContent;
    }

    public String getRepId() {
        return repId;
    }

    public void setRepId(String repId) {
        this.repId = repId;
    }

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getRepContent() {
        return repContent;
    }

    public void setRepContent(String repContent) {
        this.repContent = repContent;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "repId='" + repId + '\'' +
                ", fId='" + fId + '\'' +
                ", anId='" + dId + '\'' +
                ", repContent='" + repContent + '\'' +
                '}';
    }
}
