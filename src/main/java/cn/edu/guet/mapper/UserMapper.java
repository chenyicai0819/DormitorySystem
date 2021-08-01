package cn.edu.guet.mapper;

import cn.edu.guet.bean.Admin;
import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.bean.Orderman;
import cn.edu.guet.bean.Student;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    Admin Alogin(String aName);
    Dormitory Dlogin(String dName);
    Orderman Rmlogin(String rmName);
    Student Slogin(String sName);




    String searchdPhone(String dPhone);
    String searchsPhone(String sPhone);
    String searchrmPhone(String rmPhone);


    void updatedPhone(String dPhone, String dPwd, String repeat);
    void updatesPhone(String sPhone, String sPwd, String repeat);
    void updatermPhone(String rmPhone,String rmPwd,String repeat);

}
