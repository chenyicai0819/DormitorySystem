package cn.edu.guet.service;

import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.bean.Message;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMessageService {
    Message getMessage(String messageId);
    PageInfo getSendMessages(String sendId, int pageNum, int pageSize);
    PageInfo getReceiveMessages(String receiveId, int pageNum, int pageSize);
    void sendMessage(Message message);
    void deleteMessage(String messageId);
    void readMessage(String messageId);
    List<Dormitory> seleAunt();
    List<Message> myMess(String id);
    List<Message> myMessIn(String id);
}
