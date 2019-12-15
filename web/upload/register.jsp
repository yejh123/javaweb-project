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
    <title>register</title>

</head>

<body>
    <form action = "../UploadServlet" method="post" enctype="multipart/form-data">
        学号：<input type="text" name="sno"><br/>
        姓名：<input type="text" name="sname"><br/>
<%--        爱好：<input type="checkbox" name="userHobbies" value="足球">足球--%>
<%--        <input type="checkbox" name="userHobbies" value="篮球">篮球--%>
<%--        <input type="checkbox" name="userHobbies" value="羽毛球">羽毛球--%>

        <input type="file" name="spicture"/><br/>
        <input type="submit">
    </form>

<br/>
<a href="../DownloadServlet?filename=MIME.jpg">MIME.jpg</a>
</body>
</html>
