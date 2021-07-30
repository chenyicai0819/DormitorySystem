package cn.edu.guet.service;

import cn.edu.guet.bean.Water;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IWaterService {
    PageInfo getAllWaterState(int pageNum, int pageSize);
    void insertWaterState(Water water);
    void updataWaterState(Water water);
    void delteWaterState(String buildingId);
    void addWaterState(Water water);
    void upWaterMoney(double money);
}
