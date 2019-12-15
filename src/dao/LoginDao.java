package dao;/**
 * @author yejh
 * @create 2019-09_22 23:02
 */

import org.junit.Test;

import java.sql.*;

/**
 * @description: TODO
 **/
public class LoginDao {
    public static String URL = "jdbc:mysql://localhost:3306/students?serverTimezone=UTC&characterEncoding=utf8";
    public static String USERNAME = "root";
    public static String PWD = "861861";

    /**
    * @Description: 登陆逻辑
    * @Param:  studentUser对象
    * @return:  0表示没有该用户，1表示存在该用户，-1表示查询错误
    * @Author: yejh
    * @Date: 2019/9/22
    */
    public int login(StudentUser studentUser) {
        Connection connection = null;
        try {
            //1、加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2、连接数据库
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            //3、
            String sql = "select count(*) from studentUser where userName = ? and userPassword = ?";
            PreparedStatement stat = connection.prepareStatement(sql);

            stat.setString(1, studentUser.getUserName());
            stat.setString(2, studentUser.getUserPassword());

            ResultSet resultSet = stat.executeQuery();
            int res = -1;
            if(resultSet.next()){
                res = resultSet.getInt(1);
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }

    @Test
    public void test(){
        StudentUser studentUser = new StudentUser("sbchang", "123456");
        int res = login(studentUser);
        System.out.println(res);
    }
}
