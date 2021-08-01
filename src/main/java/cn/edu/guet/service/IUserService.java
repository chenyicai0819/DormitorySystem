package cn.edu.guet.service;

import cn.edu.guet.bean.Admin;
import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.bean.Orderman;
import cn.edu.guet.bean.Student;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface IUserService {
    //登录
    Admin Alogin(String aName);
    Dormitory Dlogin(String dName);
    Orderman Rmlogin(String rmName);
    Student Slogin(String sName);

    String searchdPhone(String dPhone);
    String searchsPhone(String sPhone);
    String searchrmPhone(String rmPhone);

    String updatedPhone(String phone, String password, String repeat) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    String updatesPhone(String phone, String password, String repeat) throws UnsupportedEncodingException, NoSuchAlgorithmException;
    String updatermPhone(String phone, String password, String repeat) throws UnsupportedEncodingException, NoSuchAlgorithmException;


}
