package cn.edu.guet.service;

import cn.edu.guet.bean.Repair;

import java.sql.SQLException;
import java.util.List;

public interface IRepairService {
    void repairUp(Repair repair) throws SQLException;
    int repairSele();
    int repairSele(String username);
    int repairStatSele(String stat);
    List<Repair> repairForUs(String reUser,int curPage);
    List<Repair> seeAllRepair(String reStatus);
    void upRepair(String reId);
    void overRepair(String reId);


}
