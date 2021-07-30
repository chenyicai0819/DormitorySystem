package cn.edu.guet.controller;

import cn.edu.guet.bean.Water;
import cn.edu.guet.service.IWaterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WaterController {

    @Autowired
    private IWaterService waterSeverce;

    @PostMapping("getAllWaterState")
    @ResponseBody
    public PageInfo getAllWaterState(int pageNum, int pageSize){
        return waterSeverce.getAllWaterState(pageNum, pageSize);
    }

    @PostMapping("deleteWaterState")
    @ResponseBody
    public void delteWaterState(String buildingId){
        waterSeverce.delteWaterState(buildingId);
    }

    @PostMapping("updateAllWaterState")
    @ResponseBody
    public void updateAllWaterState(@RequestBody List<Water> waters){
        for(Water water : waters){
            System.out.println(water.getBuid());
        }
    }

    @PostMapping("updataWaterState")
    @ResponseBody
    public void updateWaterState(Water water){
        waterSeverce.updataWaterState(water);
    }

    @GetMapping("viewWaterStates")
    public String viewWaterStates(){
        return "viewWaterStates";
    }

    @GetMapping("testMain")
    public String testMain(){
        return "test";
    }

    @GetMapping("WaterManage.do")
    public String thymeleafWaterStates(Model model){
        List<Water> waterStates = waterSeverce.getAllWaterState(1,3).getList();
        double money=waterStates.get(0).getWprice();
        model.addAttribute("money",money);
        model.addAttribute("waterStates", waterStates);
        return "thymeleafWaterStates";
    }

    @PostMapping("getWaterStateThymeleaf")
    public String getWaterStateThymeleaf(int pageNum, int pageSize, Model model){
        PageInfo waterState = waterSeverce.getAllWaterState(pageNum, pageSize);
        model.addAttribute("waterStates", waterState.getList());
        return "thymeleafWaterStates::waterStateinfo";
    }

    @PostMapping("updataWaterMoney")
    @ResponseBody
    public String updataWaterMoney(double money,Model model){
      waterSeverce.upWaterMoney(money);
      List<Water> waterStates = waterSeverce.getAllWaterState(1,3).getList();
      double money1=waterStates.get(0).getWprice();
      model.addAttribute("money",money1);
      model.addAttribute("waterStates", waterStates);
      return "thymeleafWaterStates";
    }
}
