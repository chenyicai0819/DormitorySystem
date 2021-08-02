package cn.edu.guet.controller;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.service.impl.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @GetMapping("commitApply.do")
    public List<Apply> commitApply(String applyId,String message,String reply,String sqlMessage){
        return applyService.addApply(applyId,message,reply,sqlMessage);
    }
  @GetMapping("yhsq.do")
  public String stuManage(Model model){
    model.addAttribute("apply",applyService.lookApply());
    return "xsgl";
  }
  @GetMapping("UpdateApp.do")
  @ResponseBody
  public void UpdateApp(String sql,String sId){
    applyService.updateApply(sql,sId);
  }
  @GetMapping("getState.do")
  @ResponseBody
  public void getState(String reply,String sqlMessage){
    applyService.updateState(reply,sqlMessage);
  }
}
