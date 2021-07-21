package cn.edu.guet.service;

import cn.edu.guet.bean.Build;
import cn.edu.guet.bean.Room;

import java.util.List;

/**
 * @Author lihehuang
 * @Project DormitorySystem
 * @Package cn.edu.guet.service
 * @Date 2021/7/20 15:11
 */
public interface IRoomService {
    List<Build> viewBuild();
    List<Room> viewRoom(String buId,String buNo);
    Room selectRoom(String buId,String rId);
}
