package cn.yejh.student.servlet;/**
 * @author yejh
 * @create 2019-09_26 23:18
 */


import cn.yejh.student.entity.Student;
import cn.yejh.student.service.StudentService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description: TODO
 **/

@WebServlet(value="/AddStudentsServlet2")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("sno"));
        String name = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("sage"));
        String address = request.getParameter("saddress");
        Student student = new Student(no, name, age, address);

        StudentService studentService = new StudentService();
        boolean res = studentService.add(student);

        //设置响应编码
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf8");

        PrintWriter out = response.getWriter();
        if(res) {
            //out.println("增加成功！");
            response.sendRedirect("QueryAllStudentsServlet");
        }else {
            //out.println("增加失败！");
            response.sendRedirect("QueryAllStudentsServlet");
        }

    }


}
