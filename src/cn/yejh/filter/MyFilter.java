package cn.yejh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yejh
 * @create 2019-10_04 11:51
 * 过滤器：https://blog.csdn.net/mytt_10566/article/details/70214640
 */

@WebFilter(filterName = "loginFilter",
        urlPatterns = "/*",
        dispatcherTypes = {DispatcherType.REQUEST},
        initParams = {
                @WebInitParam(name = "login", value = "/session/session_login.jsp"),
                @WebInitParam(name = "check", value = "/LoginServlet"),
                @WebInitParam(name = "checkUserName", value = "/UserNameServlet"),
                @WebInitParam(name = "encoding", value = "utf-8")})
public class MyFilter implements Filter {
    private FilterConfig config;
    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        // 获取配置参数
        String login = config.getInitParameter("login");
        String encoding = config.getInitParameter("encoding");
        String check = config.getInitParameter("check");
        String checkUserName = config.getInitParameter("checkUserName");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // 设置请求的字符集（post请求方式有效）
        request.setCharacterEncoding(encoding);

        // 不带http://域名:端口的地址
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains(login) || uri.contains(check) || uri.contains("jquery") || uri.contains(checkUserName)) {
            // 请求的登录，放行
            chain.doFilter(request, response);
        } else {
            if (request.getSession().getAttribute("userName") == null) {
                // 重定向到登录页面
                // request.getContextPath()返回项目根路径：http://localhost:8888/JspProj
                System.out.println("当前用户未登录，自动跳转到登陆界面...");
                response.sendRedirect(request.getContextPath() + login);
            } else {
                // 已经登录，放行
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        System.out.println("过滤器初始化");
    }

}
