<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/9/8
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String userName = request.getParameter("userName");
    String password = request.getParameter("userPassword");
%>
<h1>登录成功，用户信息如下</h1>
<p>用户名：<%=userName%>
</p>
<p>密码:<%=password%>
</p>
</body>
</html>
