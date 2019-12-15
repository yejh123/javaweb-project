package cn.yejh.dbcp;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.student.util.DataSourceUtil;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DBCPDemo {

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


    public static void main(String[] args) throws Exception {
        System.out.println(DataSourceUtil.getDataSourceWithC3P0());
        //System.out.println(getDataSourceWIthDBCP().getConnection());
        //System.out.println(getDataSourceWIthDBCPByProperties().getConnection());
    }
}
