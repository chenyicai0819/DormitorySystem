package cn.edu.guet.controller;

import cn.edu.guet.bean.Room;
import cn.edu.guet.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomController {
    @Autowired
    private IRoomService iRoomService;
    @RequestMapping("BuildManage.do")
    public String getRoom(Model model,Integer currentPage){
        if(currentPage==null){
            currentPage=1;
        }
    int allPage=iRoomService.getRoomPage();
    System.out.println("总数目"+allPage);
    model.addAttribute("maxPage",allPage);
    if(allPage%4==0){
        allPage=allPage/4;
    }else{
        allPage=allPage/4+1;
    }
        System.out.println("总页数"+currentPage);
        model.addAttribute("rooms",iRoomService.getRoom(currentPage,4));
        model.addAttribute("allPage",allPage);
        return "room";
    }
//    @GetMapping("getRoom")
//    public String getRoom(Model model,Room room){
////        List<Room> roomList=new ArrayList<>();
////        roomList=iRoomService.getrId(rId);
////        System.out.println(roomList.get(0).getrId());
////        Room room=new Room();
////        room.setrId(roomList.get(0).getrId());
////        room.setrBed(roomList.get(0).getrBed());
////        room.setBuid(roomList.get(0).getBuid());
//
//        model.addAttribute("room",iRoomService.getrId(room));
//        return "updateRoom";
//    }
    @PostMapping("addRoom")
    public String addRoom(Model model, Room room){
        iRoomService.addRoom(room);
        model.addAttribute("rooms",iRoomService.getRoom(0,0));

        return "room";
    }
    @RequestMapping("deleteRoom")
    public String deleteRoom(Model model, Room room,Integer currentPage){
        iRoomService.deleteRoom(room);
        if(currentPage==null){
            currentPage=1;
        }
        int allPage=iRoomService.getRoomPage();
        System.out.println("总数目"+allPage);
        model.addAttribute("maxPage",allPage);
        if(allPage%4==0){
            allPage=allPage/4;
        }else{
            allPage=allPage/4+1;
        }
        System.out.println("总页数"+currentPage);
        model.addAttribute("rooms",iRoomService.getRoom(currentPage,4));
        model.addAttribute("allPage",allPage);
        return "room";
    }
//    @ResponseBody
//    @RequestMapping("updateRoom")
//    public String updateRoom(Model model, Room room,int currentPage){
//        iRoomService.updateRoom(room);
//        model.addAttribute("room",iRoomService.getRoom(currentPage));
//        return "Room";
//    }
@RequestMapping("pagination") //分页
public String pagination(Model model,Integer currentPage){
    int allPage=iRoomService.getRoomPage();
    System.out.println("总数目"+allPage);
    model.addAttribute("maxPage",allPage);//传总数目
    if(allPage%4==0){
        allPage=allPage/4;
    }else{
        allPage=allPage/4+1;
    }
    System.out.println("总页数"+currentPage);
    model.addAttribute("rooms",iRoomService.getRoom(currentPage,4));
    model.addAttribute("allPage",allPage);//传总页数
    return "room::table1";
}
}
