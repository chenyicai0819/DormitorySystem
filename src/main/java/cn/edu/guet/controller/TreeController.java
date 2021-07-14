package cn.edu.guet.controller;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.filter.SqlsessionFilter;
import cn.edu.guet.mapper.TreeMapper;
import cn.edu.guet.mvc.annotaion.Controller;
import cn.edu.guet.mvc.annotaion.RequestMapping;
import cn.edu.guet.util.SessionFactory;

import java.util.List;

@Controller
public class TreeController {

    private TreeMapper treeMapper;
    @RequestMapping("getAllTree.do")
    public List<Tree> getAllTree(){
        treeMapper= SqlsessionFilter.getSqlsession().getMapper(TreeMapper.class);
        List<Tree> treeList = treeMapper.getAllTree();
        return treeList;
    }
}
