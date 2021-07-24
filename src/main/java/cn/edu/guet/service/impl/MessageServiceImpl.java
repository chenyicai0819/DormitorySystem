package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Message;
import cn.edu.guet.mapper.MessageMapper;
import cn.edu.guet.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> getMessage(String receiveId, int curPage, int pageSize) {
        return messageMapper.getMessage(receiveId, curPage, pageSize);
    }

    @Override
    public List<Message> getSendMessages(String receiveId) {
        return messageMapper.getSendMessages(receiveId);
    }

    @Override
    public List<Message> getReceiveMessages(String receiveId) {
        return messageMapper.getReceiveMessages(receiveId);
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
    public int getCount(String receiveId) {
        return messageMapper.getCount(receiveId);
    }
}
