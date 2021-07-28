package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.DormitoryInfMapper;
import cn.edu.guet.mapper.OperationlogMapper;
import cn.edu.guet.service.IDormitoryInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DormitoryInfServiceImpl implements IDormitoryInfService {
    @Autowired
    private DormitoryInfMapper dormitoryInfMapper;
    @Autowired
    private OperationlogMapper operationlogMapper;
    @Override
    public List<Student> getStuInf() {
        return dormitoryInfMapper.getStuInf();
    }

    @Override
    public void updateStuInf(Student student) {
        String opName="修改了一条宿舍信息";
        operationlogMapper.insertLog(opName);
        dormitoryInfMapper.updateStuInf(student);
    }

    @Override
    public void addStuInf(Student student) {
        String opName="添加了一条宿舍信息";
        operationlogMapper.insertLog(opName);
        dormitoryInfMapper.addStuInf(student);
    }

    @Override
    public List<Student> search(String buid) {

        return dormitoryInfMapper.search(buid);
    }
}
