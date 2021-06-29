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

			InputStream resourceAsStream = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");

			properties.load(resourceAsStream);

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
				conn.setAutoCommit(false);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return conn;
	}



	public static void commitAndClose(){
		Connection conn = connectionThreadLocal.get();
		if(conn != null){
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(conn);
			}
		}

		connectionThreadLocal.remove();
	}


	public static void rollbackAndClose(){
		Connection conn = connectionThreadLocal.get();
		if(conn != null){
			try {
				conn.rollback();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}finally {
				close(conn);
			}
		}

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
