package cn.edu.guet.config;

import cn.edu.guet.bean.Admin;
import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.bean.Orderman;
import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.UserMapper;
import cn.edu.guet.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * @author George
 * @project shirodemo
 * @package com.example.shirodemo.realm
 * @date 2021/7/26 21:34
 * @since 1.0
 */
public class MyRealm extends AuthorizingRealm {
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private IUserService userService;
  HttpSession session;


  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    return null;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg) throws AuthenticationException {
    System.out.println("执行认证" + arg);
    UsernamePasswordToken token = (UsernamePasswordToken) arg;

    String roId=token.getHost();
    String userId=token.getUsername();
    System.out.println(roId);
    System.out.println(userId);
    String name="";
    String password="";
    //获取数据库用户名与密码
    if (roId.equals("ro101")){
      Admin admin=userService.Alogin(userId);
      if (admin!=null){
        name= String.valueOf(admin.getaID());
        password=admin.getaPwd();
      }

    }else if (roId.equals("ro102")){
      Dormitory dormitory=userService.Dlogin(userId);
      if (dormitory!=null){
        name= String.valueOf(dormitory.getdId());
        password=dormitory.getdPwd();
      }
    }else if (roId.equals("ro103")){
      Student student=userService.Slogin(userId);
      if (student!=null){
        name= String.valueOf(student.getsId());
        password=student.getsPwd();
      }
    }else if (roId.equals("ro104")||roId.equals("ro105")){
      Orderman orderman=userService.Rmlogin(userId);
      if (orderman!=null){
        name= String.valueOf(orderman.getRmId());
        password=orderman.getRmPwd();
      }
    }

    System.out.println("数据库："+name);
    System.out.println("数据库："+password);
    //编写Shiro判断逻辑，判断用户名与密码
    //判断用户名
    //如果返回的值与数据库中是用户名不匹配

    if (!token.getUsername().equals(name)) {
      //如果发生错误底层会抛出一个异常
      return null;
    }
    //判断密码
    return new SimpleAuthenticationInfo("", password, "");
  }
}
