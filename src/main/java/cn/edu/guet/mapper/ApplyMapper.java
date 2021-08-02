package cn.edu.guet.mapper;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApplyMapper {
    public List<Apply> addApply(String applyId,String message,String reply,String sqlMessage);
    public List<Apply> lookApply();
    public List<Student> updateApply(String sql, String sId);
    public List<Apply> updateState(String reply,String sqlMessage);
}
