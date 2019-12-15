package org.student.service;

import org.student.entity.Student;

import java.util.List;

public interface IStudentService {
	public Student queryStudentBySno(int sno);
	//查询全部学生
	public List<Student> queryAllStudents();
	//查询当前页的学生
	public List<Student> queryStudentsByPage(long currentPage,long pageSize);
	
	//查询总数
	public long getTotalCount();
	
	public boolean updateStudentBySno(int sno, Student student) ;
	
	public boolean deleteStudentBySno(int sno) ;
	
	public boolean addStudent(Student student) ;
	
	
}
