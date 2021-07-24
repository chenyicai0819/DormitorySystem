package cn.edu.guet.mapper;

import cn.edu.guet.bean.Water;
import cn.edu.guet.bean.WaterOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface WaterOrderMapper {
    void insertWaterOrder(WaterOrder waterOrder);
    List<WaterOrder> getWaterOrderByUser(String userId);
    List<WaterOrder> getWaterOrderByBuilding(@Param("buildingId") String buildingId, @Param("startRow") int startRow, @Param("pageSize") int pageSize);
    List<WaterOrder> getWaterOrderByRoom(@Param("buildingId") String buildingId, @Param("roomId") String roomId, @Param("startRow") int startRow, @Param("pageSize") int pageSize);
    List<WaterOrder> getAllWaterOrder(@Param("startRow") int startRow, @Param("pageSize") int pageSize);
    int getAllWaterOrderCount();
    int getBuildingWaterOrderCount(String buildingId);
    int getRoomWaterOrderCount(@Param("buildingId") String buildingId, @Param("roomId") String roomId);
}
