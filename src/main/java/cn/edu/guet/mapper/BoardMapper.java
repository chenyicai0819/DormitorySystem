package cn.edu.guet.mapper;

import cn.edu.guet.bean.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> viewBoard();
    void saveBoard(Board board);
}
