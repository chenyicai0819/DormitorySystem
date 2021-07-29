package cn.edu.guet.mapper;

import cn.edu.guet.bean.Room;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface RoomManageMapper {
    List<Room> getRoom(HashMap<String,Integer> map);
    void updateRoom(Room room);
    void addRoom(Room room);
    void deleteRoom(Room room);
    List<Room> getrId(Room room);
    int getRoomPage();
}
