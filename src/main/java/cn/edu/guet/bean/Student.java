package cn.edu.guet.bean;

public class Student {
    private int sId;
    private String roleId;
    private String buid;
    private String rId;
    private String rBed;
    private String sPwd;
    private String sName;
    private String sSex;
    private String sCollege;

    public Student() {
        this.sId = sId;
        this.roleId = roleId;
        this.buid = buid;
        this.rId = rId;
        this.rBed = rBed;
        this.sPwd = sPwd;
        this.sName = sName;
        this.sSex = sSex;
        this.sCollege = sCollege;
        this.sGrade = sGrade;
        this.sPhone = sPhone;
    }

    private String sGrade;
    private String sPhone;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getBuid() {
        return buid;
    }

    public void setBuid(String buid) {
        this.buid = buid;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getrBed() {
        return rBed;
    }

    public void setrBed(String rBed) {
        this.rBed = rBed;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsCollege() {
        return sCollege;
    }

    public void setsCollege(String sCollege) {
        this.sCollege = sCollege;
    }

    public String getsGrade() {
        return sGrade;
    }

    public void setsGrade(String sGrade) {
        this.sGrade = sGrade;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", roleId='" + roleId + '\'' +
                ", buid='" + buid + '\'' +
                ", rId='" + rId + '\'' +
                ", rBed='" + rBed + '\'' +
                ", sPwd='" + sPwd + '\'' +
                ", sName='" + sName + '\'' +
                ", sSex='" + sSex + '\'' +
                ", sCollege='" + sCollege + '\'' +
                ", sGrade='" + sGrade + '\'' +
                ", sPhone='" + sPhone + '\'' +
                '}';
    }
}
