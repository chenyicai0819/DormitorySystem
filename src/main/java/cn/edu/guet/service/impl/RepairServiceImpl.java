package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Repair;
import cn.edu.guet.mapper.RepairMapper;
import cn.edu.guet.service.IRepairService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RepairServiceImpl implements IRepairService {

    @Autowired
    private RepairMapper repairMapper;


    @Override
    public void repairUp(Repair repair) throws SQLException {
        try {
            repairMapper.repairUp(repair);
            System.out.println("操作成功");
        } catch (SQLException e){
            System.out.println("回滚");
        }
    }

  @Override
  public int repairSele() {
    return repairMapper.repairSeleAll();
  }

  @Override
    public int repairSele(String repairname) {
        return repairMapper.repairSele(repairname);
    }

    @Override
    public int repairStatSele(String stat) {
        return repairMapper.repairStatSele(stat);
    }

    @Override
    public List<Repair> repairForUs(String reUser,int curPage) {

        int start=(curPage-1)*5;
        HashMap<String,Object> map = new HashMap<>();
        map.put("reUser",reUser);
        map.put("start", start);
        return repairMapper.repairForUs(map);
    }

    @Override
    public List<Repair> seeAllRepair(String reStatus) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("reStatus",reStatus);
        return repairMapper.seeAllRepair(map);
    }

    @Override
    public void upRepair(String reId) {
        repairMapper.upRepair(reId);
        System.out.println("操作成功");
    }

    @Override
    public void overRepair(String reId) {
        repairMapper.overRepair(reId);
        System.out.println("操作成功");
    }
}
