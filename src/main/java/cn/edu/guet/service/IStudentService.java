package cn.edu.guet.service;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.bean.Student;

import java.util.List;

public interface IStudentService {
    List<Student> stuManage();
    List<Student> searchStu(int studentId);
}
