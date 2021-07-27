package cn.edu.guet.mapper;

import cn.edu.guet.bean.Dormitory;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface DormitoryMapper {
    List<Dormitory> getDormitory(HashMap<String,Integer> map);
    void deleteDormitory(String dId);
    void updateDormitory(Dormitory dormitory);
    void addDormitory(Dormitory dormitory);
    List<Dormitory> searchDormitory(String dId);
    int getDormitoryCount();
}
