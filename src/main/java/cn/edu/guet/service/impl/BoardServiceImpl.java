package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Board;
import cn.edu.guet.mapper.BoardMapper;
import cn.edu.guet.service.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements IBoardService {

    @Autowired
    private BoardMapper boardMapper;
    @Override
    public List<Board> viewBoard() {
        return boardMapper.viewBoard();
    }

    @Override
    public void saveBoard(Board board) {
        boardMapper.saveBoard(board);
    }
}
