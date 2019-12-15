<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/10/21
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope.jsp</title>
</head>
<body>
<%
    /*可以通过pageContext获得其他八个内置对象
    1.输入输出对象：out对象、response对象、request对象
    2.通信控制对象：pageContext对象、session对象、application对象
    3.Servlet对象:page对象、config对象
    4.错误处理对象：exception对象
    https://www.cnblogs.com/xrong/p/3168616.html
     */
    HttpSession session1 = pageContext.getSession();
    ServletConfig servletConfig = pageContext.getServletConfig();
    ServletContext servletContext = pageContext.getServletContext();
    JspWriter out1 = pageContext.getOut();
    Exception exception = pageContext.getException();
    Object page1 = pageContext.getPage();
    ServletRequest request1 = pageContext.getRequest();
    ServletResponse response1 = pageContext.getResponse();
    out.print("getSession(): " + session1 + " " + (session1 == session) + "<br/>");
    out.print("getServletConfig(): " + servletConfig + " " + (servletConfig == config) + "<br/>");
    out.print("getServletContext(): " + servletContext + " " + (servletContext == config.getServletContext()) +
            " " + (servletContext == application) + "<br/>");
    out.print("getOut(): " + out1 + " " + (out1 == out) + "<br/>");
    out.print("getException(): " + exception + "<br/>");
    out.print("getPage(): " + page1 + " " + (page1 == page) + "<br/>");
    out.print("getRequest(): " + request1 + " " + (request1 == request) + "<br/>");
    out.print("getResponse(): " + response1 + " " + (response1 == response) + "<br/>");

%>
</body>
</html>
