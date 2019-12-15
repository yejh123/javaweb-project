package cn.yejh.metadata;/**
 * @author yejh
 * @create 2019-10_13 10:04
 */

import org.junit.Test;
import org.student.util.JDBCUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: TODO
 **/
public class DataBaseMetaData {
    @Test
    public void test(){
        Connection connection = null;
        try {
            connection = JDBCUtil.getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
            String dbProductName = metaData.getDatabaseProductName();
            String dbProductVersion = metaData.getDatabaseProductVersion();
            String driverName = metaData.getDriverName();
            String url = metaData.getURL();
            System.out.println(dbProductName + " " + dbProductVersion + " " + driverName + " " + url);
            ResultSet student = metaData.getPrimaryKeys(null, null, "student");
            while (student.next()) {
                for(int i = 1; i <= 6; ++i){
                    Object object = student.getObject(i);
                    System.out.println(object);
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
