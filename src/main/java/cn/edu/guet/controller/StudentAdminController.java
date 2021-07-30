package cn.edu.guet.controller;

import cn.edu.guet.bean.Student;
import cn.edu.guet.service.IStudentAdminService;
import cn.edu.guet.service.impl.ApplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentAdminController {
    @Autowired
    private IStudentAdminService iStudentAdminService;
    @Autowired
    private ApplyService applyService;

    @GetMapping("StuManage.do")
    public String getStudent(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
       // 默认从第一页开始，每页展示五条数据
        List<Student> userList = iStudentAdminService.getStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("apply",applyService.lookApply());
        return "student";
    }
    @RequestMapping("deleteStudent")
    public String deleteStudent(Model model,String sId,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        iStudentAdminService.deleteStudent(sId);
        PageHelper.startPage(pageNum,10);
        List<Student> userList = iStudentAdminService.getStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
      model.addAttribute("apply",applyService.lookApply());
        return "student";
    }
    @RequestMapping("updateStudent")
    public String deleteStudent(Model model, Student student,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        iStudentAdminService.updateStudent(student);
        PageHelper.startPage(pageNum,10);
        List<Student> userList = iStudentAdminService.getStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("apply",applyService.lookApply());
        return "student";
    }
    @RequestMapping("addStudent")
    public String addStudent(Model model, Student student,Integer currentPage){
        iStudentAdminService.addStudent(student);
        if(currentPage==null){
            currentPage=1;
        }
        int allPage= iStudentAdminService.getStudentCount();
        model.addAttribute("maxPage",allPage);
        System.out.println("总数目"+allPage);
        if(allPage%10==0){
            allPage=allPage/10;
        }else {
            allPage=allPage/10+1;
        }
        model.addAttribute("allPage",allPage);
        System.out.println("总页目"+allPage);
      model.addAttribute("apply",applyService.lookApply());
        model.addAttribute("students", iStudentAdminService.getStudent());
        return "student";
    }
    @PostMapping("searchStudent")
    public String searchStudent(Model model,int sId,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Student> userList = iStudentAdminService.searchStudent(sId);
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
      model.addAttribute("apply",applyService.lookApply());
        return "student::table1";
    }
    @GetMapping("pagination2")
    public String pagination(Model model,HttpServletRequest request, @RequestParam(defaultValue = "1", value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,10);
        System.out.println(pageNum);
        List<Student> userList = iStudentAdminService.getStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
      model.addAttribute("apply",applyService.lookApply());
           // 默认从第一页开始，每页展示五条数据
        return "student::table1";
    }
}
