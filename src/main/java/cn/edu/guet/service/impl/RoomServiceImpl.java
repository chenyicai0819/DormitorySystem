package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Build;
import cn.edu.guet.bean.Room;
import cn.edu.guet.mapper.RoomMapper;
import cn.edu.guet.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lihehuang
 * @Project DormitorySystem
 * @Package cn.edu.guet.service.impl
 * @Date 2021/7/20 15:11
 */
@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Build> viewBuild() {
        return roomMapper.viewBuild();
    }

    @Override
    public List<Room> viewRoom(String buId,String buNo) {
        return roomMapper.viewRoom(buId,buNo);
    }

    @Override
    public Room selectRoom(String buId, String rId) {
        return roomMapper.selectRoom(buId,rId);
    }
}