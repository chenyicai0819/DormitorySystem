package cn.edu.guet.controller;

import cn.edu.guet.bean.WaterOrder;
import cn.edu.guet.service.IWaterOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WaterOrderController {

    @Autowired
    private IWaterOrderService waterOrderService;

    @PostMapping("insertWaterOrder")
    @ResponseBody
    public void insertWaterOrder(WaterOrder waterOrder){
        waterOrder.setAmount(waterOrder.getNumber() * 7.5);
//        System.out.println("ttttttttttt:"+waterOrder.getAmount());
        waterOrderService.insertWaterOrder(waterOrder);
    }

    @GetMapping("insertWaterOrder")
    public String insertWaterOrder(){
        return "insertWaterOrder";
    }

    @GetMapping("viewWaterOrder")
    public String viewWaterOrder(){
        return "viewWaterOrder";
    }

    @PostMapping("getAllWaterOrder")
    @ResponseBody
    public List<WaterOrder> getAllWaterOrder(int curPage, int pageSize){
        int startRow = (curPage - 1) * pageSize;
        return waterOrderService.getAllWaterOrder(startRow, pageSize);
    }

    @PostMapping("getBuildingWaterOrder")
    @ResponseBody
    public List<WaterOrder> getBuildingWaterOrder(String buildingId, int curPage, int pageSize){
        int startRow = (curPage - 1) * pageSize;
        return waterOrderService.getWaterOrderByBuilding(buildingId, startRow, pageSize);
    }

    @PostMapping("getRoomWaterOrder")
    @ResponseBody
    public List<WaterOrder> getRoomWaterOrder(String buildingId, String roomId, int curPage, int pageSize){
        int startRow = (curPage - 1) * pageSize;
        return waterOrderService.getWaterOrderByRoom(buildingId, roomId, startRow, pageSize);
    }

    @PostMapping("getAllWaterOrderCount")
    @ResponseBody
    public int getAllWaterOrderCount(){
        return waterOrderService.getAllWaterOrderCount();
    }

    @PostMapping("getBuildingWaterOrderCount")
    @ResponseBody
    public int getBuildingWaterOrderCount(String buildingId){
        return waterOrderService.getBuildingWaterOrderCount(buildingId);
    }

    @PostMapping("getRoomWaterOrderCount")
    @ResponseBody
    public int getRoomWaterOrderCount(String buildingId, String roomId){
        return waterOrderService.getRoomWaterOrderCount(buildingId, roomId);
    }

}
