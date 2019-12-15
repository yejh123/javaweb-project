<%@ page import="dao.StudentUser" %>
<%@ page import="dao.LoginDao" %><%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/9/22
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dao_check</title>
</head>
<body>
<%
    //request.setCharacterEncoding("utf-8");
    String userName = request.getParameter("userName");
    String password = request.getParameter("userPassword");
    StudentUser studentUser = new StudentUser(userName, password);

    int res = new LoginDao().login(studentUser);
    if(res > 0){
        out.print("登陆成功");
    }else if(res == 0){
        out.print("用户名或密码有误");
    }else{
        out.print("系统错误");
    }
%>
</body>
</html>
