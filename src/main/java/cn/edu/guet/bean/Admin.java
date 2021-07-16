package cn.edu.guet.bean;

public class Admin {
    private int aID;
    private String roleId;
    private String aName;
    private String aPwd;

    public int getaID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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
                ", roleId='" + roleId + '\'' +
                ", aName='" + aName + '\'' +
                ", aPwd='" + aPwd + '\'' +
                '}';
    }
}
