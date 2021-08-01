package cn.edu.guet.bean;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.bean
 * @date 2021/7/16 20:23
 * @since 1.0
 */
public class Orderman {
    private int rmId;
    private String roleId;
    private String rmName;
    private String rmPwd;
    private String rmPhone;

    public int getRmId() {
        return rmId;
    }

    public void setRmId(int rmId) {
        this.rmId = rmId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmPhone() {
        return rmPhone;
    }

    public void setRmPhone(String rmPhone) {
        this.rmPhone = rmPhone;
    }

    public String getRmPwd() {
        return rmPwd;
    }

    public void setRmPwd(String rmPwd) {
        this.rmPwd = rmPwd;
    }


    @Override
    public String toString() {
        return "Orderman{" +
                "rmId=" + rmId +
                ", roleId='" + roleId + '\'' +
                ", rmName='" + rmName + '\'' +
                ", rmPhone='" + rmPhone + '\'' +
                ", emPwd='" + rmPwd + '\''+
                '}';
    }
}
