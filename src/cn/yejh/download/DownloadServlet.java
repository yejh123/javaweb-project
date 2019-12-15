package cn.yejh.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * @author yejh
 * @create 2019-09_29 20:08
 */
@WebServlet(value = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        //获取需要下载的文件名
        String fileName = request.getParameter("filename");//form  、a  href、 ...Server?a=b
        System.out.println("filename: " + fileName);
        //下载文件：需要设置 消息头
        response.addHeader("content-Type", "application/octet-stream");//MIME类型:二进制文件（任意文件）
        response.addHeader("content-Disposition", "attachment;filename=" + fileName);//fileName包含了文件后缀：abc.txt


        //Servlet通过文件的地址  将文件转为输入流 读到Servlet中
        InputStream in = getServletContext().getResourceAsStream("/res/MIME.png");

        //通过输出流 将 刚才已经转为输入流的文件  输出给用户
        ServletOutputStream out = response.getOutputStream();
        byte[] bs = new byte[10];
        int len = -1;
        while ((len = in.read(bs)) != -1) {
            out.write(bs, 0, len);
        }

        out.close();
        in.close();
        PrintWriter printWriter = response.getWriter();
        printWriter.print("filename: " + fileName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
        request.getSession();
        //获取application对象
        ServletContext servletContext = getServletConfig().getServletContext();

    }
}
