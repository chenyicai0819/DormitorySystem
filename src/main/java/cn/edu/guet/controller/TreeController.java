package cn.edu.guet.controller;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.dao.ITreeDao;
import cn.edu.guet.dao.Impl.TreeDaoImpl;
import cn.edu.guet.mvc.annotaion.Controller;
import cn.edu.guet.mvc.annotaion.RequestMapping;

import java.util.List;

@Controller
public class TreeController {
    private ITreeDao iTreeDao;

    public void setTreeDao(ITreeDao treeDao) {
        this.iTreeDao = treeDao;
    }
    @RequestMapping("getAllTree.do")
    public List<Tree> getAllTree(){
        return iTreeDao.getAllTree();
    }
}
