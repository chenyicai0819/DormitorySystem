package cn.edu.guet.controller;

import cn.edu.guet.service.IBoardSeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author George
 * @project DormitorySystem
 * @package cn.edu.guet.controller
 * @date 2021/7/13 10:38
 * @since 1.0
 */

@Controller
public class BoardSeeController {

    @Autowired
    private IBoardSeeService boardService;

    @RequestMapping("SeeAnnoun.do")
    public String SeeAnnoun(HttpServletRequest request, Model model){
        int count=boardService.seeBoardPage();
        int allPage;
        if (count%5==0){
            allPage=count/5;
        }else {
            allPage=(count/5)+1;
        }
        model.addAttribute("allPage",allPage);
        request.setAttribute("board",boardService.seeBoard(1));
        return "SeeAnnoun";
    }
    @RequestMapping("SeeAnnounPage.do")
    public String SeeAnnounPage(HttpServletRequest request, Model model,int curPage){
        int count=boardService.seeBoardPage();
        int allPage;
        if (count%5==0){
            allPage=count/5;
        }else {
            allPage=(count/5)+1;
        }
        model.addAttribute("allPage",allPage);
        request.setAttribute("board",boardService.seeBoard(curPage));
        return "SeeAnnoun::table1";
    }


}
