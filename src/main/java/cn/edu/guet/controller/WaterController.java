package cn.edu.guet.controller;

import cn.edu.guet.bean.Water;
import cn.edu.guet.service.IWaterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
            System.out.println(water.getBuildingId());
        }
    }

    @PostMapping("updataWaterState")
    @ResponseBody
    public void updateWaterState(Water water){
        waterSeverce.updataWaterState(water);
    }

    @PostMapping("addWaterState")
    @ResponseBody
    public void addWaterState(Water water){
//        waterSeverce.updataWaterState(water);
    }
}