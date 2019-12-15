package org.student.util;/**
 * @author yejh
 * @create 2019-10_11 23:22
 */

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description: 操作数据库工具类，支持事务处理
 **/
public class JDBCUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if(connection == null){
            connection = DataSourceUtil.getDataSourceWithC3P0ByXml().getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }

    public static void beginTransaction() throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
    }

    public static void commitTransaction() throws SQLException {
        Connection connection = getConnection();
        if(connection!=null){
            connection.commit();
        }
    }

    public static void rollbackTransaction() throws SQLException {
        Connection connection = getConnection();
        if(connection!=null){
            connection.rollback();
        }
    }

    public static void close() throws SQLException {
        Connection connection = getConnection();
        if(connection!=null){
            connection.close();
            threadLocal.remove();
            connection = null;
        }
    }
}
