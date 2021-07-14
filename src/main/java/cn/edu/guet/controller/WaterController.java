package cn.edu.guet.controller;

import cn.edu.guet.bean.Water;
import cn.edu.guet.filter.SqlsessionFilter;
import cn.edu.guet.mapper.WaterMapper;
import cn.edu.guet.mvc.annotaion.Controller;
import cn.edu.guet.mvc.annotaion.RequestMapping;

@Controller
public class WaterController {
    private WaterMapper waterMapper;

    @RequestMapping("/insertWater.do")
    public void insertWater(Water water) {
        water.setBuildingId("#" + water.getBuildingId());
        waterMapper = SqlsessionFilter.getSqlsession().getMapper(WaterMapper.class);
        waterMapper.insertWaterState(water);
        SqlsessionFilter.sqlCommit();
    }

    @RequestMapping("/updateWater.do")
    public void updateWater(Water water) {
        water.setBuildingId("#" + water.getBuildingId());
        waterMapper = SqlsessionFilter.getSqlsession().getMapper(WaterMapper.class);
        waterMapper.updateWaterState(water);
        SqlsessionFilter.sqlCommit();
    }
}
