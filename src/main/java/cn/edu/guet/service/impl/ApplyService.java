package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.ApplyMapper;
import cn.edu.guet.service.IApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyService implements IApplyService {
    @Autowired
    private ApplyMapper applyMapper;

    @Override
    public List<Apply> addApply(String applyId, String message,String reply,String sqlMessage) {
        return applyMapper.addApply(applyId,message,reply,sqlMessage);
    }

    @Override
    public List<Apply> lookApply() {
      return applyMapper.lookApply();
    }

    @Override
    public List<Student> updateApply(String sql, String sId) {
      return applyMapper.updateApply(sql,sId);
    }

    @Override
    public List<Apply> updateState(String reply, String sqlMessage) {
      return applyMapper.updateState(reply,sqlMessage);
    }
}
