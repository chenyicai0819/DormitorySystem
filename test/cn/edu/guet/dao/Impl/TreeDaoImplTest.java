package cn.edu.guet.dao.Impl;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.dao.ITreeDao;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TreeDaoImplTest {

    ITreeDao iTreeDao=new TreeDaoImpl();
    @Test
    public void getAllTree() {
        List<Tree> treeList = new ArrayList<Tree>();
        List<Tree> allTree = iTreeDao.getAllTree();
        int i=0;
        while (i<allTree.size()){
            System.out.println(allTree.get(i));
            i++;
        }
    }
}