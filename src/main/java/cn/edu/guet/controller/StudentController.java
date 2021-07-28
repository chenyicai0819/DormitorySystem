package cn.edu.guet.controller;

import cn.edu.guet.bean.Student;
import cn.edu.guet.service.IStudentService;
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
public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @GetMapping("StuManage.do")
    public String getStudent(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,4);
       // 默认从第一页开始，每页展示五条数据
        List<Student> userList = iStudentService.getStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
        return "student";
    }
    @RequestMapping("deleteStudent")
    public String deleteStudent(Model model,String sId,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        iStudentService.deleteStudent(sId);
        PageHelper.startPage(pageNum,4);
        List<Student> userList = iStudentService.getStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
        return "student";
    }
    @RequestMapping("updateStudent")
    public String deleteStudent(Model model, Student student,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        iStudentService.updateStudent(student);
        PageHelper.startPage(pageNum,4);
        List<Student> userList = iStudentService.getStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);

        return "student";
    }
    @RequestMapping("addStudent")
    public String addStudent(Model model, Student student,Integer currentPage){
        iStudentService.addStudent(student);
        if(currentPage==null){
            currentPage=1;
        }
        int allPage=iStudentService.getStudentCount();
        model.addAttribute("maxPage",allPage);
        System.out.println("总数目"+allPage);
        if(allPage%4==0){
            allPage=allPage/4;
        }else {
            allPage=allPage/4+1;
        }
        model.addAttribute("allPage",allPage);
        System.out.println("总页目"+allPage);

        model.addAttribute("students",iStudentService.getStudent());
        return "student";
    }
    @PostMapping("searchStudent")
    public String searchStudent(Model model,int sId,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,4);
        List<Student> userList = iStudentService.searchStudent(sId);
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
        return "student::table1";
    }
    @GetMapping("pagination2")
    public String pagination(Model model,HttpServletRequest request, @RequestParam(defaultValue = "1", value = "pageNum")Integer pageNum){
        PageHelper.startPage(pageNum,4);
        System.out.println(pageNum);
        List<Student> userList = iStudentService.getStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
           // 默认从第一页开始，每页展示五条数据
        return "student::table1";
    }
}
