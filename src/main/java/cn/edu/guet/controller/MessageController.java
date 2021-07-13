package cn.edu.guet.controller;

import cn.edu.guet.bean.Message;
import cn.edu.guet.filter.SqlsessionFilter;
import cn.edu.guet.mapper.MessageMapper;
import cn.edu.guet.mvc.annotaion.Controller;
import cn.edu.guet.mvc.annotaion.RequestMapping;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class MessageController {
    private MessageMapper messageMapper;

    @RequestMapping("/getAllMessages.do")
    public List<Message> getAllMessages(String receiveId) {
        messageMapper = SqlsessionFilter.getSqlsession().getMapper(MessageMapper.class);
        List<Message> messageList = messageMapper.getAllMessage(receiveId);
        return messageList;
    }

    @RequestMapping("/deleteMessage.do")
    public void deleteMessage(String messageId) {
        messageMapper = SqlsessionFilter.getSqlsession().getMapper(MessageMapper.class);
        messageMapper.deleteMessage(messageId);
        SqlsessionFilter.getSqlsession().commit();
    }

    @RequestMapping("/sendMessage.do")
    public void sendMessage(Message message) {
        messageMapper = SqlsessionFilter.getSqlsession().getMapper(MessageMapper.class);
        /*Message message = new Message();
        message.setMessageId("3122");
        message.setSendId("10324");
        message.setReceiveId("10328");
        message.setTitle("test");
        message.setContent("testtesttest");
        message.setIsRead("0");
        message.setSendTime(new Timestamp(System.currentTimeMillis()));*/
        message.setSendTime(new Timestamp(System.currentTimeMillis()));
        messageMapper.sendMessage(message);
        SqlsessionFilter.getSqlsession().commit();
    }

    @RequestMapping("/readMessage.do")
    public void readMessage(String messageId) {
        messageMapper = SqlsessionFilter.getSqlsession().getMapper(MessageMapper.class);
        messageMapper.readMessage(messageId);
        SqlsessionFilter.getSqlsession().commit();
    }

    @RequestMapping("/test.do")
    public void test() {
        System.out.println("test");
    }
}
