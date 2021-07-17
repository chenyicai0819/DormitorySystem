package cn.edu.guet.service;

import cn.edu.guet.bean.Board;

import java.util.List;

public interface IBoardService {
    List<Board> viewBoard();
    void saveBoard(Board board);
}
