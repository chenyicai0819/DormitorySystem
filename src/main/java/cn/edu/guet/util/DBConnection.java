package cn.edu.guet.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnection {

	private static DruidDataSource druidDataSource;
	private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

	static{
		try {
			Properties properties = new Properties();
			// 读取 jdbc.properties属性配置文件
			InputStream resourceAsStream = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
			// 从流中加载数据
			properties.load(resourceAsStream);
			// 创建数据库连接池
			druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection(){
		Connection conn = connectionThreadLocal.get();
		try {
			if(null == conn){
				conn = druidDataSource.getConnection();
				connectionThreadLocal.set(conn);
				conn.setAutoCommit(false);//设置为手动提交
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return conn;
	}


	/**
	 * 手动提交事务
	 */
	public static void commitAndClose(){
		Connection conn = connectionThreadLocal.get();
		if(conn != null){  //说明之前连接过数据库
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(conn);
			}
		}
		// 一定要执行 remove 操作，防止内存泄漏，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
		connectionThreadLocal.remove();
	}

	/**
	 * 回滚
	 */
	public static void rollbackAndClose(){
		Connection conn = connectionThreadLocal.get();
		if(conn != null){
			try {
				conn.rollback(); //回滚事务
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}finally {
				close(conn);
			}
		}
		// 一定要执行 remove 操作，防止内存泄漏，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
		connectionThreadLocal.remove();
	}

	public static void close(Connection conn){
		try {
			if(null != conn){
				conn.close();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstt,Connection conn){
		try {
			if(null != pstt){
				pstt.close();
			}
			if(null != conn){
				conn.close();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	public static void close(ResultSet rs,PreparedStatement pstt,Connection conn){
		try {
			if(null != rs){
				rs.close();
			}
			if(null != pstt){
				pstt.close();
			}
			if(null != conn){
				conn.close();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
