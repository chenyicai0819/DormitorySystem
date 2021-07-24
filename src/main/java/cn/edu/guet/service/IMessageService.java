package cn.edu.guet.service;

import cn.edu.guet.bean.Message;

import java.util.List;

public interface IMessageService {
    List<Message> getMessage(String receiveId, int curPage, int pageSize);
    List<Message> getSendMessages(String receiveId);
    List<Message> getReceiveMessages(String receiveId);
    void sendMessage(Message message);
    void deleteMessage(String messageId);
    void readMessage(String messageId);
    int getCount(String receiveId);
}
