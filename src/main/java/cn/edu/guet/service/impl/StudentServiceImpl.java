package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.StudentMapper;
import cn.edu.guet.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper StudentMapper;

    @Override
    public List<Student> stuManage() {
        return StudentMapper.stuManage();
    }

    @Override
    public List<Student> searchStu(int studentId) {
        return StudentMapper.searchStu(studentId);
    }

}
