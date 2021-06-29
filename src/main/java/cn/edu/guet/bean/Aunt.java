package cn.edu.guet.bean;

public class Aunt {
    private String anId;
    private String buid;
    private String anName;
    private String anPwd;
    private String anPhone;

    public Aunt() {
    }

    public Aunt(String anId, String buid, String anName, String anPwd, String anPhone) {
        this.anId = anId;
        this.buid = buid;
        this.anName = anName;
        this.anPwd = anPwd;
        this.anPhone = anPhone;
    }

    public String getAnId() {
        return anId;
    }

    public void setAnId(String anId) {
        this.anId = anId;
    }

    public String getAnName() {
        return anName;
    }

    public void setAnName(String anName) {
        this.anName = anName;
    }

    public String getAnPhone() {
        return anPhone;
    }

    public void setAnPhone(String anPhone) {
        this.anPhone = anPhone;
    }

    public String getAnPwd() {
        return anPwd;
    }

    public void setAnPwd(String anPwd) {
        this.anPwd = anPwd;
    }

    public String getBuid() {
        return buid;
    }

    public void setBuid(String buid) {
        this.buid = buid;
    }

    @Override
    public String toString() {
        return "Aunt{" +
                "anId='" + anId + '\'' +
                ", buid='" + buid + '\'' +
                ", anName='" + anName + '\'' +
                ", anPwd='" + anPwd + '\'' +
                ", anPhone='" + anPhone + '\'' +
                '}';
    }
}
