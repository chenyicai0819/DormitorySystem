package cn.edu.guet.bean;

public class Usertree {

    private String treeId;
    private String roleId;

    public Usertree() {
    }

    public Usertree(String treeId, String roleId) {
        this.treeId = treeId;
        this.roleId = roleId;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Usertree{" +
                "treeId='" + treeId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
