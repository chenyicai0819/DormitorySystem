package cn.edu.guet.mapper;

import cn.edu.guet.bean.Water;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface WaterMapper {
    Water getWaterState(String buildingId);
    List<Water> getAllWaterState();
    void insertWaterState(Water water);
    void updataWaterState(Water water);
//    void updataWaterState(List<Water> waters);
    void delteWaterState(String buildingId);
    void addWaterState(Water water);
    void upWaterMoney(double money);
}
