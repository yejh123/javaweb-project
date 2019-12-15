package cn.yejh.apachedbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.student.entity.Student;
import org.student.util.DataSourceUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class QueryRunnerTest {

    //select *from student ;  -> List<Student>
    //查询单行数据
    @org.junit.Test
    public void testArrayHandler() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());//自动提交事务
        Object[] student = runner.query("select * from student where sno > ? ", new ArrayHandler(), 1);
        System.out.println(student[0] + "," + student[1]);
    }

    //查询多行数据
    @org.junit.Test
    public void testArrayListHandler() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());//自动提交事务
        List<Object[]> students = runner.query("select * from student where sno > ? ", new ArrayListHandler(), 1);
        for (Object[] student : students) {
            System.out.println(student[0] + "," + student[1]);
        }

    }

    //查询单行数据(放入對象中)
    @org.junit.Test
    public void testBeanHandler() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());//自动提交事务
        Student student = runner.query("select * from student where sno > ? ", new BeanHandler<Student>(Student.class), 1);
        System.out.println(student.getSno() + "," + student.getSname());
    }

    //查询多行数据(放入對象中)
    @org.junit.Test
    public void testBeanListHandler() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());//自动提交事务
        List<Student> students = runner.query("select * from student where sno > ? ", new BeanListHandler<Student>(Student.class), 1);
        for (Student student : students) {
            System.out.println(student.getSno() + "," + student.getSname());
        }
    }

    //查询多行数据(放入map中)
    @org.junit.Test
    public void testBeanMapHandler() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());//自动提交事务     --   java中对应oracle默認的數值類型  BigDecimal
        Map<String, Student> students = runner.query("select * from student where sno > ? ",
                new BeanMapHandler<String, Student>(Student.class, "sno"), 1);
        //students 是Map<Integer, Student>类型（访问mysql数据库时）
        // 2: ls,  3:ww
        Student stu = students.get(2);      //只能传入Integer对象
        System.out.println(students);
        System.out.println(stu.getSno() + "," + stu.getSname());

    }


    //查询單行数据 map
    @org.junit.Test
    public void testMapHandler() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());//自动提交事务
        Map<String, Object> student = runner.query("select * from student where sno > ? ", new MapHandler(), 1);
        System.out.println(student);
    }

    //查询單值数据
    @org.junit.Test
    public void testScalarHandler() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());//自动提交事务
//        BigDecimal result = runner.query("select name from student where id = ? " ,new ScalarHandler<BigDecimal>(),2) ;
        String result = runner.query("select sname from student where sno = ? ", new ScalarHandler<String>(), 2);
        System.out.println(result);
    }

    //查询多行数据 map
    @org.junit.Test
    public void testMapListHandler() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());//自动提交事务
        List<Map<String, Object>> students = runner.query("select * from student where sno > ? ", new MapListHandler(), 1);
        System.out.println(students);
    }

    //查询多行数据 keyed
    @org.junit.Test
    public void testKeyedHandler() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());//自动提交事务
        Map<String, Map<String, Object>> students = runner.query("select * from student where sno > ? ", new KeyedHandler<String>("sname"), 1);
        System.out.println(students);
    }

    //查询多行数据中的某一列
    @org.junit.Test
    public void testColumnListHandler() throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSourceWithC3P0ByXml());//自动提交事务
        List<String> names = runner.query("select * from student where sno > ? ", new ColumnListHandler<String>("sname"), 1);
        System.out.println(names);
    }

}
