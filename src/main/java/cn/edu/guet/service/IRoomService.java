package cn.edu.guet.service;

import cn.edu.guet.bean.Build;
import cn.edu.guet.bean.Room;
import cn.edu.guet.bean.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author lihehuang
 * @Project DormitorySystem
 * @Package cn.edu.guet.service
 * @Date 2021/7/20 15:11
 */
public interface IRoomService {
    List<Build> viewBuild();
    List<String> viewRoom(String buId,String buNo);
    List<Student> selectStudent(String rId);
    void changeRoom(String rId,String rBed,String sId,String buId);
    void changeRoomStat_in(String rId,String rBed);
    void changeRoomStat_out(String rId,String rBed);
    List<Map<String,Object>> viewRooms(List<String> rIds);
    List<Map<String,Object>> viewEmptyRooms(List<String> rIds);
    Student selectStudentById(String sId);
}
