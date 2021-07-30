package cn.edu.guet.mapper;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> stuManage();
    List<Student> searchStu(int studentId);
}
