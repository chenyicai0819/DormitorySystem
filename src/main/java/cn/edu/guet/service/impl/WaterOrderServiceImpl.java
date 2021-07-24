package cn.edu.guet.service.impl;

import cn.edu.guet.bean.WaterOrder;
import cn.edu.guet.mapper.WaterOrderMapper;
import cn.edu.guet.service.IWaterOrderService;
import cn.edu.guet.service.IWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class WaterOrderServiceImpl implements IWaterOrderService {

    @Autowired
    private WaterOrderMapper waterOrderMapper;

    @Override
    public void insertWaterOrder(WaterOrder waterOrder) {
        waterOrder.setOrderTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(waterOrder.getOrderTime());
        waterOrderMapper.insertWaterOrder(waterOrder);
    }

    @Override
    public List<WaterOrder> getWaterOrderByUser(String userId) {
        return waterOrderMapper.getWaterOrderByUser(userId);
    }

    @Override
    public List<WaterOrder> getWaterOrderByBuilding(String buildingId, int startRow, int pageSize) {
        return waterOrderMapper.getWaterOrderByBuilding(buildingId, startRow, pageSize);
    }

    @Override
    public List<WaterOrder> getWaterOrderByRoom(String buildingId, String roomId, int startRow, int pageSize) {
        return waterOrderMapper.getWaterOrderByRoom(buildingId, roomId, startRow, pageSize);
    }

    @Override
    public List<WaterOrder> getAllWaterOrder(int startRow, int pageSize) {
        return waterOrderMapper.getAllWaterOrder(startRow, pageSize);
    }

    @Override
    public int getAllWaterOrderCount() {
        return waterOrderMapper.getAllWaterOrderCount();
    }

    @Override
    public int getBuildingWaterOrderCount(String buildingId) {
        return waterOrderMapper.getBuildingWaterOrderCount(buildingId);
    }

    @Override
    public int getRoomWaterOrderCount(String buildingId, String roomId) {
        return waterOrderMapper.getRoomWaterOrderCount(buildingId, roomId);
    }


}
