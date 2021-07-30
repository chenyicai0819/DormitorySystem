package cn.edu.guet.service;

import cn.edu.guet.bean.Student;

import java.util.List;

public interface IStudentAdminService {
    List<Student> getStudent();
    void deleteStudent(String sId);
    void updateStudent(Student student);
    void addStudent(Student student);
    List<Student> searchStudent(int sId);
    int getStudentCount();
}
