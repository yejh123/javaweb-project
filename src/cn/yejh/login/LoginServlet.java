package cn.yejh.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author yejh
 * @create 2019-10_18 11:44
 */
@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器的token
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");

        //request发送给服务器的token
        String pageToken = request.getParameter("token");
        System.out.println("服务器的token：" + token);
        System.out.println("请求发送的token：" + pageToken);

        if(pageToken.equals(token)){
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("userPassword");

            //模拟访问数据库
            if("sbchang".equals(userName) && "123".equals(passWord)){
                session.setAttribute("userName", userName);
                request.getRequestDispatcher("/session/session_welcome.jsp").forward(request,response);
            }else{
                response.sendRedirect(getServletContext().getContextPath() + "/session/session_login.jsp");
            }
        }else {
            request.getRequestDispatcher("/session/session_warning.jsp").forward(request,response);
        }
        session.removeAttribute("token");
    }
}
