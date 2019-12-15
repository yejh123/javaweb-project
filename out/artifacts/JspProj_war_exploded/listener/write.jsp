<%@ page import="cn.yejh.listener.BeanActivationListener" %><%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/10/5
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>write.jsp</title>
</head>
<body>
等待五秒进行钝化
<%
    BeanActivationListener beanActivationListener = new BeanActivationListener((String) session.getAttribute("userName"));

    session.setAttribute("Bean", beanActivationListener);
%>
</body>
</html>
