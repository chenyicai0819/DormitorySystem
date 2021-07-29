package cn.edu.guet.bean;

/**
 * @author George
 * @project excdemo
 * @package com.example.excdemo.bean
 * @date 2021/7/24 19:59
 * @since 1.0
 */
public class ReturnUtil {
    private static ReturnInfoUtil returnInfoUtil = new ReturnInfoUtil();
    public static ReturnInfoUtil error(String retMag){
        returnInfoUtil.setRetFlag(1);
        returnInfoUtil.setRetMsg(retMag);
        returnInfoUtil.setRetVal("");
        return returnInfoUtil;
    }
    public static ReturnInfoUtil success(Object retVal){
        returnInfoUtil.setRetFlag(0);
        returnInfoUtil.setRetMsg("导入成功");
        returnInfoUtil.setRetVal(retVal);
        return returnInfoUtil;
    }
}
