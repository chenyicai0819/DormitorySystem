package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Build;
import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.mapper.DormitoryMeggerMapper;
import cn.edu.guet.service.IDormitoryMeggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DormitoryMeggerService implements IDormitoryMeggerService {
    @Autowired
    private DormitoryMeggerMapper dormitoryMeggerMapper;

    @Override
    public List<Dormitory> getDormitoryM() {
        return dormitoryMeggerMapper.getDormitoryM();
    }

    @Override
    public List<Build> getDormBuid() {
        return dormitoryMeggerMapper.getDormBuid();
    }
}
