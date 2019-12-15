<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/10/13
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.yejh.com" prefix="y" %>
<%@ taglib uri="http://www.yejhsimple.com" prefix="ys" %>
<html>
<head>
    <title>tag.jsp</title>
</head>
<body>
<%--传统标签--%>
<y:mytag num="3">
    <%
        out.print("fuck you" + "<br/>");
    %>
</y:mytag>

<y:myToUpperCase>
    fuck you !
</y:myToUpperCase>

<br/>
<%--简单标签--%>
<ys:login>
    ${sessionScope.userName}，欢迎您！
</ys:login>


</body>
</html>
