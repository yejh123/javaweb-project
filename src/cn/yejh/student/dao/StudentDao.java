package cn.yejh.student.dao; /**
 * @author yejh
 * @create 2019-09_26 22:54
 */

import cn.yejh.student.entity.Student;
import org.junit.Test;

import java.sql.*;

/**
 * @description: TODO
 **/
public class StudentDao {
    public final static String URL = "jdbc:mysql://localhost:3306/students?serverTimezone=UTC";
    public final static String USERNAME = "root";
    public final static String PWD = "861861";

    public boolean addStudent(Student student) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            String sql = "insert into student(sno, sname, sage, saddress) values(?,?,?,?)";
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setInt(1, student.getSno());
            stat.setString(2, student.getSname());
            stat.setInt(3, student.getSage());
            stat.setString(4, student.getSaddress());
            int res = stat.executeUpdate();

            return res == 1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    public boolean isExisted(int sno) {
        return queryStudent(sno) != null;
    }

    public Student queryStudent(int sno) {
        Connection connection = null;
        Student student = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            String sql = "select sname, sage, saddress from student where sno=?";
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setInt(1, sno);

            ResultSet resultSet = stat.executeQuery();

            if (resultSet.next()) {
                String sname = resultSet.getString(1);
                int sage = resultSet.getInt(2);
                String saddress = resultSet.getString(3);
                student = new Student(sno, sname, sage, saddress);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return student;
    }

    @Test
    public void test(){
        Student res = queryStudent(1);
        System.out.println(res);
    }
}
