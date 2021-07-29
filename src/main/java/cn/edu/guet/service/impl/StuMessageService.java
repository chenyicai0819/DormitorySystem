package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Apply;
import cn.edu.guet.bean.Room;
import cn.edu.guet.bean.Student;
import cn.edu.guet.mapper.StuMessageMapper;
import cn.edu.guet.service.IStuMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StuMessageService implements IStuMessageService {

    @Autowired
    private StuMessageMapper stuMM;
    @Override
    public List<Student> getStuMessage() {
        return stuMM.getStuMessage();
    }

    @Override
    public List<Room> getDormBuid() {
        return stuMM.getDormBuid();
    }

    @Override
    public List<Room> getDormRoom(String buid) {
        return stuMM.getDormRoom(buid);
    }

    @Override
    public List<Room> getDormBed(String buid, String rId) {
        return stuMM.getDormBed(buid,rId);
    }

    @Override
    public List<Apply> ApplyRecode() {
        return stuMM.ApplyRecode();
    }
}
