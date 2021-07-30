package cn.edu.guet.controller;



import cn.edu.guet.bean.Apply;
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
    private IStudentService studentService;

    @GetMapping("StuInform.do")
    public String stuManage(Model model,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        System.out.println(pageNum);
        List<Student> studentList = studentService.stuManage();
        PageInfo<Student> pageInfo=new PageInfo<>(studentList);
        model.addAttribute("allPage",pageInfo.getPages());
        model.addAttribute("maxPage",pageInfo.getTotal());
        model.addAttribute("pageInfo",studentList);
        return "stuManage";
    }

    @PostMapping("/searchStu")
    public String searchStu(Model model,int studentId,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Student> studentList=studentService.searchStu(studentId);
        PageInfo<Student> pageInfo=new PageInfo<>(studentList);
        model.addAttribute("allPage",pageInfo.getPages());
        model.addAttribute("maxPage",pageInfo.getTotal());
        model.addAttribute("pageInfo",studentList);
        return "stuManage::body";
    }

    @RequestMapping("getStu")
    public String getStu(Model model,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        List<Student> studentList = studentService.stuManage();
        PageInfo<Student> pageInfo=new PageInfo<>(studentList);
        model.addAttribute("allPage",pageInfo.getPages());
        model.addAttribute("maxPage",pageInfo.getTotal());
        model.addAttribute("pageInfo",studentList);
        return "stuManage::table1";
    }
}
