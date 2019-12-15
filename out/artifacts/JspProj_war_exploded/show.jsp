<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/9/8
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String userName = request.getParameter("userName");
    String password = request.getParameter("userPassword");
    String[] hobbies = request.getParameterValues("userHobbies");
%>
<h1>注册成功，用户信息如下</h1>
<p>用户名：<%=userName%>
</p>
<p>密码:<%=password%>
</p>

<p>
    <%
        if(hobbies != null && hobbies.length > 0){
            for(String h : hobbies){
                out.print(h + " ");
            }
        }
    %>
</p>
</body>
</html>
