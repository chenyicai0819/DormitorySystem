package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Board;
import cn.edu.guet.bean.Tree;
import cn.edu.guet.mapper.TreeMapper;
import cn.edu.guet.service.ITreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.service.impl
 * @date 2021/7/15 21:37
 * @since 1.0
 */

@Service
public class TreeServiceImpl implements ITreeService {

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<Tree> getAllTree(String roId) {
        return treeMapper.getAllTree(roId);
    }

    @Override
    public Board seeBoard() {
        return treeMapper.seeBoard();
    }
}
