package cn.edu.guet.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {

    void insert(String logId,String logUser,String logTime);

    String findLogId(String logId);
}
