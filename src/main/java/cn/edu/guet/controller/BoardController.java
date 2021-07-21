package cn.edu.guet.controller;

import cn.edu.guet.bean.Board;
import cn.edu.guet.service.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;


@Controller
public class BoardController {
    @Autowired
    private IBoardService boardService;

    @GetMapping("viewBoard")
    public String viewBoard(HttpServletRequest request){
        request.setAttribute("boards",boardService.viewBoard());
        return "board/viewBoard";
    }

    @GetMapping("editBoard")
    public String editBoard(HttpServletRequest request){
        request.setAttribute("boards",boardService.viewBoard());
        return "board/editBoard";
    }

    @GetMapping("addBoard")
    public String addBoard(){
        return "board/addBoard";
    }

    @GetMapping("saveBoard")
    public String saveBoard(HttpServletRequest request){
        Board board=new Board();
        board.setBoId(request.getParameter("boId"));
        board.setBoName(request.getParameter("boName"));
        board.setBoContent(request.getParameter("boContent"));
        System.out.println(request.getParameter("boTime"));
        board.setBoTime(Date.valueOf((request.getParameter("boTime"))));
        board.setBoUser(request.getParameter("boUser"));
        boardService.saveBoard(board);
        request.setAttribute("boards",boardService.viewBoard());
        return "board/editBoard";
    }

    @GetMapping("deleteBoard")
    public String deleteBoard(HttpServletRequest request){
        boardService.deleteBoard(request.getParameter("boId"));
        request.setAttribute("boards",boardService.viewBoard());
        return "board/editBoard";
    }

    @GetMapping("modifyBoard")
    public String modifyBoard(HttpServletRequest request){
        request.setAttribute("board",boardService.selectBoard(request.getParameter("boId")));
        return "board/modifyBoard";
    }

    @GetMapping("saveModifyBoard")
    public String saveModifyBoard(HttpServletRequest request){
        Board board=new Board();
        board.setBoId(request.getParameter("boId"));
        board.setBoName(request.getParameter("boName"));
        board.setBoContent(request.getParameter("boContent"));
        System.out.println(request.getParameter("boTime"));
        board.setBoTime(Date.valueOf((request.getParameter("boTime"))));
        board.setBoUser(request.getParameter("boUser"));
        boardService.saveModifyBoard(board);
        request.setAttribute("boards",boardService.viewBoard());
        return "board/editBoard";
    }
}
