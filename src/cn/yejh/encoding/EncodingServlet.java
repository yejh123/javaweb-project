package cn.yejh.encoding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yejh
 * @create 2019-10_17 23:33
 */
@WebServlet(value = "/EncodingServlet")
public class EncodingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //浏览器发送数据到服务器，当时服务器并不知道编码规则
        request.setCharacterEncoding("utf-8");
        System.out.println(request.getParameter("test"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("test"));

    }
}
