<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/9/8
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response_cookie</title>
</head>
<body>
    <%
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        //添加缓存
        Cookie cookie1 = new Cookie("userName", userName);
        Cookie cookie2 = new Cookie("userPassword", userPassword);
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        //页面跳转（请求转发或者重定向）
        request.getRequestDispatcher("cookie_home.jsp").forward(request,response);


    %>
</body>
</html>
