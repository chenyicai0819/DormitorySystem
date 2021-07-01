package cn.edu.guet.filter;

import javax.servlet.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFilter implements Filter {
    public static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Connection conn=threadLocal.get();
        try {
            String url = "jdbc:mysql://10.34.11.25:3306/dormitory?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(conn==null){
                conn = DriverManager.getConnection(url, "six", "123456");
                threadLocal.set(conn);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        chain.doFilter(req, resp);
        try {
            conn.close();
            threadLocal.remove();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static Connection getConn(){
        return threadLocal.get();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
