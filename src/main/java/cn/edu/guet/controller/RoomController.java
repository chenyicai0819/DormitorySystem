package cn.edu.guet.controller;

import cn.edu.guet.bean.Student;
import cn.edu.guet.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @GetMapping("DormitoryMessage.do")
    public String viewRoom(HttpServletRequest request){
        request.setAttribute("builds",roomService.viewBuild());
        return "room/viewRoom";
    }

    @GetMapping("searchRoom")
    public String searchRoom(HttpServletRequest request){
        String buId=request.getParameter("buId");
        String buNo=request.getParameter("buNo");
        request.setAttribute("buId",buId);
        request.setAttribute("buNo",buNo);
        request.setAttribute("title","入住人数");
        request.setAttribute("builds",roomService.viewBuild());
        List<String> rIds=roomService.viewRoom(buId,buNo);
        if (rIds.size()==0){
            request.setAttribute("Map",null);
            return "room/viewRoom";
        }
        request.setAttribute("Map",roomService.viewRooms(rIds));
        return "room/viewRoom";
    }

    @GetMapping("searchEmptyRoom")
    public String searchEmptyRoom(HttpServletRequest request){
        String buId=request.getParameter("buId");
        String buNo=request.getParameter("buNo");
        request.setAttribute("buId",buId);
        request.setAttribute("buNo",buNo);
        request.setAttribute("title","空床数");
        request.setAttribute("builds",roomService.viewBuild());
        List<String> rIds=roomService.viewRoom(buId,buNo);
        if (rIds.size()==0){
            request.setAttribute("Map",null);
            return "room/viewRoom";
        }
        request.setAttribute("Map",roomService.viewEmptyRooms(rIds));
        return "room/viewRoom";
    }
    @GetMapping("editRoom")
    public String editRoom(HttpServletRequest request){
        String rId=request.getParameter("rId");
        request.setAttribute("builds",roomService.viewBuild());
        request.setAttribute("rId",rId);
        request.setAttribute("students",roomService.selectStudent(rId));
        return "room/editRoom";
    }

    @GetMapping("roomAddStudent")
    public String roomAddStudent(HttpServletRequest request){
        String rId=request.getParameter("rId");
        String rBed=request.getParameter("rBed");
        String sId=request.getParameter("sId");
        String buId=request.getParameter("buId");
        Student student=roomService.selectStudentById(sId);
        if(student.getrId()!=""&&student.getrBed()!="") {
            roomService.changeRoomStat_out(student.getrId(), student.getrBed());
        }
        roomService.changeRoom(rId,rBed,sId,buId);
        roomService.changeRoomStat_in(rId,rBed);
        request.setAttribute("builds",roomService.viewBuild());
        request.setAttribute("students",roomService.selectStudent(rId));
        return "room/editRoom";
    }

    @GetMapping("roomChangeStudent")
    public String roomChangeStudent(HttpServletRequest request){
        String oldrId=request.getParameter("oldrId");
        String oldrBed=request.getParameter("oldrBed");
        String rId=request.getParameter("rId");
        String rBed=request.getParameter("rBed");
        String sId=request.getParameter("sId");
        String buId=request.getParameter("buId");
        roomService.changeRoom(rId,rBed,sId,buId);
        roomService.changeRoomStat_out(oldrId,oldrBed);
        roomService.changeRoomStat_in(rId,rBed);
        request.setAttribute("builds",roomService.viewBuild());
        request.setAttribute("students",roomService.selectStudent(rId));
        return "room/editRoom";
    }

}
