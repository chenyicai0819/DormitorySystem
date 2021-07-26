package cn.edu.guet.controller;

import cn.edu.guet.bean.Message;
import cn.edu.guet.service.IMessageService;
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

    private static int curPage = 1;
    private static int pageSize = 5;
    private static int lastPage = 0;
    private static String receiveId = new String();

    @Autowired
    private IMessageService messageService;

    @GetMapping("getSendMessages")
    @ResponseBody
    public List<Message> getSendMessages(String sendId){
        return messageService.getSendMessages(sendId);
    }

    @GetMapping("getReceiveMessages")
    @ResponseBody
    public List<Message> getReceiveMessages(String receiveId){
        return messageService.getReceiveMessages(receiveId);
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

    @GetMapping("readMessage")
    public void readMessage(String messageId){
        messageService.readMessage(messageId);
    }


    @GetMapping("deleteMessage1")
    public String deleteMessage1(String messageId, String receiveId, Model model, HttpServletRequest request){
        messageService.deleteMessage(messageId);
        model.addAttribute("curPage", curPage);
        model.addAttribute("receiveId", receiveId);
        model.addAttribute("messages", messageService.getMessage(receiveId, (curPage-1) * pageSize, pageSize));
        return "main";
    }

    @GetMapping("viewMessages")
    public String viewMessages(String receiveId, Model model){
        if(receiveId != null){
            this.receiveId = receiveId;
        }
        List<Message> messages= messageService.getMessage(this.receiveId, (curPage-1) * pageSize, pageSize);
        model.addAttribute("curPage", curPage);
        model.addAttribute("receiveId", receiveId);
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping("changePage")
    public String changPage(Model model, HttpServletRequest request){
        int count = messageService.getCount(receiveId);
        System.out.println(count);
        if((count%pageSize) == 0) {
            lastPage = count/pageSize;
        } else {
            lastPage = (count/pageSize) + 1;
        }
        String typeChangePage = request.getParameter("changepage");
        if(typeChangePage.equals("首页")) {
            curPage = 1;
        } else if(typeChangePage.equals("上一页")) {
            if(curPage != 1) {
                curPage--;
            }
        } else if(typeChangePage.equals("下一页")) {
            if(curPage != lastPage) {
                curPage++;
            }
        } else if(typeChangePage.equals("尾页")) {
            curPage = lastPage;
        } else if(typeChangePage.equals("确定")) {
            int page = Integer.parseInt(request.getParameter("page"));
            if(page >= 1 && page <= lastPage) {
                curPage = page;
            }
        }
        return "redirect:viewMessages";
    }

    @GetMapping("test")
    public String test(Model model){
        model.addAttribute("receiveId", "10324");
        model.addAttribute("sendId", "10324");
        return "viewMessages";
    }

    @GetMapping("send")
    public String send(Model model){
        model.addAttribute("curId", "10328");
        return "sendMessage";
    }

    @GetMapping("test1")
    public String test1(Model model){
        return "viewWaterStates";
    }
}
