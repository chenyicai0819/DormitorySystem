package cn.edu.guet.service.impl;

import cn.edu.guet.bean.WaterOrder;
import cn.edu.guet.mapper.WaterOrderMapper;
import cn.edu.guet.service.IWaterOrderService;
import cn.edu.guet.service.IWaterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo getWaterOrderByBuilding(String buildingId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WaterOrder> waterOrders = waterOrderMapper.getWaterOrderByBuilding(buildingId);
        return new PageInfo(waterOrders);
    }

    @Override
    public PageInfo getWaterOrderByRoom(String buildingId, String roomId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WaterOrder> waterOrders = waterOrderMapper.getWaterOrderByRoom(buildingId, roomId);
        return new PageInfo(waterOrders);
    }

    @Override
    public PageInfo getAllWaterOrder(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WaterOrder> waterOrders = waterOrderMapper.getAllWaterOrder();
        return new PageInfo(waterOrders);
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

    @Override
    public PageInfo test() {
        PageHelper.startPage(1,5);
        List<WaterOrder> waterOrders = waterOrderMapper.getTest();
        return new PageInfo(waterOrders);
    }


}
