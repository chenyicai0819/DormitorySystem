package cn.edu.guet.service;

import cn.edu.guet.bean.WaterOrder;

import java.util.List;

public interface IWaterOrderService {
    void insertWaterOrder(WaterOrder waterOrder);
    List<WaterOrder> getWaterOrderByUser(String userId);
    List<WaterOrder> getWaterOrderByBuilding(String buildingId, int startRow, int pageSize);
    List<WaterOrder> getWaterOrderByRoom(String buildingId, String roomId, int startRow, int pageSize);
    List<WaterOrder> getAllWaterOrder(int startRow, int pageSize);
    int getAllWaterOrderCount();
    int getBuildingWaterOrderCount(String buildingId);
    int getRoomWaterOrderCount(String buildingId, String roomId);
}
