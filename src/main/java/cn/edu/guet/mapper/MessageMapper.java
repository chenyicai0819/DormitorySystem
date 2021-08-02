package cn.edu.guet.mapper;

import cn.edu.guet.bean.Dormitory;
import cn.edu.guet.bean.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MessageMapper {
  Message getMessage(String messageId);
    List<Message> getSendMessages(String sendId);
    List<Message> getReceiveMessages(String receiveId);
    void sendMessage(Message message);
    void deleteMessage(String messageId);
    void readMessage(String messageId);
    List<Dormitory> seleAunt();
    List<Message> myMess(String id);
    List<Message> myMessIn(String id);
}
