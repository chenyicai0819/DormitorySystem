package cn.edu.guet.controller;

import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class DormitoryController {
@Autowired
private IDormitoryService iDormitoryService;
    @RequestMapping("AnutManage.do")
    public String getDormitory(Model model,Integer currentPage){
        if(currentPage==null){
            currentPage=1;
        }
        int allPage=iDormitoryService.getDormitoryCount();
        model.addAttribute("maxPage",allPage);
        System.out.println("总数目"+allPage);
        if(allPage%10==0){
            allPage=allPage/10;
        }else {
            allPage=allPage/10+1;
        }
        model.addAttribute("allPage",allPage);
        System.out.println("总页目"+allPage);

        model.addAttribute("dormitory",iDormitoryService.getDormitory(currentPage,10));
        return "dormitory";
    }
    @RequestMapping("deleteDormitory")
    public String deleteDormitory(String dId,Model model,Integer currentPage){
        iDormitoryService.deleteDormitory(dId);
        if(currentPage==null){
            currentPage=1;
        }
        int allPage=iDormitoryService.getDormitoryCount();
        model.addAttribute("maxPage",allPage);
        System.out.println("总数目"+allPage);
        if(allPage%10==0){
            allPage=allPage/10;
        }else {
            allPage=allPage/10+1;
        }
        model.addAttribute("allPage",allPage);
        System.out.println("总页目"+allPage);

        model.addAttribute("dormitory",iDormitoryService.getDormitory(currentPage,10));
        return "dormitory";
    }
    @PostMapping("updateDormitory")
    public String updateDormitory(Dormitory dormitory, Model model,Integer currentPage){
        if(currentPage==null){
            currentPage=1;
        }
        iDormitoryService.updateDormitory(dormitory);
        int allPage=iDormitoryService.getDormitoryCount();
        model.addAttribute("maxPage",allPage);
        if(allPage%10==0){
            allPage=allPage/10;
        }else {
            allPage=allPage/10+1;
        }
        model.addAttribute("allPage)",allPage);
        model.addAttribute("dormitory",iDormitoryService.getDormitory(currentPage,10));
        return "dormitory";
    }
    @RequestMapping("addDormitory")
    public String addDormitory(Dormitory dormitory,Model model,Integer currentPage){
        iDormitoryService.addDormitory(dormitory);
        if(currentPage==null){
            currentPage=1;
        }
        int allPage=iDormitoryService.getDormitoryCount();
        model.addAttribute("maxPage",allPage);
        System.out.println("总数目"+allPage);
        if(allPage%10==0){
            allPage=allPage/10;
        }else {
            allPage=allPage/10+1;
        }
        model.addAttribute("allPage",allPage);
        System.out.println("总页目"+allPage);

        model.addAttribute("dormitory",iDormitoryService.getDormitory(currentPage,10));
        return "dormitory";
    }

    @PostMapping("searchDormitory")
    public String searchDormitory(String dId,Model model,Integer currentPage){
        model.addAttribute("dormitory",iDormitoryService.searchDormitory(dId));
        return "dormitory::table1";
    }

    @RequestMapping("pagination1")//分页
    public String pagination1(Model model,Integer currentPage){
        int allPage=iDormitoryService.getDormitoryCount();
        model.addAttribute("maxPage",allPage);
       if(allPage%10==0){
            allPage=allPage/10;
        }else {
           allPage=allPage/10+1;
      }
        model.addAttribute("allPage)",allPage);
        model.addAttribute("dormitory",iDormitoryService.getDormitory(currentPage,10));
        return "dormitory::table1";
   }
}
