package cn.edu.guet.service;

import cn.edu.guet.bean.Message;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMessageService {
    PageInfo getSendMessages(String sendId, int pageNum, int pageSize);
    PageInfo getReceiveMessages(String receiveId, int pageNum, int pageSize);
    void sendMessage(Message message);
    void deleteMessage(String messageId);
    void readMessage(int messageId);
}
