package cn.edu.guet.mapper;

import cn.edu.guet.bean.Repair;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author George
 * @date 2021/7/6 9:45
 * @since 1.0
 */
@Mapper
public interface RepairMapper {
    void repairUp(Repair repair) throws SQLException;
    int repairSele(String repairname);
    int repairStatSele(String stat);
    List<Repair> repairForUs(Map<String, Object> map);
    List<Repair> seeAllRepair(Map<String, Object> map);
    void upRepair(String reId);
    void overRepair(String reId);
    int repairSeleAll();
}
