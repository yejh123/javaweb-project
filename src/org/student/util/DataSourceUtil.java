package org.student.util;

import cn.yejh.dbcp.DBCPDemo;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.Properties;

public class DataSourceUtil {


    //获取dbcp方式的ds对象
    public static DataSource getDataSourceWIthDBCP() {
        BasicDataSource dbcp = new BasicDataSource();
        dbcp.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dbcp.setUrl("jdbc:mysql://localhost:3306/students?serverTimezone=UTC");
        dbcp.setUsername("root");
        dbcp.setPassword("861861");
        dbcp.setInitialSize(20);
        dbcp.setMaxActive(10);
        return dbcp;
    }


    public static DataSource getDataSourceWIthDBCPByProperties() throws Exception {
        DataSource dbcp = null;
        Properties props = new Properties();
        InputStream input = new DBCPDemo().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
        props.load(input);

        //只需要记住以下一句
        dbcp = BasicDataSourceFactory.createDataSource(props);
        return dbcp;
    }

    public static DataSource getDataSourceWithC3P0(){
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        try {
            c3p0.setDriverClass("com.mysql.cj.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        c3p0.setJdbcUrl("jdbc:mysql://localhost:3306/students?serverTimezone=UTC");
        c3p0.setUser("root");
        c3p0.setPassword("861861");

        return c3p0 ;
    }

    public static DataSource getDataSourceWithC3P0ByXml(){
        ComboPooledDataSource c3p0 = new ComboPooledDataSource("yanqun");
        return c3p0 ;
    }

}
