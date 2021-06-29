package cn.edu.guet.bean;

public class Feedbck {
    private String fId;
    private int sId;
    private int dId;
    private String fName;
    private String fContent;

    public Feedbck() {
    }

    public Feedbck(String fId, int sId, int dId, String fName, String fContent) {
        this.fId = fId;
        this.sId = sId;
        this.dId = dId;
        this.fName = fName;
        this.fContent = fContent;
    }

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfContent() {
        return fContent;
    }

    public void setfContent(String fContent) {
        this.fContent = fContent;
    }

    @Override
    public String toString() {
        return "Feedbck{" +
                "fId='" + fId + '\'' +
                ", sId=" + sId +
                ", dId=" + dId +
                ", fName='" + fName + '\'' +
                ", fContent='" + fContent + '\'' +
                '}';
    }
}
