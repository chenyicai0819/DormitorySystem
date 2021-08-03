package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Room;
import cn.edu.guet.bean.Student;
import cn.edu.guet.bean.Water;
import cn.edu.guet.bean.Waterorder;
import cn.edu.guet.mapper.WaterBuyMapper;
import cn.edu.guet.service.IWaterBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WaterBuyService implements IWaterBuyService {
    @Autowired
    private WaterBuyMapper waterBuyMapper;
    @Override
    public List<Water> getWater() {
        return waterBuyMapper.getWater();
    }

    @Override
    public int countWater() {
        return waterBuyMapper.countWater();
    }

    @Override
    public List<Student> getStudent() {
        return waterBuyMapper.getStudent();
    }

    @Override
    public List<Room> getAllRoom(String buid) {
        return waterBuyMapper.getAllRoom(buid);
    }

    @Override
    public List<Waterorder> insertOrder(String woId, String buid, int woNum, String woRoom, double woMoney, String woUser) {
      int n=waterBuyMapper.countWaterbuid(buid);
      System.out.println(n);
      System.out.println(woNum);
      int num= n-woNum;
      Map<String,Object> map=new HashMap<>();
      map.put("buid",buid);
      map.put("num",num);
      waterBuyMapper.upWaterNum(map);
      return waterBuyMapper.insertOrder(woId,buid,woNum,woRoom,woMoney,woUser);
    }

    @Override
    public List<Waterorder> getAllOrder(String woUser) {
        return waterBuyMapper.getAllOrder(woUser);
    }
}
