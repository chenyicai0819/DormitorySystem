package cn.edu.guet.controller;



import cn.edu.guet.service.ITreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;

@Controller
public class TreeController {

    @Autowired
    private ITreeService treeService;

    @GetMapping("getAllTree.do")
    public String viewIndex(HttpServletRequest request){
        request.setAttribute("tree",treeService.getAllTree());
        return "index";
    }

}
