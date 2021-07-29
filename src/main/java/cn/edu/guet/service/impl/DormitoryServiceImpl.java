package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.mapper.DormitoryMapper;
import cn.edu.guet.mapper.OperationlogMapper;
import cn.edu.guet.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
@Service
public class DormitoryServiceImpl implements IDormitoryService {
@Autowired
private DormitoryMapper dormitoryMapper;
@Autowired
private OperationlogMapper operationlogMapper;
    @Override
    public List<Dormitory> getDormitory(int currentPage,int allPage) {
        currentPage=(currentPage-1)*4;
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        map.put("currentPage",currentPage);
        map.put("allPage",allPage);
        System.out.println(map.get(currentPage));
        return dormitoryMapper.getDormitory(map);
    }

    @Override
    @Transactional
    public void deleteDormitory(String dId) {
        String opName="删除了一条舍管信息";
        operationlogMapper.insertLog(opName);
       dormitoryMapper.deleteDormitory(dId);
    }

    @Override
    @Transactional
    public void updateDormitory(Dormitory dormitory) {
        String opName="修改了一条舍管信息";
        operationlogMapper.insertLog(opName);
        dormitoryMapper.updateDormitory(dormitory);
    }

    @Override
    @Transactional
    public void addDormitory(Dormitory dormitory) {
        String opName="添加了一条舍管信息";
        operationlogMapper.insertLog(opName);
        dormitoryMapper.addDormitory(dormitory);
    }

    @Override
    public List<Dormitory> searchDormitory(String dId) {
         return dormitoryMapper.searchDormitory(dId);
    }

    @Override
    public int getDormitoryCount() {
        return dormitoryMapper.getDormitoryCount();
    }
}
