package cn.edu.guet.controller;

import cn.edu.guet.bean.Repair;
import cn.edu.guet.service.IRepairService;
import cn.edu.guet.service.IRoomService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;


@Controller
public class RepairController {

    @Autowired
    private IRepairService repairService;
    @Autowired
    private IRoomService roomService;

    @GetMapping("RepairUp.do")
    public String repairUp(Repair repair, HttpServletRequest request, HttpSession session){
        try {

            int RepairNum= repairService.repairSele()+1;
            repair.setReId(String.valueOf(RepairNum));
            Timestamp time=new Timestamp(System.currentTimeMillis());
            repair.setReTime(time);
            repair.setReStatus("未处理");
            repair.setReUser((String) session.getAttribute("username"));
            repairService.repairUp(repair);
            request.setAttribute("builds",roomService.viewBuild());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "RepairMan";
    }

    @RequestMapping("RepairMan.do")
    public String repairMan(HttpServletRequest request){
      request.setAttribute("builds",roomService.viewBuild());
      return "RepairMan";
    }

    @GetMapping("RepairForUs.do")
    public String repairForUs(String reUser, HttpServletRequest request,Model model,HttpSession session){
        String repairname= (String) session.getAttribute("username");
        int count=repairService.repairSele(repairname);
        int allPage;
        if (count%5==0){
            allPage=count/5;
        }else {
            allPage=(count/5)+1;
        }
        model.addAttribute("allPage",allPage);
        int cur=1;
        String username= (String) session.getAttribute("username");
        request.setAttribute("repair",repairService.repairForUs(username,cur));
        return "RepairForUs";
    }

    @GetMapping("upPageForUs.do")
    public String upPageForUs(String reUser, HttpServletRequest request,HttpSession session,Model model,int curPage){
        String repairname= (String) session.getAttribute("username");
        int count=repairService.repairSele(repairname);
        int allPage;
        if (count%5==0){
            allPage=count/5;
        }else {
            allPage=(count/5)+1;
        }
        model.addAttribute("allPage",allPage);
        System.out.println(curPage);
        String username= (String) session.getAttribute("username");
        request.setAttribute("repair",repairService.repairForUs(username,curPage));
        return "RepairForUs::table1";
    }
    @GetMapping("upPageForSee.do")
    public String upPageForSee(String reStutas, HttpServletRequest request,Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        System.out.println(reStutas);
        System.out.println(pageNum);
        String stutas;
        if (reStutas!=null){
            stutas=reStutas;
        }else {
            stutas="未处理";
        }
        PageHelper.startPage(pageNum,5);    // 默认从第一页开始，每页展示五条数据
        List<Repair> repairList=repairService.seeAllRepair(stutas);
        request.setAttribute("repair",repairList);
        PageInfo<Repair> pageInfo = new PageInfo<>(repairList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("statas",stutas);
        return "SeeRepair::table1";
    }

    @GetMapping("SeeAllRepair.do")
    public String seeAllRepair(HttpServletRequest request,String reStutas,Model model ,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        String stutas;
        if (reStutas!=null){
            stutas=reStutas;
        }else {
            stutas="未处理";
        }
        PageHelper.startPage(pageNum,5);    // 默认从第一页开始，每页展示五条数据
        List<Repair> repairList=repairService.seeAllRepair(stutas);
        request.setAttribute("repair",repairList);
        PageInfo<Repair> pageInfo = new PageInfo<>(repairList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("statas",stutas);
        return "SeeRepair";
    }
    @RequestMapping("SeeRepair.do")
    public String seeRepair(HttpServletRequest request,String reStutas,Model model ,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        String stutas;
        if (reStutas!=null){
            stutas=reStutas;
        }else {
            stutas="未处理";
        }
        PageHelper.startPage(pageNum,5);    // 默认从第一页开始，每页展示五条数据
        List<Repair> repairList=repairService.seeAllRepair(stutas);
        request.setAttribute("repair",repairList);
        PageInfo<Repair> pageInfo = new PageInfo<>(repairList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("statas",stutas);
        return "SeeRepair";
    }

    @GetMapping("upRepair.do")
    public String upRepair(String reId, HttpServletRequest request, String reStutas, Model model ,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);    // 默认从第一页开始，每页展示五条数据
        repairService.upRepair(reId);
        List<Repair> repairList=repairService.seeAllRepair(reStutas);
        request.setAttribute("repair",repairList);
        PageInfo<Repair> pageInfo = new PageInfo<>(repairList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("statas",reStutas);
        return "SeeRepair";
    }
    @GetMapping("overRepair.do")
    public String overRepair(String reId,HttpServletRequest request,String reStutas,Model model ,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);    // 默认从第一页开始，每页展示五条数据
        repairService.overRepair(reId);
        List<Repair> repairList=repairService.seeAllRepair(reStutas);
        request.setAttribute("repair",repairList);
        PageInfo<Repair> pageInfo = new PageInfo<>(repairList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("statas",reStutas);
        return "SeeRepair";
    }
}
