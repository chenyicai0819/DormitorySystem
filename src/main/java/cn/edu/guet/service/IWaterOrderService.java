package cn.edu.guet.service;

import cn.edu.guet.bean.WaterOrder;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IWaterOrderService {
    void insertWaterOrder(WaterOrder waterOrder);
    List<WaterOrder> getWaterOrderByUser(String userId);
    PageInfo getWaterOrderByBuilding(String buildingId, int pageNum, int pageSize);
    PageInfo getWaterOrderByRoom(String buildingId, String roomId, int pageNum, int pageSize);
    PageInfo getAllWaterOrder(int pageNum, int pageSize);
    PageInfo test();
}
