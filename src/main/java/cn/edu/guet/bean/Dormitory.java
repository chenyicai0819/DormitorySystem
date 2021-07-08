package cn.edu.guet.bean;

public class Dormitory {
    private int dId;
    private String roleId;
    private String buid;
    private String dName;
    private String dPwd;
    private String dPhone;
    private String dBuild;

    public Dormitory() {
    }

    public Dormitory(int dId, String roleId, String buid, String dName, String dPwd, String dPhone, String dBuild) {
        this.dId = dId;
        this.roleId = roleId;
        this.buid = buid;
        this.dName = dName;
        this.dPwd = dPwd;
        this.dPhone = dPhone;
        this.dBuild = dBuild;
    }

    public String getBuid() {
        return buid;
    }

    public void setBuid(String buid) {
        this.buid = buid;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdPwd() {
        return dPwd;
    }

    public void setdPwd(String dPwd) {
        this.dPwd = dPwd;
    }

    public String getdPhone() {
        return dPhone;
    }

    public void setdPhone(String dPhone) {
        this.dPhone = dPhone;
    }

    public String getdBuild() {
        return dBuild;
    }

    public void setdBuild(String dBuild) {
        this.dBuild = dBuild;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "dId=" + dId +
                ", roleId='" + roleId + '\'' +
                ", buid='" + buid + '\'' +
                ", dName='" + dName + '\'' +
                ", dPwd='" + dPwd + '\'' +
                ", dPhone='" + dPhone + '\'' +
                ", dBuild='" + dBuild + '\'' +
                '}';
    }
}
