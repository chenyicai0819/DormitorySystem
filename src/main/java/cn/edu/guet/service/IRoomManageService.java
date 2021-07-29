package cn.edu.guet.service;

import cn.edu.guet.bean.Room;

import java.util.List;

public interface IRoomManageService {
    List<Room> getRoom(int currentPage,int allPage);
    List<Room> getrId(Room room);
    //void updateRoom(Room room );
    void addRoom(Room room);
    void deleteRoom(Room room);
    int getRoomPage();
}
