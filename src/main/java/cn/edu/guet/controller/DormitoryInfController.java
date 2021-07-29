package cn.edu.guet.controller;

import cn.edu.guet.bean.Student;
import cn.edu.guet.service.IDormitoryInfService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class DormitoryInfController {

    @Autowired
    private IDormitoryInfService iDormitoryInfService;

    @GetMapping("DormitoryInform.do")
    public String getStuInf(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Student> userList = iDormitoryInfService.getStuInf();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
        return "dormitoryInf";
    }
    @GetMapping("updateStuInf")
    public String updateStuInf(Model model, Student student,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        iDormitoryInfService.updateStuInf(student);
        PageHelper.startPage(pageNum,10);
        List<Student> userList = iDormitoryInfService.getStuInf();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
        return "dormitoryInf";
    }
    @GetMapping("addStuInf")
    public String addStuInf(Model model, Student student,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        iDormitoryInfService.addStuInf(student);
        PageHelper.startPage(pageNum,10);
        List<Student> userList = iDormitoryInfService.getStuInf();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);

        return "dormitoryInf";
    }

    @PostMapping("search")
    public String search(Model model, String buid,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        iDormitoryInfService.search(buid);
        System.out.println("dada"+buid);
        PageHelper.startPage(pageNum,10);
        List<Student> userList = iDormitoryInfService.search(buid);
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
        return "dormitoryInf::table1";
    }
    @GetMapping("pagination3")
    public String pagination(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Student> userList = iDormitoryInfService.getStuInf();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println("数据"+iDormitoryInfService.getStuInf());
        return "dormitoryInf::table1";
    }

}
