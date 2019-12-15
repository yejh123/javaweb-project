package cn.yejh.rootpath;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yejh
 * @create 2019-10_18 9:06
 * 一、jsp页面中的跳转
 *  1.相对路径：
 *  2.绝对路径：以/开头，根路径是服务器的根目录，http://localhost:8888/
 *
 * 二、servlet中的跳转
 *  1.请求转发，用绝对路径表示要跳转到的页面，以/开头，根路径是项目的根路径，http://localhost:8888/JspProj/
 *  2.重定向，也要用绝对路径表示要跳转到的页面，以/开头，根路径是服务器的根路径，http://localhost:8888/
 */
@WebServlet(value = "/RootPathServlet")
public class RootPathServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/rootpath/a.jsp").forward(request,response);

        //获取当前项目名
        ServletContext servletContext = getServletContext();
        String contextPath = servletContext.getContextPath();       //   /JspProj

        //第二种方式获取当前项目名
        String contextPath1 = request.getContextPath();
        System.out.println(contextPath+ " " + contextPath1);
        response.sendRedirect( contextPath + "/rootpath/b.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
