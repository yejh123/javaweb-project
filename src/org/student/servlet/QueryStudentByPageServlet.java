package org.student.servlet;

import org.student.entity.Page;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class QueryStudentByPageServlet
 */

@WebServlet(value = "/QueryStudentByPageServlet")
public class QueryStudentByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStudentByPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 1、从前台获得当前页、页面大小
	 * 2、调用service层获得总数据量、当前页数据
	 * 3、封装成Page对象，发送到前台
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IStudentService  studentService = new StudentServiceImpl();

		String cPage = request.getParameter("currentPage");
		if(cPage == null){
			cPage = "1";
		}
		long currentPage = Long.parseLong(cPage);

		long pageSize = 3;

		long totalItems = studentService.getTotalCount();
		List<Student> students = studentService.queryStudentsByPage(currentPage, pageSize) ;

		Page p = new Page(currentPage, totalItems, pageSize, students);
		System.out.println(students);

		request.setAttribute("page", p);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
