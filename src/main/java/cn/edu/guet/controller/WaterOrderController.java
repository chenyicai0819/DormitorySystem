package cn.edu.guet.controller;

import cn.edu.guet.bean.Waterorder;
import cn.edu.guet.service.IWaterOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WaterOrderController {

    @Autowired
    private IWaterOrderService waterOrderService;

    @GetMapping("viewWaterOrder")
    public String viewWaterOrder(){
        return "viewWaterOrder";
    }

    @PostMapping("getAllWaterOrder")
    @ResponseBody
    public PageInfo getAllWaterOrder(int pageNum, int pageSize){
        return waterOrderService.getAllWaterOrder(pageNum, pageSize);
    }

    @PostMapping("getBuildingWaterOrder")
    @ResponseBody
    public PageInfo getBuildingWaterOrder(String buildingId, int pageNum, int pageSize){
        return waterOrderService.getWaterOrderByBuilding(buildingId, pageNum, pageSize);
    }

    @PostMapping("getRoomWaterOrder")
    @ResponseBody
    public PageInfo getRoomWaterOrder(String buildingId, String roomId, int pageNum, int pageSize){
        return waterOrderService.getWaterOrderByRoom(buildingId, roomId, pageNum, pageSize);
    }


    @GetMapping("getWaterTest")
    @ResponseBody
    public PageInfo getWaterTest(){
        return waterOrderService.test();
    }

    @GetMapping("thymeleafWaterOrder")
    public String thymeleafWaterOrder(Model model){
        List<Waterorder> waterorders = waterOrderService.getAllWaterOrder(1,10).getList();
      model.addAttribute("waterOrders", waterorders);
        return "thymeleafWaterOrder";
    }

    @PostMapping("getAllWaterOrderThymeleaf")
    public String getAllWaterOrdertest(int pageNum, int pageSize, Model model){
        PageInfo waterOrders = waterOrderService.getAllWaterOrder(pageNum,pageSize);
        model.addAttribute("waterOrders", waterOrders.getList());
        return "thymeleafWaterOrder::waterOrderinfo";
    }

}
