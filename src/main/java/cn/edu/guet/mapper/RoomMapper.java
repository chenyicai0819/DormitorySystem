package cn.edu.guet.mapper;

import cn.edu.guet.bean.Build;
import cn.edu.guet.bean.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author lihehuang
 * @Project DormitorySystem
 * @Package cn.edu.guet.mapper
 * @Date 2021/7/20 15:10
 */
@Mapper
public interface RoomMapper {
    List<Build> viewBuild();
    List<Room> viewRoom(String buId,String buNo);
    Room selectRoom(String buId,String rId);
}
