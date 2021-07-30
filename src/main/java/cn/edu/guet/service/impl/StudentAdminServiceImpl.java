package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.OperationlogMapper;
import cn.edu.guet.mapper.StudentAdminMapper;
import cn.edu.guet.service.IStudentAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentAdminServiceImpl implements IStudentAdminService {
    @Autowired
    private StudentAdminMapper studentAdminMapper;
    @Autowired
    private OperationlogMapper operationlogMapper;
    @Override
    public List<Student> getStudent() {
        return studentAdminMapper.getStudent();
    }

    @Override
    @Transactional
    public void deleteStudent(String sId) {
        String sql="DELETE FROM student where sId="+sId;
        operationlogMapper.insertLog("删除了一条学生信息："+sql);
        studentAdminMapper.deleteStudent(sId);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        String opName="修改了一条学生信息";
        operationlogMapper.insertLog(opName);
        studentAdminMapper.updateStudent(student);
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        String sql="INSERT INTO student values("+student.getsId()+","+student.getRoleId()+","+student.getBuid()+","+student.getrId()+","+student.getrBed()+","+student.getsPwd()+","+student.getsName()+","+student.getsSex()+","+student.getsCollege()+","+student.getsGrade()+","+student.getsPhone()+")";
        if(null!=student.getrBed()){
          HashMap<String,Object> map=new HashMap<>();
          map.put("rid",student.getrId());
          map.put("bed",student.getrBed());
          studentAdminMapper.upRoomisPeople(map);
        }
        operationlogMapper.insertLog("添加了一条学生信息："+sql);
        studentAdminMapper.addStudent(student);
    }

    @Override
    public List<Student> searchStudent(int sId) {
        List<Student> students= studentAdminMapper.searchStudent(sId);
        return students;
    }

    @Override
    public int getStudentCount() {
        return studentAdminMapper.getStudentCount();
    }
}
