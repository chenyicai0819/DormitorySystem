package cn.edu.guet.controller;

import cn.edu.guet.bean.Message;
import cn.edu.guet.bean.Water;
import cn.edu.guet.service.IMessageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("sendMessage")
    public void sendMessage(Message message){
        messageService.sendMessage(message);
    }


    @PostMapping("deleteMessage")
    @ResponseBody
    public void deleteMessage(String messageId){
        messageService.deleteMessage(messageId);
    }

    @PostMapping("readMessage")
    @ResponseBody
    public void readMessage(int messageId){
        messageService.readMessage(messageId);
    }


    @GetMapping("viewMessages")
    public String viewMessages(Model model){
        return "viewMessages";
    }

    @GetMapping("thymeleafMessages")
    public String thymeleafMessages(Model model){
        String receiveId = "10324";
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
}
