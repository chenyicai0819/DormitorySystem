package cn.edu.guet.controller;

import cn.edu.guet.bean.Room;
import cn.edu.guet.bean.Water;
import cn.edu.guet.service.impl.WaterBuyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TimeZone;

@Controller
public class WaterBuyController {
  final TimeZone timeZone = TimeZone.getTimeZone("GTM+8");
    @Autowired
    private WaterBuyService waterService;
    @GetMapping("WaterOnline.do")
    public String getWater(Model model, @RequestParam(defaultValue = "0", value = "pageNum") Integer pageNum, HttpSession session) {
        model.addAttribute("stud",waterService.getStudent());
        String returnValue;
        if(pageNum == 0){
            returnValue = "Water";
            pageNum = 1;
            PageHelper.startPage(pageNum,5);
        }else{
            returnValue = "Water::table1";
            PageHelper.startPage(pageNum,5);
        }
        List<Water> waterList = waterService.getWater();
        PageInfo<Water> pageInfo = new PageInfo<>(waterList);
        model.addAttribute("pageInfo", pageInfo);
        session.setAttribute("wprice",waterList.get(0).getWprice());
        System.out.println(returnValue);
        return returnValue;
    }

    @GetMapping("getAllRoom.do")
    @ResponseBody
    public List<Room> getAllRoom(String buid){
        List<Room> list = waterService.getAllRoom(buid);
        return list;
    }
    @GetMapping("AddOrder.do")
    @ResponseBody
    public int AddOrder(String woId, String buid, int woNum, String woRoom, double woMoney, String woUser){
        waterService.insertOrder(woId,buid,woNum,woRoom,woMoney,woUser);
        return 1;
    }
    @GetMapping("ShowOrder.do")
    public String ShowOrder(Model model,String woUser){
        model.addAttribute("order",waterService.getAllOrder(woUser));
      System.out.println(model.getAttribute("order"));
      return "Water::table4";
    }
}
