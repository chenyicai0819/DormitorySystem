package cn.edu.guet.bean;

public class Reply {
    private String repId;
    private String fId;
    private String anId;
    private String repContent;

    public Reply() {
    }

    public Reply(String repId, String fId, String anId, String repContent) {
        this.repId = repId;
        this.fId = fId;
        this.anId = anId;
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

    public String getAnId() {
        return anId;
    }

    public void setAnId(String anId) {
        this.anId = anId;
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
                ", anId='" + anId + '\'' +
                ", repContent='" + repContent + '\'' +
                '}';
    }
}
