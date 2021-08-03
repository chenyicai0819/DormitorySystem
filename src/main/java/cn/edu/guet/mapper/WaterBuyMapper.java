package cn.edu.guet.mapper;

import cn.edu.guet.bean.Room;
import cn.edu.guet.bean.Student;
import cn.edu.guet.bean.Water;
import cn.edu.guet.bean.Waterorder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface WaterBuyMapper {
    public List<Water> getWater();
    public int countWater();
    public int countWaterbuid(String buid);
    public List<Student> getStudent();
    public List<Room> getAllRoom(String buid);
    public List<Waterorder> insertOrder(String woId, String buid, int woNum, String woRoom, double woMoney,String woUser);
    public List<Waterorder> getAllOrder(String woUser);
    public void upWaterNum(Map<String,Object> map);
}
