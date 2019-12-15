package org.student.dao.impl;

import org.student.dao.BaseDao;
import org.student.dao.IStudentDao;
import org.student.entity.Student;

import java.util.ArrayList;
import java.util.List;

//数据访问层：原子性 的增删改查
public class StudentDaoImpl extends BaseDao<Student> implements IStudentDao {

    //存在大量冗余（重复）
    public boolean addStudent(Student student) {
        String sql = "insert into student(sno,sname,sage,saddress) values(?,?,?,?) ";
        Object[] params = {student.getSno(), student.getSname(), student.getSage(), student.getSaddress()};
        return update(sql, params) == 1;
    }

    //根据学号修改学生： 根据sno知道待修改的人 ，把这个人 修改成student
    public boolean updateStudentBySno(int sno, Student student) {//3 -> zs,23,bj
        String sql = "update student set sname =?,sage=?,saddress=? where sno=?";
        Object[] params = {student.getSname(), student.getSage(), student.getSaddress(), sno};
        return update(sql, params) == 1;
    }

    //根据学号删除学生
    public boolean deleteStudentBySno(int sno) {
        String sql = "delete from student where sno = ?";
        Object[] params = {sno};
        return update(sql, params) == 1;
    }

    //查询全部学生(很多学生)
    public List<Student> queryAllStudents() {
//        Student student = null;
//        List<Student> students = new ArrayList<>();
//        ResultSet rs = null;
//        try {
//            String sql = "select * from student";
//            rs = DBUtil.executeQuery(sql, null);
//            while (rs.next()) {
//                int no = rs.getInt("sno");
//                String name = rs.getString("sname");
//                int age = rs.getInt("sage");
//                String address = rs.getString("saddress");
//                student = new Student(no, name, age, address);
//                students.add(student);
//            }
//            System.out.println(students);
//            return students;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
//        }

        String sql = "select * from student";
        return queryList(sql, (Object[]) null);

    }

    //根据姓名查询
    //根据年龄查询
    //查询此人是否存在
    public boolean isExist(int sno) {//true:此人存在  false:不存在
        return queryStudentBySno(sno) == null ? false : true;
    }

    //根据学号 查询学生
    public Student queryStudentBySno(int sno) {
        String sql = "select * from student where sno =? ";
        return queryOne(sql, sno);
    }


    //查询当前页（特定页）的学生集合
    //currentPage:页数、当前页的页码
    //pageSize：页面大小
    @Override
    public List<Student> queryStudentsByPage(long currentPage, long pageSize) {
        List<Student> students = new ArrayList<>();
        Student student = null;
        String sql = "select sno, sname, sage, saddress from student \n" +
                "order by sno\n" +
                "limit ?, ?";

        return queryList(sql, (currentPage - 1) * pageSize, pageSize);
    }

    @Override
    public long getTotalCount() {
        String sql = "select count(*) from student";
        Object res = querySingleValue(sql, (Object[]) null);       //res类型就是Long类型
        System.out.println(res);
        if(res != null){
            return Long.parseLong(res.toString());
        }else{
            throw new RuntimeException("getTotalCount错误");
        }
    }

}
