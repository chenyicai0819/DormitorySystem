package cn.edu.guet.service;

import cn.edu.guet.bean.Water;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IWaterService {
    Water getWaterState(String buildingId);
    List<Water> getAllWaterState();
    List<Water> getLimitWaterState(int startRow, int pageSize);
    int getWaterStateCount();
    void insertWaterState(Water water);
    void updataWaterState(Water water);
    void delteWaterState(String buildingId);
    void addWaterState(Water water);

}
