package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.OperationlogMapper;
import cn.edu.guet.mapper.StudentMapper;
import cn.edu.guet.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private OperationlogMapper operationlogMapper;
    @Override
    public List<Student> getStudent() {
        return studentMapper.getStudent();
    }

    @Override
    public void deleteStudent(String sId) {
        String sql="DELETE FROM student where sId="+sId;
        operationlogMapper.insertLog("删除了一条学生信息："+sql);
        studentMapper.deleteStudent(sId);
    }

    @Override
    public void updateStudent(Student student) {
        String opName="修改了一条学生信息";
        operationlogMapper.insertLog(opName);
    studentMapper.updateStudent(student);
    }

    @Override
    public void addStudent(Student student) {
        String sql="INSERT INTO student values("+student.getsId()+","+student.getRoleId()+","+student.getBuid()+","+student.getrId()+","+student.getrBed()+","+student.getsPwd()+","+student.getsName()+","+student.getsSex()+","+student.getsCollege()+","+student.getsGrade()+","+student.getsPhone()+")";

        operationlogMapper.insertLog("添加了一条学生信息："+sql);
        studentMapper.addStudent(student);
    }

    @Override
    public List<Student> searchStudent(int sId) {
        String opName="select * from student where sId="+sId;
        List<Student> students=studentMapper.searchStudent(sId);
        operationlogMapper.insertLog("查询学生信息："+opName);
        return students;
    }

    @Override
    public int getStudentCount() {
        return studentMapper.getStudentCount();
    }
}
