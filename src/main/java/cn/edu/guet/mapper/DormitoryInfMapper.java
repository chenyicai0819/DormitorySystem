package cn.edu.guet.mapper;

import cn.edu.guet.bean.Student;
import cn.edu.guet.bean.Tree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DormitoryInfMapper {
    List<Student> getStuInf();
    void updateStuInf(Student student);
    void addStuInf(Student student);
    List<Student> search(String buid);
}
