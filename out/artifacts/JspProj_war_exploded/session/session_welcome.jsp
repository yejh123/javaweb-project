<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/9/13
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.yejhsimple.com" prefix="ys"%>
<html>
<head>
    <title>session_welcome</title>
    <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                <%
                    request.getRequestDispatcher("/QueryStudentByPageServlet").forward(request,response);
                %>
            })
        })
    </script>
</head>
<body>
<ys:login>
    ${sessionScope.userName}，欢迎您！
</ys:login>
<br/>
<button id="btn">进入主界面</button>
</body>
</html>
