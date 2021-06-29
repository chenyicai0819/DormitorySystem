package cn.edu.guet.bean;

public class Admin {
    private int aID;
    private String aName;
    private String aPwd;

    public Admin() {
    }

    public Admin(int aID, String aName, String aPwd) {
        this.aID = aID;
        this.aName = aName;
        this.aPwd = aPwd;
    }

    public int getaID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaPwd() {
        return aPwd;
    }

    public void setaPwd(String aPwd) {
        this.aPwd = aPwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aID=" + aID +
                ", aName='" + aName + '\'' +
                ", aPwd='" + aPwd + '\'' +
                '}';
    }
}
