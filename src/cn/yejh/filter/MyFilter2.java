package cn.yejh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author yejh
 * @create 2019-10_04 13:32
 */
/*
@WebFilter(filterName = "MyFilter2", urlPatterns = "/*")
public class MyFilter2 implements Filter {
    @Override
    public void destroy() {
        System.out.println("过滤器销毁2");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("执行过滤操作2");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化2");
    }

}
*/
