package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Build;
import cn.edu.guet.bean.Room;
import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.RoomMapper;
import cn.edu.guet.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public List<String> viewRoom(String buId,String buNo) {
        return roomMapper.viewRoom(buId,buNo);
    }

    @Override
    public List<Student> selectStudent(String rId) {
        return roomMapper.selectStudent(rId);
    }

    @Override
    public void changeRoom(String rId, String rBed,String sId,String buId) {
        roomMapper.changeRoom(rId,rBed,sId,buId);
    }

    @Override
    public void changeRoomStat_in(String rId, String rBed) {
        roomMapper.changeRoomStat_in(rId,rBed);
    }

    @Override
    public void changeRoomStat_out(String rId, String rBed) {
        roomMapper.changeRoomStat_out(rId,rBed);
    }

    @Override
    public List<Map<String, Object>> viewRooms(List<String> rIds) {
        return roomMapper.viewRooms(rIds);
    }

    @Override
    public List<Map<String, Object>> viewEmptyRooms(List<String> rIds) {
        return roomMapper.viewEmptyRooms(rIds);
    }

    @Override
    public Student selectStudentById(String sId) {
        return roomMapper.selectStudentById(sId);
    }


}
