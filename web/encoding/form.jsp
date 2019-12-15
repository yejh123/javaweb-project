<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/10/17
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form</title>
</head>
<body>
<form action="../EncodingServlet" method="post">
    输入一段字符：<input id="test1" type="text" name="test">
    <br/>
    <input type="submit">
</form><br/>

<form action="../EncodingServlet" method="get">
    输入一段字符：<input id="test2" type="text" name="test">
    <br/>
    <input type="submit">
</form><br/>
</body>
</html>
