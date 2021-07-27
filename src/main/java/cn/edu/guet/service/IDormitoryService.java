package cn.edu.guet.service;

import cn.edu.guet.bean.Dormitory;

import java.util.List;

public interface IDormitoryService {
    List<Dormitory> getDormitory(int currentPage,int allPage);
    void deleteDormitory(String dId);
    void updateDormitory(Dormitory dormitory);
    void addDormitory(Dormitory dormitory);
    List<Dormitory> searchDormitory(String dId);
    int getDormitoryCount();
}
