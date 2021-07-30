package cn.edu.guet.mapper;

import cn.edu.guet.bean.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> viewBoard();
    Board selectBoard(String boId);
    void saveBoard(Board board);
    void deleteBoard(String boId);
    void saveModifyBoard(Board board);
    List<Board> searchBoard(Board board);
}
