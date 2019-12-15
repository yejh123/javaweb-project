package org.student.util;

import javax.sql.DataSource;
import java.sql.*;

//通用的数据操作方法
@Deprecated
public class DBUtil {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/students?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "861861";
    public static PreparedStatement pstmt = null;
    public static Connection connection = null;
    public static ResultSet rs = null;

    //通用的：查询总数
    public static int getTotalCount(String sql) {//select count(*) from xx ;
        int count = -1;
        try {
            pstmt = createPreParedStatement(sql, null);
            rs = pstmt.executeQuery();//88
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, pstmt, connection);
        }
        return count;
    }


    //通用的：当前页的数据集合 ,因此当前的数据 是强烈依赖于实体类，例如 显示当前页的学生， List<Student>
    //因此需要将此方法 写入到dao层

//	public static List<Student> 


    //通用的增删改
    public static boolean executeUpdate(String sql, Object[] params) {//{"zs",1}
        try {
            pstmt = createPreParedStatement(sql, params);
            int count = pstmt.executeUpdate();
            if (count > 0)
                return true;
            else
                return false;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll(null, pstmt, connection);
        }
    }

    //Statement
    public static void closeAll(ResultSet rs, Statement stmt, Connection connection) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        /*Class.forName(DRIVER);
        DataSource ds = null;
        try {
            Context ctx = new InitialContext() ;    //context.xml
            ds = (DataSource)ctx.lookup("java:comp/env/student");
            connection = ds.getConnection();
            System.out.println("成功连接数据源");
        } catch (NamingException e) {
            e.printStackTrace();
        }*/

        DataSource dataSource = DataSourceUtil.getDataSourceWithC3P0ByXml();

        //只需要记住以下一句
        return dataSource.getConnection();
    }

    private static PreparedStatement createPreParedStatement(String sql, Object[] params) throws ClassNotFoundException, SQLException {
        pstmt = getConnection().prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
        return pstmt;
    }

    //通用的查  :通用 表示  适合与 任何查询
    public static ResultSet executeQuery(String sql, Object[] params) {//select xxx from xx where name=? or id=?

        try {
            pstmt = createPreParedStatement(sql, params);
            rs = pstmt.executeQuery();
            return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
