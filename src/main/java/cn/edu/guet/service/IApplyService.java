package cn.edu.guet.service;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IApplyService {
    public List<Apply> addApply(String applyId, String message,String reply,String sqlMessage);
    public List<Apply> lookApply();
    public List<Student> updateApply(String sql, String sId);
    public List<Apply> updateState(String reply,String sqlMessage);
}
