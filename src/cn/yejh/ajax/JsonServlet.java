package cn.yejh.ajax;

import cn.yejh.student.entity.Student;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yejh
 * @create 2019-10_05 13:31
 */
@WebServlet(value = "/JsonServlet")
public class JsonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        //测试前端传来的数据
        String name2 = request.getParameter("userName") ;
        String age2 = request.getParameter("age") ;
        System.out.println(name2+"--"+age2);

        Student stu1 = new Student();
        stu1.setSage(23);
        stu1.setSname("zs");

        Student stu2 = new Student();
        stu2.setSage(44);
        stu2.setSname("ls");

        Student stu3 = new Student();
        stu3.setSage(55);
        stu3.setSname("ww");

        JSONObject json = new JSONObject() ;
        json.put("stu1",stu1 ) ;
        json.put("stu2",stu2 ) ;
        json.put("stu3",stu3 ) ;
        json.put("test", "testValue");

        out.print(json);// 返回json对象     {"stu1":stu1, "stu2":stu2,"stu3":stu3 }
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
