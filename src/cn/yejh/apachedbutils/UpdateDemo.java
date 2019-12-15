package cn.yejh.apachedbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.student.util.DataSourceUtil;

import java.sql.SQLException;

public class UpdateDemo {

    public static void add() throws SQLException {
        QueryRunner runner =  new QueryRunner(DataSourceUtil.getDataSourceWithC3P0()) ;
        int count = runner.update( "insert into student(sno, sname) values(?,?)",new Object[]{18,"zl"} ) ;
        System.out.println(count);

    }
    public static void delete() throws SQLException {
        QueryRunner runner =  new QueryRunner(DataSourceUtil.getDataSourceWithC3P0()) ;
        int count = runner.update( "delete from student where sno = ?",18 ) ;
        System.out.println(count);

    }

    public static void update() throws SQLException {
        QueryRunner runner =  new QueryRunner(DataSourceUtil.getDataSourceWithC3P0()) ;
        int count = runner.update( "update student set sname = ? where sno = ?",new Object[]{"xx",18} ) ;
        System.out.println(count);

    }

    public static void main(String[] args) throws SQLException {
        //add();
        //delete();
        update();
    }

}
