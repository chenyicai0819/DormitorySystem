package cn.edu.guet.service;

import cn.edu.guet.bean.Photo;

import javax.servlet.http.HttpServletResponse;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.service
 * @date 2021/7/21 15:10
 * @since 1.0
 */
public interface IHeadService {
    String addImage(Photo photo,int id);
    String getImage(Integer id, HttpServletResponse response);
}
