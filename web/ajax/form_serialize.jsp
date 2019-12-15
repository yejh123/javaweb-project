<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/10/20
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form_serialize.jsp</title>
    <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    <script>
        $(function () {
            $("#btn_submit").click(function () {
                var data = $("#form").serialize();
                alert(data);
                $.ajax({
                    url: "../UserNameServlet",
                    data:data,
                    success:function (data) {
                        alert(data);
                    },
                    error:function () {
                        alert("出错...");
                    }
                })
            })
        })
    </script>
</head>
<body>
<form id="form">
    用户名：<input id="userName" type="text" name="userName">
    <br/>
    密码：<input type="password" name="userPassword"><br/>
    <br/>
    <input id="btn_submit" type="submit">
</form>
</body>
</html>
