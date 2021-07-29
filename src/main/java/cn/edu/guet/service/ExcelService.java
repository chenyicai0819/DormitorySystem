package cn.edu.guet.service;


import cn.edu.guet.bean.ReturnInfoUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author George
 * @project excdemo
 * @package com.example.excdemo.service.impl
 * @date 2021/7/24 19:53
 * @since 1.0
 */
@Service
public interface ExcelService {
    ReturnInfoUtil getExcelInfo(String fileName, MultipartFile file) throws Exception;
}
