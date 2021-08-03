package cn.edu.guet.service;

import cn.edu.guet.bean.Room;
import cn.edu.guet.bean.Student;
import cn.edu.guet.bean.Water;
import cn.edu.guet.bean.Waterorder;

import java.util.Date;
import java.util.List;

public interface IWaterBuyService {
    public List<Water> getWater();
    public int countWater();
    public List<Student> getStudent();
    public List<Room> getAllRoom(String buid);
    public List<Waterorder> insertOrder(String woId, String buid, int woNum, String woRoom, double woMoney, String woUser);
    public List<Waterorder> getAllOrder(String woUser);
}
