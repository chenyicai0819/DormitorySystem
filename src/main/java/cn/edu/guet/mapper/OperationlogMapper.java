package cn.edu.guet.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationlogMapper {
    void insertLog(String opName);
}
