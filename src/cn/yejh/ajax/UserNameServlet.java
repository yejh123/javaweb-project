package cn.yejh.ajax;

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
 * @create 2019-10_05 10:33
 */
@WebServlet(value = "/UserNameServlet" , name ="UserNameServlet")
public class UserNameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //默认请求编码就是utf-8
        //request.setCharacterEncoding("iso-8859-1");

        //设置编码的第一种方式
        //response.addHeader("Content-type", "text/html; charset=utf-8");

        //设置编码的第二种方式
        //告诉浏览器编码类型
        //response.setCharacterEncoding("utf-8");
        //告诉浏览器我传输的数据内容类型
        //response.setContentType("text/html");

        //设置编码的第三种方式
        response.setContentType("text/html;charset=utf-8");

        String userName = request.getParameter("userName");
        System.out.println(userName);
        PrintWriter out = response.getWriter();
        //模拟三层
        JSONObject jsonObject = new JSONObject();
        if("sbchang".equals(userName)){
            //out.print("true");
            //out.print("{\"msg\":\"true\"}");
            jsonObject.put("msg", true);
        }else{
            //out.print("{\"msg\":\"false\"}");
            jsonObject.put("msg", false);
        }
        jsonObject.put("test", "testValue");
        out.print(jsonObject);      // 返回json对象 {"msg":"true}
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UserNameServlet----post请求");
        doGet(request,response);
    }
}
