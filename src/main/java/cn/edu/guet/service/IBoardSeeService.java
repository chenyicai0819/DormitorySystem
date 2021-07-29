package cn.edu.guet.service;

import cn.edu.guet.bean.Board;

import java.util.List;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.bll
 * @date 2021/7/13 10:39
 * @since 1.0
 */
public interface IBoardSeeService {
    List<Board> seeBoard(int curPage);
    int seeBoardPage();
}
