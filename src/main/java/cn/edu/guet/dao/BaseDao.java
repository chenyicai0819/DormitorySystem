package cn.edu.guet.dao;

import cn.edu.guet.util.DBConnection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行 insert/update/delete方法
     * @param sql sql语句T
     * @param params 参数
     * @return 返回 -1 代表执行 操作失败，返回其他代表影响的行数
     */
    public int update(String sql,Object... params){
        Connection conn = DBConnection.getConnection();
        try {
            return queryRunner.update(conn, sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
        //执行事务不能使用完某个功能立即关闭conn
        //完全执行完一个事务才关闭conn
    }

    /**
     * 传入JavaBean对象，返回该对象，并且该对象存有数据库对应的数据
     * @param sql sql语句
     * @param type JavaBean类型
     * @param params 参数
     * @param <T> 任何类型
     * @return 返回存好数据库数据的JavaBean类型(如User)
     */
    public <T> T queryForOne(String sql,Class<T> type,Object... params){
        Connection conn = DBConnection.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);

        }
        //执行事务不能使用完某个功能立即关闭conn
        //完全执行完一个事务才关闭conn
    }

    /**
     * 传入JavaBean对象的集合，返回该集合，并且该集合存有数据库对应的JavaBean数据
     * @param sql sql语句
     * @param type JavaBean类型集合
     * @param params 参数
     * @param <T> 任何类型
     * @return 返回集合，存有JavaBean的值
     */

    public <T> List<T> queryForList(String sql, Class<T> type, Object... params){
        Connection conn = DBConnection.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanListHandler<>(type), params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
        //执行事务不能使用完某个功能立即关闭conn
        //完全执行完一个事务才关闭conn
    }

    /**
     * 返回一行一列的值
     * 比如查询数量，返回总数量
     * @param sql sql语句
     * @param params 参数
     * @return 返回一个值
     */
    public Object queryForSingleValue(String sql,Object... params){
        Connection conn = DBConnection.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler<>(),params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
        //执行事务不能使用完某个功能立即关闭conn
        //完全执行完一个事务才关闭conn
    }

}
