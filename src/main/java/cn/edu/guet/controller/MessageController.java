package cn.edu.guet.controller;

import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.bean.Message;
import cn.edu.guet.bean.Water;
import cn.edu.guet.service.IMessageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @PostMapping("getSendMessages")
    @ResponseBody
    public PageInfo getSendMessages(String sendId, int pageNum, int pageSize){
        return messageService.getSendMessages(sendId, pageNum, pageSize);
    }

    @PostMapping("getReceiveMessages")
    @ResponseBody
    public PageInfo getReceiveMessages(String receiveId, int pageNum, int pageSize){
        return messageService.getReceiveMessages(receiveId, pageNum, pageSize);
    }

    @PostMapping("viewMessage")
    public String viewMessage(String messageId, Model model){
      Message message = messageService.getMessage(messageId);
      model.addAttribute("message", message);
      return "thymeleafMessages::viewMessage";
    }

    @PostMapping("sendMessage")
    public void sendMessage(Message message,HttpSession session,HttpServletRequest request){
      message.setMessageId(String.valueOf(System.currentTimeMillis()));
      message.setSendId((String) session.getAttribute("userId"));
      messageService.sendMessage(message);
      request.setAttribute("aunt",messageService.seleAunt());
    }

    @PostMapping("outputMessage")
    public String outputMessage(Message message,HttpSession session,HttpServletRequest request,Model model){
      message.setMessageId(String.valueOf(System.currentTimeMillis()));
      message.setSendId((String) session.getAttribute("userId"));
      messageService.sendMessage(message);
      String receiveId = (String) session.getAttribute("userId");
      PageInfo messages = messageService.getReceiveMessages(receiveId, 1, 5);
      model.addAttribute("messages", messages.getList());
      return "thymeleafMessages";
    }

    @PostMapping("deleteMessage")
    @ResponseBody
    public void deleteMessage(String messageId){
        messageService.deleteMessage(messageId);
    }

    @PostMapping("readMessage")
    @ResponseBody
    public void readMessage(String messageId){
        messageService.readMessage(messageId);
    }


    @GetMapping("viewMessages")
    public String viewMessages(Model model){
        return "viewMessages";
    }

    @GetMapping("Feedback.do")
    public String Feedback(Model model,HttpSession session,HttpServletRequest request){
      request.setAttribute("aunt",messageService.seleAunt());
      return "sendMessage";
    }
  @GetMapping("SeeFeedback.do")
  public String SeeFeedback(Model model,HttpSession session){

    String receiveId = (String) session.getAttribute("userId");
    PageInfo messages = messageService.getReceiveMessages(receiveId, 1, 5);
    model.addAttribute("messages", messages.getList());
    return "thymeleafMessages";
  }

    @PostMapping("getMessageThymeleaf")
    public String getMessageThymeleaf(String receiveId, int pageNum, int pageSize, Model model){
        PageInfo messages = messageService.getReceiveMessages(receiveId, pageNum, pageSize);
        model.addAttribute("messages", messages.getList());
        return "thymeleafMessages::messageinfo";
    }

    @RequestMapping("myMess1")
    public String myMess(HttpSession session,HttpServletRequest request,Model model){
      String id= (String) session.getAttribute("userId");
      request.setAttribute("myMana",messageService.myMess(id));
      return "myMessage";
    }

}
