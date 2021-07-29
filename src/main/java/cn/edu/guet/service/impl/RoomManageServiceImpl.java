package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Room;
import cn.edu.guet.mapper.OperationlogMapper;
import cn.edu.guet.mapper.RoomManageMapper;
import cn.edu.guet.service.IRoomManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
@Service
public class RoomManageServiceImpl implements IRoomManageService {
    @Autowired
    private RoomManageMapper roomManageMapper;
    @Autowired
    private OperationlogMapper operationlogMapper;
    @Override
    public List<Room> getRoom(int currentPage,int allPage) {
        currentPage=(currentPage-1)*4;
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put("currentPage",currentPage);
        map.put("allPage",allPage);
        return roomManageMapper.getRoom(map);
    }

    @Override
    public List<Room> getrId(Room room) {
        return roomManageMapper.getrId(room);

    }
//    @Override
//    public void updateRoom(Room room) {
//        roomMapper.updateRoom(room);
//    }

    @Override
    public void addRoom(Room room) {
        String opName=" insert into room values("+room.getrId()+","+room.getrBed()+","+room.getBuid()+")";
        operationlogMapper.insertLog("添加了一条房间信息："+opName);
        roomManageMapper.addRoom(room);
    }

    @Override
    public void deleteRoom(Room room) {
        String opName="删除了一条房间信息 ";
        operationlogMapper.insertLog(opName);
        roomManageMapper.deleteRoom(room);
    }

    @Override
    public int getRoomPage() {
        return roomManageMapper.getRoomPage();
    }


}
