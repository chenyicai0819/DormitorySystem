package cn.edu.guet.mapper;

import cn.edu.guet.bean.Waterorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface WaterOrderMapper {
    void insertWaterOrder(Waterorder waterOrder);
    List<Waterorder> getWaterOrderByUser(String userId);
    List<Waterorder> getWaterOrderByBuilding(@Param("buildingId") String buildingId);
    List<Waterorder> getWaterOrderByRoom(@Param("buildingId") String buildingId, @Param("roomId") String roomId);
    List<Waterorder> getAllWaterOrder();
    int getAllWaterOrderCount();
    int getBuildingWaterOrderCount(String buildingId);
    int getRoomWaterOrderCount(@Param("buildingId") String buildingId, @Param("roomId") String roomId);
    List<Waterorder> getTest();
}
