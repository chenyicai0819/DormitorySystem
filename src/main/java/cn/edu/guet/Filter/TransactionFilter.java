package cn.edu.guet.Filter;


import cn.edu.guet.util.DBConnection;

import javax.servlet.*;
import java.io.IOException;

/**
 * 拦截每一个请求，集中进行异常处理和数据库事务处理
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            //进入资源
            filterChain.doFilter(servletRequest, servletResponse);
            //后置代码，是从资源 返回给客户端才执行下面代码，说明进程顺利，可以执行数据库操作，而不会出现异常
            DBConnection.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            DBConnection.rollbackAndClose();
            throw new RuntimeException(e);  //把异常抛给Tomcat服务器，让服务器管理友好的提示界面
        }

    }

    @Override
    public void destroy() {

    }
}
