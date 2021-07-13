import cn.edu.guet.bean.Message;
import cn.edu.guet.mapper.MessageMapper;
import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

public class MessageTest extends TestCase {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void setUp(){
        // Mybatis 配置文件
        String resource = "mybatis-config.xml";
        // 得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建会话工厂，传入 MyBatis 的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
    }

    @Test
    public void testGetMessage() {
        MessageMapper messageMapper = sqlSession.getMapper(MessageMapper.class);
//        System.out.println(messageMapper.getAllMessage("10328").get(0).getTitle());
        Message message = new Message();
        message.setMessageId("312412");
        message.setSendId("10324");
        message.setReceiveId("10328");
        message.setTitle("test");
        message.setContent("testtesttest");
        message.setIsRead("0");
        message.setSendTime(new Timestamp(System.currentTimeMillis()));
        messageMapper.sendMessage(message);
    }
}
