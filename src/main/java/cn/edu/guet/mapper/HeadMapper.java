package cn.edu.guet.mapper;

import cn.edu.guet.bean.Photo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.mapper
 * @date 2021/7/21 15:09
 * @since 1.0
 */
@Mapper
public interface HeadMapper {
    void insertImage(Photo photo);
    void updateImage(Photo photo);
    Photo selectImageById(Integer id);
}
