package cn.yejh.dbcp;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class C3P0Demo {
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

    public static void main(String[] args)throws Exception {
        System.out.println(getDataSourceWithC3P0().getConnection());
        System.out.println(getDataSourceWithC3P0ByXml().getConnection());
    }
}
