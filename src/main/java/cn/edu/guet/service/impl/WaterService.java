package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Room;
import cn.edu.guet.bean.Student;
import cn.edu.guet.bean.Water;
import cn.edu.guet.bean.Waterorder;
import cn.edu.guet.mapper.WaterMapper;
import cn.edu.guet.service.IWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WaterService implements IWaterService {
    @Autowired
    private WaterMapper waterMapper;
    @Override
    public List<Water> getWater() {
        return waterMapper.getWater();
    }

    @Override
    public int countWater() {
        return waterMapper.countWater();
    }

    @Override
    public List<Student> getStudent() {
        return waterMapper.getStudent();
    }

    @Override
    public List<Room> getAllRoom(String buid) {
        return waterMapper.getAllRoom(buid);
    }

    @Override
    public List<Waterorder> insertOrder(String woId, String buid, int woNum, String woRoom, int woMoney, String woUser) {
      int num=waterMapper.countWaterbuid(buid)-woNum;
      Map<String,Object> map=new HashMap<>();
      map.put("buid",buid);
      map.put("num",num);
      waterMapper.upWaterNum(map);
      return waterMapper.insertOrder(woId,buid,woNum,woRoom,woMoney,woUser);
    }

    @Override
    public List<Waterorder> getAllOrder(String woUser) {
        return waterMapper.getAllOrder(woUser);
    }
}
