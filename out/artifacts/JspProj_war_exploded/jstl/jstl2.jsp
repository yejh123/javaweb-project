<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/10/4
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>jstl2.jsp</title>
</head>
<body>
====================c:when====================<br/>
<c:set var="role" value="学生" scope="request"/>
<c:choose>
    <c:when test="${requestScope.role == '学生'}">
        我是学生，我要上学
    </c:when>
    <c:when test="${requestScope.role == '教师'}">
        我是教师，我要授课
    </c:when>
    <c:otherwise>
        我是来搞事的
    </c:otherwise>
</c:choose>
<br/>
<br/>

====================c:forEach1====================<br/>
<%--javax.servlet.jsp.JspTagException: 'step' <= 0--%>
<c:forEach begin="2" end="5" step="1" varStatus="status">
    ${status}---${status.begin}---${status.end}
    ---${status.step}---${status.count}---${status.current}
    ---${status.first}---${status.index}---${status.last}<br/>
</c:forEach>

<br/>
<br/>


====================c:forEach2====================<br/>
<c:forEach var="name" items="${requestScope.names}" varStatus="status">
    ${name}
    <c:if test="${!status.last}">
        、
    </c:if>
</c:forEach>

<br/>
<br/>

====================c:forEach3====================<br/>
<c:forEach var="student" items="${requestScope.students}" varStatus="status">
    ${student}
    <c:if test="${!status.last}">
        、
    </c:if>
</c:forEach>
<br/>
<br/>


</body>
</html>
