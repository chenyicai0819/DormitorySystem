package cn.edu.guet.controller;



import cn.edu.guet.service.ITreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class TreeController {

    @Autowired
    private ITreeService treeService;


    @GetMapping("getAllTree.do")
    public String viewIndex(HttpServletRequest request, Model model, HttpServletResponse response){
        request.setAttribute("tree",treeService.getAllTree());
        //model.addAttribute("username","陈益财");
        HttpSession session=request.getSession();
        session.setAttribute("userId","1800710318");
        session.setAttribute("roleeId","ro103");
        session.setAttribute("username","陈益财");
        return "index";
    }

    @RequestMapping("login.do")
    public String login(HttpServletRequest request,Model model){
        request.setAttribute("board",treeService.seeBoard());
        model.addAttribute("board",treeService.seeBoard());
        return "logintest";
    }
}
