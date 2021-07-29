package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.OperationlogMapper;
import cn.edu.guet.mapper.StudentMapper;
import cn.edu.guet.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Transactional
    public void deleteStudent(String sId) {
        String sql="DELETE FROM student where sId="+sId;
        operationlogMapper.insertLog("删除了一条学生信息："+sql);
        studentMapper.deleteStudent(sId);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        String opName="修改了一条学生信息";
        operationlogMapper.insertLog(opName);
        studentMapper.updateStudent(student);
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        String sql="INSERT INTO student values("+student.getsId()+","+student.getRoleId()+","+student.getBuid()+","+student.getrId()+","+student.getrBed()+","+student.getsPwd()+","+student.getsName()+","+student.getsSex()+","+student.getsCollege()+","+student.getsGrade()+","+student.getsPhone()+")";
        if(null!=student.getrBed()){
          HashMap<String,Object> map=new HashMap<>();
          map.put("rid",student.getrId());
          map.put("bed",student.getrBed());
          studentMapper.upRoomisPeople(map);
        }
        operationlogMapper.insertLog("添加了一条学生信息："+sql);
        studentMapper.addStudent(student);
    }

    @Override
    public List<Student> searchStudent(int sId) {
        List<Student> students=studentMapper.searchStudent(sId);
        return students;
    }

    @Override
    public int getStudentCount() {
        return studentMapper.getStudentCount();
    }
}
