package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Waterorder;
import cn.edu.guet.mapper.WaterOrderMapper;
import cn.edu.guet.service.IWaterOrderService;
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
    public void insertWaterOrder(Waterorder waterOrder) {
        waterOrder.setWoTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(waterOrder.getWoTime());
        waterOrderMapper.insertWaterOrder(waterOrder);
    }

    @Override
    public List<Waterorder> getWaterOrderByUser(String userId) {
        return waterOrderMapper.getWaterOrderByUser(userId);
    }

    @Override
    public PageInfo getWaterOrderByBuilding(String buildingId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Waterorder> waterOrders = waterOrderMapper.getWaterOrderByBuilding(buildingId);
        return new PageInfo(waterOrders);
    }

    @Override
    public PageInfo getWaterOrderByRoom(String buildingId, String roomId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Waterorder> waterorders = waterOrderMapper.getWaterOrderByRoom(buildingId, roomId);
        return new PageInfo(waterorders);
    }

    @Override
    public PageInfo getAllWaterOrder(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Waterorder> waterorders = waterOrderMapper.getAllWaterOrder();
        return new PageInfo(waterorders);
    }


    @Override
    public PageInfo test() {
        PageHelper.startPage(1,5);
        List<Waterorder> waterorders = waterOrderMapper.getTest();
        return new PageInfo(waterorders);
    }


}
