package cn.edu.guet.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 单例模式：饿汉模式，懒汉模式
 *
 * @Author liwei
 * @Date 2021-07-04 17:36
 * @Version 1.0
 */
public class SessionFactory {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    private static SessionFactory instance = new SessionFactory();//静态的代码，在程序运行期间执行，且仅执行1次

    private SessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static SessionFactory getInstance() {
        return instance;
    }
}