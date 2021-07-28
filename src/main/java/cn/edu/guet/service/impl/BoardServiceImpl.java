package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Board;
import cn.edu.guet.mapper.BoardMapper;
import cn.edu.guet.service.IBoardService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.bll.impl
 * @date 2021/7/13 10:39
 * @since 1.0
 */

@Service
public class BoardServiceImpl implements IBoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> seeBoard(int curPage) {
        int start=(curPage-1)*5;
        return boardMapper.seeBoard(start);
    }

    @Override
    public int seeBoardPage() {
        return boardMapper.seeBoardPage();
    }

}
