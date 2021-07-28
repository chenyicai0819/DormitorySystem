package cn.edu.guet.service;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.bean.Room;
import cn.edu.guet.bean.Student;

import java.util.List;

public interface IStuMessageService {
    public List<Student> getStuMessage();
    public List<Room> getDormBuid();
    public List<Room> getDormRoom(String buid);
    public List<Room> getDormBed(String buid,String rId);
    public List<Apply> ApplyRecode();
}
