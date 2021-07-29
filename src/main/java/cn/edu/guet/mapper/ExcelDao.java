package cn.edu.guet.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author George
 * @project excdemo
 * @package com.example.excdemo.mapper
 * @date 2021/7/24 19:55
 * @since 1.0
 */

@Mapper
public interface ExcelDao {
    void addUser(List bankList);
}
