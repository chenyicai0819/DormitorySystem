package cn.edu.guet.filter;

import cn.edu.guet.util.SessionFactory;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接直接getConn就可以得到
 */
@WebFilter(filterName = "SqlsessionFilter")
public class SqlsessionFilter implements Filter {
    public static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        SqlSession sqlSession= SessionFactory.getInstance().getSqlSession();
        threadLocal.set(sqlSession);
        chain.doFilter(req,resp);//访问目标资源
        //移除释放空间
        threadLocal.remove();
    }

    public void init(FilterConfig config) throws ServletException {

    }
    public static SqlSession getSqlsession(){
        return threadLocal.get();
    }
    public static void sqlCommit() {
        threadLocal.get().commit();
    }
}
