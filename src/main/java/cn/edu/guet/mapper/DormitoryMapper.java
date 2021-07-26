package cn.edu.guet.mapper;

import cn.edu.guet.bean.Build;
import cn.edu.guet.bean.Dormitory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DormitoryMapper {
    public List<Dormitory> getDormitoryM();
    public List<Build> getDormBuid();
}
