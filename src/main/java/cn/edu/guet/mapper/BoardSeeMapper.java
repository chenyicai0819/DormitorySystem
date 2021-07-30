package cn.edu.guet.mapper;

import cn.edu.guet.bean.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.mapper
 * @date 2021/7/13 10:39
 * @since 1.0
 */

@Mapper
public interface BoardSeeMapper {
    List<Board> seeBoard(int start);
    int seeBoardPage();
}
