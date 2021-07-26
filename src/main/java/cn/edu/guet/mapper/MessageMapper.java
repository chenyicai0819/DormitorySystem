package cn.edu.guet.mapper;

import cn.edu.guet.bean.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MessageMapper {
    List<Message> getSendMessages(String sendId);
    List<Message> getReceiveMessages(String receiveId);
    void sendMessage(Message message);
    void deleteMessage(String messageId);
    void readMessage(int messageId);
}
