<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/10/4
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>listener_test.jsp</title>
</head>
<body>
<%
    application.setAttribute("app", "app1");
    application.setAttribute("app", "app2");
    application.removeAttribute("app");

    request.setAttribute("request", "request1");
    request.setAttribute("request", "request2");
    request.removeAttribute("request");

    session.setAttribute("session", "session1");
    session.setAttribute("session", "session2");
    session.removeAttribute("session");
%>

<c:set var="jstl_request" value="jstl_request1" scope="request"/>
<c:set var="jstl_request" value="jstl_request2" scope="request"/>
<c:remove var="jstl_request"/>


</body>
</html>
