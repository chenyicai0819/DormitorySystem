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
    public String viewIndex(HttpServletRequest request, Model model, HttpServletResponse response,HttpSession session){
        String roId= (String) session.getAttribute("roleId");
        request.setAttribute("tree",treeService.getAllTree(roId));
        return "index";
    }

    @RequestMapping("login.do")
    public String login(HttpServletRequest request,Model model,HttpSession session){
        session.invalidate();
        HttpSession session1 = request.getSession();
        request.setAttribute("board",treeService.seeBoard());
        model.addAttribute("board",treeService.seeBoard());
        session1.setAttribute("msg","退出登录");

        return "login";
    }
}
