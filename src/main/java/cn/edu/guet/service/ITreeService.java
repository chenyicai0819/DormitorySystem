package cn.edu.guet.service;

import cn.edu.guet.bean.Board;
import cn.edu.guet.bean.Tree;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.service
 * @date 2021/7/15 21:36
 * @since 1.0
 */

public interface ITreeService {
    List<Tree> getAllTree(String roId);
    Board seeBoard();
}
