package cn.edu.guet.controller;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.bean.Room;
import cn.edu.guet.bean.Student;
import cn.edu.guet.service.IStuMessageService;
import cn.edu.guet.service.impl.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StuMessageController {

    @Autowired
    private IStuMessageService iSMM;


    @GetMapping("MyManage.do")
    public String xsxx(Model model){
        model.addAttribute("stu",iSMM.getStuMessage());
        model.addAttribute("dorm",iSMM.getDormBuid());
        return "xsxx";
    }
    @GetMapping("getDormRoom.do")
    @ResponseBody
    public List<Room> getRoom(String buid){
        List<Room> list = iSMM.getDormRoom(buid);
        return list;
    }
    @GetMapping("getDormBed.do")
    @ResponseBody
    public List<Room> getBed(String buid,String rId){
        List<Room> list = iSMM.getDormBed(buid,rId);
        return list;
    }
    @GetMapping("ApplyRecode.do")
    @ResponseBody
    public List<Apply> getRecode(Model model){
        List<Apply> list = iSMM.ApplyRecode();
        return list;
    }
}
