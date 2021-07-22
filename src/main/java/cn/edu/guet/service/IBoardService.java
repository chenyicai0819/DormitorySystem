package cn.edu.guet.service;

import cn.edu.guet.bean.Board;

import java.util.List;

public interface IBoardService {
    List<Board> viewBoard();
    Board selectBoard(String boId);
    void saveBoard(Board board);
    void deleteBoard(String boId);
    void saveModifyBoard(Board board);
    List<Board> searchBoard(Board board);
}
