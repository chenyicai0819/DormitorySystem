package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Build;
import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.mapper.DormitoryMapper;
import cn.edu.guet.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryService implements IDormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Dormitory> getDormitoryM() {
        return dormitoryMapper.getDormitoryM();
    }

    @Override
    public List<Build> getDormBuid() {
        return dormitoryMapper.getDormBuid();
    }
}
