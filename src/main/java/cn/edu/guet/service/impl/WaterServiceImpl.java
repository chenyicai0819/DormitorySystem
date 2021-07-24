package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Water;
import cn.edu.guet.mapper.WaterMapper;
import cn.edu.guet.service.IWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterServiceImpl implements IWaterService {

    @Autowired
    private WaterMapper waterMapper;

    @Override
    public Water getWaterState(String buildingId) {
        return waterMapper.getWaterState(buildingId);
    }

    @Override
    public List<Water> getAllWaterState() {
        return waterMapper.getAllWaterState();
    }

    @Override
    public List<Water> getLimitWaterState(int startRow, int pageSize) {
        return waterMapper.getLimitWaterState(startRow, pageSize);
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
    public int getWaterStateCount() {
        return waterMapper.getWaterStateCount();
    }
}
