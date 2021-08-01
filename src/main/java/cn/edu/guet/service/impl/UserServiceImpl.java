package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Admin;
import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.bean.Orderman;
import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.LogMapper;
import cn.edu.guet.mapper.UserMapper;
import cn.edu.guet.service.IUserService;
import cn.edu.guet.util.DateTime;
import cn.edu.guet.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LogMapper logMapper;


    @Override
    public Admin Alogin(String aName) {

        //往数据库中插入日志信息
        String sql="SELECT  logId from loginlog ORDER BY logId DESC LIMIT 0,1";
        String AId=logMapper.findLogId(sql);
        if (AId!=null){
        String Anum=AId.substring(3);//去除id的前3位
        int Anum1=Integer.parseInt(Anum);//将拿到的数据转化为数字类型
        Anum1++;//自增
        String str = String.format("%03d", Anum1);//如果小于3位左边补0
        String logId=AId.substring(0,3)+str;//截取logId的前3位加上str
        String logTime= DateTime.dateTime();
        logMapper.insert(logId,aName,logTime);
        }else {
            String id="log000";
            String num=id.substring(3);
            int num1=Integer.parseInt(num);
            num1++;
            String str = String.format("%03d", num1);//如果小于3位左边补0
            String logId=id.substring(0,3)+str;//截取logId的前3位加上str
            String logTime= DateTime.dateTime();
            logMapper.insert(logId,aName,logTime);
        }

        return userMapper.Alogin(aName);
    }

    @Override
    public Dormitory Dlogin(String dName) {

        //往数据库中插入日志信息
        String sql="SELECT  logId from loginlog ORDER BY logId DESC LIMIT 0,1";
        String AId=logMapper.findLogId(sql);
        if (AId!=null){
            String Anum=AId.substring(3);//去除id的前3位
            int Anum1=Integer.parseInt(Anum);//将拿到的数据转化为数字类型
            Anum1++;//自增
            String str = String.format("%03d", Anum1);//如果小于3位左边补0
            String logId=AId.substring(0,3)+str;//截取logId的前3位加上str
            String logTime= DateTime.dateTime();
            logMapper.insert(logId,dName,logTime);
        }else {
            String id="log000";
            String num=id.substring(3);
            int num1=Integer.parseInt(num);
            num1++;
            String str = String.format("%03d", num1);//如果小于3位左边补0
            String logId=id.substring(0,3)+str;//截取logId的前3位加上str
            String logTime= DateTime.dateTime();
            logMapper.insert(logId,dName,logTime);
        }

        return userMapper.Dlogin(dName);
    }

    @Override
    public Orderman Rmlogin(String rmName) {
        //往数据库中插入日志信息
        String sql="SELECT  logId from loginlog ORDER BY logId DESC LIMIT 0,1";
        String AId=logMapper.findLogId(sql);
        if (AId!=null){
            String Anum=AId.substring(3);//去除id的前3位
            int Anum1=Integer.parseInt(Anum);//将拿到的数据转化为数字类型
            Anum1++;//自增
            String str = String.format("%03d", Anum1);//如果小于3位左边补0
            String logId=AId.substring(0,3)+str;//截取logId的前3位加上str
            String logTime= DateTime.dateTime();
            logMapper.insert(logId,rmName,logTime);
        }else {
            String id="log000";
            String num=id.substring(3);
            int num1=Integer.parseInt(num);
            num1++;
            String str = String.format("%03d", num1);//如果小于3位左边补0
            String logId=id.substring(0,3)+str;//截取logId的前3位加上str
            String logTime= DateTime.dateTime();
            logMapper.insert(logId,rmName,logTime);
        }

        return userMapper.Rmlogin(rmName);
    }

    @Override
    public Student Slogin(String sName) {
        //往数据库中插入日志信息
        String sql="SELECT  logId from loginlog ORDER BY logId DESC LIMIT 0,1";
        String AId=logMapper.findLogId(sql);
        if (AId!=null){
            String Anum=AId.substring(3);//去除id的前3位
            int Anum1=Integer.parseInt(Anum);//将拿到的数据转化为数字类型
            Anum1++;//自增
            String str = String.format("%03d", Anum1);//如果小于3位左边补0
            String logId=AId.substring(0,3)+str;//截取logId的前3位加上str
            String logTime= DateTime.dateTime();
            logMapper.insert(logId,sName,logTime);
        }else {
            String id="log000";
            String num=id.substring(3);
            int num1=Integer.parseInt(num);
            num1++;
            String str = String.format("%03d", num1);//如果小于3位左边补0
            String logId=AId.substring(0,3)+str;//截取logId的前3位加上str
            String logTime= DateTime.dateTime();
            logMapper.insert(logId,sName,logTime);
        }

        return userMapper.Slogin(sName);
    }

    @Override
    public String searchdPhone(String dPhone) {
        return userMapper.searchdPhone(dPhone);
    }

    @Override
    public String searchsPhone(String sPhone) {
        return userMapper.searchsPhone(sPhone);
    }

    @Override
    public String searchrmPhone(String rmPhone){
        return userMapper.searchrmPhone(rmPhone);
    }

    @Override
    public String updatedPhone(String phone, String password, String repeat) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String password1=MD5Util.encoderByMd5(password);
        String repeat2=MD5Util.encoderByMd5(repeat);
        userMapper.updatedPhone(phone, password1, repeat2);
        return password1;
    }

    @Override
    public String updatesPhone(String phone, String password, String repeat) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String password1=MD5Util.encoderByMd5(password);
        String repeat2=MD5Util.encoderByMd5(repeat);
        userMapper.updatesPhone(phone, password1, repeat2);
        return password1;
    }

    @Override
    public String updatermPhone(String phone, String password, String repeat) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String password1=MD5Util.encoderByMd5(password);
        String repeat2=MD5Util.encoderByMd5(repeat);
        userMapper.updatermPhone(phone, password1, repeat2);
        return password1;
    }

}
