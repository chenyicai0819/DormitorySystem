package cn.edu.guet.mapper;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.bean.Room;
import cn.edu.guet.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StuMessageMapper {
    public List<Student> getStuMessage();
    public List<Room> getDormBuid();
    public List<Room> getDormRoom(String buid);
    public List<Room> getDormBed(String buid,String rId);
    public List<Apply> ApplyRecode();
}
