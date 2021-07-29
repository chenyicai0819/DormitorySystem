package cn.edu.guet.controller;

import cn.edu.guet.bean.Board;
import cn.edu.guet.service.IBoardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;


@Controller
public class BoardController {
    @Autowired
    private IBoardService boardService;

    @GetMapping("viewBoard")
    public String viewBoard(HttpServletRequest request){
        request.setAttribute("boards",boardService.viewBoard());
        return "board/viewBoard";
    }

    @GetMapping("EditAnnoun.do")
    public String editBoard(HttpServletRequest request,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Board> boardList=boardService.viewBoard();
        PageInfo<Board> pageInfo=new PageInfo<>(boardList);
        request.setAttribute("allPage",pageInfo.getPages());
        request.setAttribute("maxPage",pageInfo.getTotal());
        request.setAttribute("boards",boardList);
        return "board/editBoard";
    }

    @RequestMapping("editBoards")
    public String editBoards(HttpServletRequest request,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        System.out.println(pageNum);
        PageHelper.startPage(pageNum,5);
        List<Board> boardList=boardService.viewBoard();
        PageInfo<Board> pageInfo=new PageInfo<>(boardList);
        request.setAttribute("allPage",pageInfo.getPages());
        request.setAttribute("maxPage",pageInfo.getTotal());
        request.setAttribute("boards",boardList);
        return "board/editBoard::table";
    }


    @GetMapping("saveBoard")
    public String saveBoard(HttpServletRequest request,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        Board board=new Board();
        board.setBoId(request.getParameter("boId"));
        board.setBoName(request.getParameter("boName"));
        board.setBoContent(request.getParameter("boContent"));
        System.out.println(request.getParameter("boTime"));
        board.setBoTime(Date.valueOf((request.getParameter("boTime"))));
        board.setBoUser(request.getParameter("boUser"));
        boardService.saveBoard(board);
        PageHelper.startPage(pageNum,5);
        List<Board> boardList=boardService.viewBoard();
        PageInfo<Board> pageInfo=new PageInfo<>(boardList);
        request.setAttribute("allPage",pageInfo.getPages());
        request.setAttribute("maxPage",pageInfo.getTotal());
        request.setAttribute("boards",boardList);
        return "board/editBoard";
    }

    @GetMapping("deleteBoard")
    public String deleteBoard(HttpServletRequest request,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        boardService.deleteBoard(request.getParameter("boId"));
        PageHelper.startPage(pageNum,5);
        List<Board> boardList=boardService.viewBoard();
        PageInfo<Board> pageInfo=new PageInfo<>(boardList);
        request.setAttribute("allPage",pageInfo.getPages());
        request.setAttribute("maxPage",pageInfo.getTotal());
        request.setAttribute("boards",boardList);
        return "board/editBoard";
    }

    @GetMapping("modifyBoard")
    public String modifyBoard(HttpServletRequest request){
        if(request.getParameter("boId").equals("")){
            request.setAttribute("board","");
        }else {
            request.setAttribute("board", boardService.selectBoard(request.getParameter("boId")));
        }
        return "board/modifyBoard";
    }

    @GetMapping("saveModifyBoard")
    public String saveModifyBoard(HttpServletRequest request,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        Board board=new Board();
        board.setBoId(request.getParameter("boId"));
        board.setBoName(request.getParameter("boName"));
        board.setBoContent(request.getParameter("boContent"));
        board.setBoTime(Date.valueOf((request.getParameter("boTime"))));
        board.setBoUser(request.getParameter("boUser"));
        boardService.saveModifyBoard(board);
        PageHelper.startPage(pageNum,5);
        List<Board> boardList=boardService.viewBoard();
        PageInfo<Board> pageInfo=new PageInfo<>(boardList);
        request.setAttribute("allPage",pageInfo.getPages());
        request.setAttribute("maxPage",pageInfo.getTotal());
        request.setAttribute("boards",boardList);
        return "board/editBoard";
    }

    @GetMapping("seeBoard")
    public String seeBoard(HttpServletRequest request){
        String boId=request.getParameter("boId");
        request.setAttribute("board",boardService.selectBoard(boId));
        return "board/seeBoard";
    }
}
