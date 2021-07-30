package cn.edu.guet.service;

import cn.edu.guet.bean.Waterorder;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IWaterOrderService {
    void insertWaterOrder(Waterorder waterOrder);
    List<Waterorder> getWaterOrderByUser(String userId);
    PageInfo getWaterOrderByBuilding(String buildingId, int pageNum, int pageSize);
    PageInfo getWaterOrderByRoom(String buildingId, String roomId, int pageNum, int pageSize);
    PageInfo getAllWaterOrder(int pageNum, int pageSize);
    PageInfo test();
}
