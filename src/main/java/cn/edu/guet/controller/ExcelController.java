package cn.edu.guet.controller;


import cn.edu.guet.bean.ReturnInfoUtil;
import cn.edu.guet.bean.Student;
import cn.edu.guet.service.ExcelService;
import cn.edu.guet.service.IStudentAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
/**
 * @author George
 * @project excdemo
 * @package com.example.excdemo.controller
 * @date 2021/7/24 19:48
 * @since 1.0
 */


/**
 * Created by Luowenlv on 2018/9/10,15:29
 */
@Controller
public class ExcelController {

    @Autowired
    private IStudentAdminService iStudentAdminService;
    @Autowired
    private ExcelService excelService;
    private ReturnInfoUtil returnInfoUtil;

    List userList = new ArrayList();

    @RequestMapping("/importStudent")
    public String fileImport(@RequestParam("file") MultipartFile file,Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) throws Exception {
        String fileName = file.getOriginalFilename();
        ReturnInfoUtil returnInfoUtil = excelService.getExcelInfo(fileName, file);
        if (null!=returnInfoUtil){
          model.addAttribute("retInfo","插入成功");
        }
        PageHelper.startPage(pageNum,10);
        // 默认从第一页开始，每页展示五条数据
        List<Student> userList = iStudentAdminService.getStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(userList);
        model.addAttribute("students",userList);
        model.addAttribute("pageInfo",pageInfo);

        return "student";
    }
}
