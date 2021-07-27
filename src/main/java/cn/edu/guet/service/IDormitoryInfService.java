package cn.edu.guet.service;

import cn.edu.guet.bean.Student;

import java.util.List;

public interface IDormitoryInfService {
    List<Student> getStuInf();
    void updateStuInf(Student student);
    void addStuInf(Student student);
    List<Student> search(String buid);
}
