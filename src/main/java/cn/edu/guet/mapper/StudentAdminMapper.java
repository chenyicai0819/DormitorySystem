package cn.edu.guet.mapper;

import cn.edu.guet.bean.Student;
import cn.edu.guet.bean.Tree;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface StudentAdminMapper {
    List<Student> getStudent();
    void deleteStudent(String sId);
    void updateStudent(Student student);
    void addStudent(Student student);
    void upRoomisPeople(HashMap<String,Object> map);
    List<Student> searchStudent(int sId);
    int getStudentCount();
}
