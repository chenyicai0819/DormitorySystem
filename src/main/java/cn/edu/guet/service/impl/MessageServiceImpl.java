package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.bean.Message;
import cn.edu.guet.mapper.MessageMapper;
import cn.edu.guet.service.IMessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;


    @Override
    public Message getMessage(String messageId) {
    return messageMapper.getMessage(messageId);
  }
    @Override
    public PageInfo getSendMessages(String sendId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Message> messages = messageMapper.getSendMessages(sendId);
        return new PageInfo(messages);
    }

    @Override
    public PageInfo getReceiveMessages(String receiveId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Message> messages = messageMapper.getReceiveMessages(receiveId);
      return new PageInfo(messages);
    }


    @Override
    public void sendMessage(Message message) {
        message.setSendTime(new Timestamp(System.currentTimeMillis()));
        messageMapper.sendMessage(message);
    }

    @Override
    public void deleteMessage(String messageId) {
        messageMapper.deleteMessage(messageId);
    }

    @Override
    public void readMessage(String messageId) {
        messageMapper.readMessage(messageId);
    }

  @Override
  public List<Dormitory> seleAunt() {
    return messageMapper.seleAunt();
  }

  @Override
  public List<Message> myMess(String id) {
    return messageMapper.myMess(id);
  }

  @Override
  public List<Message> myMessIn(String id) {
    return messageMapper.myMessIn(id);
  }

}
