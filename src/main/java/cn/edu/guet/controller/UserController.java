package cn.edu.guet.controller;

import cn.edu.guet.bean.Admin;
import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.bean.Orderman;
import cn.edu.guet.bean.Student;
import cn.edu.guet.service.ITreeService;
import cn.edu.guet.service.IUserService;
import cn.edu.guet.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


@Controller
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ITreeService treeService;
    /*
     *登录部分
     */

    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request, Model model) throws UnsupportedEncodingException, NoSuchAlgorithmException {


        String selected=request.getParameter("selected");
        System.out.println("登陆的"+selected);
        System.out.println("登陆的"+username);
        System.out.println("登陆的"+password);

        HttpSession session = request.getSession();
        //MD5加密
        // String password1 = MD5Util.encoderByMd5(password);
       String password1=password;
        String aaa="";
        //将数据存到session里，方便myRealm取到
        session.setAttribute("roId",selected);
        session.setAttribute("userId",username);

        /**
         * 获取Shiro编写认证操作
         */
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        ThreadContext.bind(manager);
        //1、获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2、封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password1,selected);
        //执行登录方法
        try {
            //登录成功
            subject.login(token);
            //存放登录数据
          //username:id
            session.setAttribute("userId",username);
            session.setAttribute("roleId",selected);
            String name="";
            if (selected.equals("ro101")){
              Admin admin=userService.Alogin(username);
              if (admin!=null){
                name= String.valueOf(admin.getaName());
              }

            }else if (selected.equals("ro102")){
              Dormitory dormitory=userService.Dlogin(username);
              if (dormitory!=null){
                name= String.valueOf(dormitory.getdName());
              }
            }else if (selected.equals("ro103")){
              Student student=userService.Slogin(username);
              if (student!=null){
                name= String.valueOf(student.getsName());
              }
            }else if (selected.equals("ro104")||selected.equals("ro105")){
              Orderman orderman=userService.Rmlogin(username);
              if (orderman!=null){
                name= String.valueOf(orderman.getRmName());
              }
            }
          session.setAttribute("username",name);
            //跳转到界面
            return "redirect:getAllTree.do";
        } catch (UnknownAccountException e) {
            System.out.println("用户名不存在");
            session.setAttribute("msg","用户名不存在");
            return "redirect:toLogin";
        }catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            session.setAttribute("msg","密码错误");
            return "redirect:toLogin";
        }

    }

    @GetMapping("/toLogin")
    public String login(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("msg")==null){
            session.setAttribute("msg","");
        }
        request.setAttribute("board",treeService.seeBoard());
        model.addAttribute("board",treeService.seeBoard());
        return "login";
    }
    @GetMapping("/")
    public String firstLogin(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("msg")==null){
            session.setAttribute("msg","");
        }
        request.setAttribute("board",treeService.seeBoard());
        model.addAttribute("board",treeService.seeBoard());
      return "login";
    }

    //修改密码
    @PostMapping("/updatePassword")
    public String update(String phone, String password, String repeat,HttpServletRequest request,Model model,HttpSession session) throws
            UnsupportedEncodingException, NoSuchAlgorithmException {

        //检验手机号是否存在
        String dPhone=userService.searchdPhone(phone);
        String sPhone=userService.searchsPhone(phone);
        String rmPhone=userService.searchrmPhone(phone);
        String user=userService.updatedPhone(phone,password,repeat);
        String user1=userService.updatesPhone(phone, password, repeat);
        String user2=userService.updatermPhone(phone,password,repeat);
        if (user!=null&&phone.equals(dPhone)||user1!=null&&phone.equals(sPhone)||user2!=null&&phone.equals(rmPhone)) {
          request.setAttribute("board",treeService.seeBoard());
          model.addAttribute("board",treeService.seeBoard());
          session.setAttribute("msg","");
            return "login";
        } else {
            return "updatePassword";
        }
    }

    @GetMapping("/toUpdatePassword")
    public String updatePassword() {
        return "updatePassword";
    }

}
