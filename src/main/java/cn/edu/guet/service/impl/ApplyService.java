package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Apply;
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
    public List<Apply> addApply(String applyId, String message,String reply) {
        return applyMapper.addApply(applyId,message,reply);
    }

//    @Override
//    public List<Apply> ApplyRecode() {
//        return applyMapper.ApplyRecode();
//    }
}
