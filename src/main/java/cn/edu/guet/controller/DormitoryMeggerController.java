package cn.edu.guet.controller;

import cn.edu.guet.service.impl.DormitoryMeggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DormitoryMeggerController {
    @Autowired
    private DormitoryMeggerService dormitoryService;

    @GetMapping("SgManage.do")
    public String SgManage(Model model){
        model.addAttribute("suguan",dormitoryService.getDormitoryM());
        model.addAttribute("buid",dormitoryService.getDormBuid());
        return "sgxx";
    }
}
