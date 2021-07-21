package cn.edu.guet.controller;

import cn.edu.guet.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author lihehuang
 * @Project DormitorySystem
 * @Package cn.edu.guet.controller
 * @Date 2021/7/20 15:10
 */
@Controller
public class RoomController {
    @Autowired
    private IRoomService roomService;

    @GetMapping("viewRoom")
    public String viewRoom(HttpServletRequest request){
        request.setAttribute("builds",roomService.viewBuild());
        return "room/viewRoom";
    }

    @GetMapping("searchRoom")
    public String searchRoom(HttpServletRequest request){
        String buId=request.getParameter("buId");
        String buNo=request.getParameter("buNo")+"%";
        request.setAttribute("builds",roomService.viewBuild());
        request.setAttribute("rooms",roomService.viewRoom(buId,buNo));
        return "room/viewRoom";
    }

    @GetMapping("editRoom")
    public String editRoom(HttpServletRequest request){
        String buId=request.getParameter("buId");
        String rId=request.getParameter("rId");
        request.setAttribute("room",roomService.selectRoom(buId,rId));
        return "room/editRoom";
    }
}
