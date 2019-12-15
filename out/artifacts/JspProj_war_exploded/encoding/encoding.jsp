<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/10/17
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>encoding.jsp</title>
</head>
<body>
<%
    String str = request.getParameter("test");

    request.getRequestDispatcher("../EncodingServlet").forward(request,response);

%>

</body>
</html>
