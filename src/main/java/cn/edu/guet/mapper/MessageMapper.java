package cn.edu.guet.mapper;

import cn.edu.guet.bean.Message;

import java.util.List;

public interface MessageMapper {
    List<Message> getAllMessage(String receiveId);
    void sendMessage(Message message);
    void deleteMessage(String messageId);
    void readMessage(String messageId);
}
