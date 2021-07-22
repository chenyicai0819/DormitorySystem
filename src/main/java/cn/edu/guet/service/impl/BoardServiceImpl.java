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
    public Board selectBoard(String boId) {
        return boardMapper.selectBoard(boId);
    }


    @Override
    public void saveBoard(Board board) {
        boardMapper.saveBoard(board);
    }

    @Override
    public void deleteBoard(String boId) {
        boardMapper.deleteBoard(boId);
    }

    @Override
    public void saveModifyBoard(Board board) {
        boardMapper.saveModifyBoard(board);
    }

    @Override
    public List<Board> searchBoard(Board board) {
        return boardMapper.searchBoard(board);
    }
}
