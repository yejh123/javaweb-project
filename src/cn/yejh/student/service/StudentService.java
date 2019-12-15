package cn.yejh.student.service;/**
 * @author yejh
 * @create 2019-09_26 23:16
 */

import cn.yejh.student.dao.StudentDao;
import cn.yejh.student.entity.Student;

/**
 * @description: TODO
 **/
public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public boolean add(Student student){
        if(!studentDao.isExisted(student.getSno())){
            return studentDao.addStudent(student);
        }
        return false;
    }
}
