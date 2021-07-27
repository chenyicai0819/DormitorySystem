package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Room;
import cn.edu.guet.mapper.OperationlogMapper;
import cn.edu.guet.mapper.RoomMapper;
import cn.edu.guet.service.IRoomService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private OperationlogMapper operationlogMapper;
    @Override
    public List<Room> getRoom(int currentPage,int allPage) {
        currentPage=(currentPage-1)*4;
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put("currentPage",currentPage);
        map.put("allPage",allPage);
        return roomMapper.getRoom(map);
    }

    @Override
    public List<Room> getrId(Room room) {
        return roomMapper.getrId(room);

    }
//    @Override
//    public void updateRoom(Room room) {
//        roomMapper.updateRoom(room);
//    }

    @Override
    public void addRoom(Room room) {
        String opName=" insert into room values("+room.getrId()+","+room.getrBed()+","+room.getBuid()+")";
        operationlogMapper.insertLog("添加了一条房间信息："+opName);
        roomMapper.addRoom(room);
    }

    @Override
    public void deleteRoom(Room room) {
        String opName="删除了一条房间信息 ";
        operationlogMapper.insertLog(opName);
        roomMapper.deleteRoom(room);
    }

    @Override
    public int getRoomPage() {
        return roomMapper.getRoomPage();
    }


}
