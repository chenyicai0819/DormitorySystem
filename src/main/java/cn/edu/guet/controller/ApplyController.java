package cn.edu.guet.controller;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.service.impl.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @GetMapping("commitApply.do")
    public List<Apply> commitApply(String applyId,String message,String reply){
        return applyService.addApply(applyId,message,reply);
    }
}
