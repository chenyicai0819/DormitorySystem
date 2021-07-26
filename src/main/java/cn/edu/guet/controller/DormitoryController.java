package cn.edu.guet.controller;

import cn.edu.guet.service.impl.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("SgManage.do")
    public String SgManage(Model model){
        model.addAttribute("suguan",dormitoryService.getDormitoryM());
        model.addAttribute("buid",dormitoryService.getDormBuid());
        return "sgxx";
    }
}
