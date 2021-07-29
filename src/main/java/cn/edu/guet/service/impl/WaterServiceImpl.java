package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Water;
import cn.edu.guet.mapper.WaterMapper;
import cn.edu.guet.service.IWaterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterServiceImpl implements IWaterService {

    @Autowired
    private WaterMapper waterMapper;


    @Override
    public PageInfo getAllWaterState(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Water> waters = waterMapper.getAllWaterState();
        return new PageInfo(waters);
    }

    @Override
    public void insertWaterState(Water water) {
        waterMapper.insertWaterState(water);
    }

    @Override
    public void updataWaterState(Water water) {
        waterMapper.updataWaterState(water);
    }

    @Override
    public void delteWaterState(String buildingId) {
        waterMapper.delteWaterState(buildingId);
    }

    @Override
    public void addWaterState(Water water) {
        waterMapper.addWaterState(water);
    }

    @Override
    public void upWaterMoney(double money) {
      waterMapper.upWaterMoney(money);
    }

}
