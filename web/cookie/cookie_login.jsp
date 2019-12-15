<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/9/8
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie_login</title>
</head>
<body>
<%!
    String name;
%>
<%
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; ++i) {
        out.print(cookies[i].getName() + " --> " + cookies[i].getValue() + "<br/>");
        if (cookies[i].getName() .equals("userName")) {
            name = cookies[i].getValue();
            break;
        }
    }
%>
<form action="response_cookie.jsp" method="post">
    用户名：<input type="text" name="userName" value="<%=(name == null? "":name)%>"><br/>
    密码：<input type="password" name="userPassword"><br/>
    <br/>
    <input type="submit">
</form>

</body>
</html>
