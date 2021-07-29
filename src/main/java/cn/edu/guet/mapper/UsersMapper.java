package cn.edu.guet.mapper;

import cn.edu.guet.bean.Message;
import cn.edu.guet.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersMapper {
    /*User getMessageByReceiveId(String userId);
    User getMessageBySendId(String userId);*/
}
