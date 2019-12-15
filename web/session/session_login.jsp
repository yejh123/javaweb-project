<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="java.util.UUID" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/9/13
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function checkUserName() {
            //使用xhr对象发送ajax请求
            userName = document.getElementById("userName").value;
            //alert("userName: " + userName);
            xmlHttpRequest = new XMLHttpRequest();

            //设置xmlHttpRequest对象的回调函数
            xmlHttpRequest.onreadystatechange = callBack;

            //与服务端建立连接,通过ajax异步方式 请求服务端
            xmlHttpRequest.open("post", "../UserNameServlet", true);

            //设置post方式的 头信息
            xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xmlHttpRequest.send("userName=" + userName);//k=v
        }

        function callBack() {
            if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
                var isUsed = xmlHttpRequest.responseText;
                alert(isUsed);
                if ("true" === isUsed) {
                    alert(userName + " 用户名已注册");
                } else {
                    alert(userName + " 用户名尚未注册");
                }

            }
        }

        function checkUserNameByAjax() {
            var $userName = $("#userName").val();
            $.getJSON(
                "../UserNameServlet",
                "userName=" + $userName,
                function (result) {
                    //result仍是字符串！！！故需要再转一次
                    //alert("result = " + result);
                    var json = result;
                    $.each(json, function (i) {
                        alert(i + "---" + this);
                    });
                    var isUsed = json.msg;
                    //alert(isUsed);
                    if (true === isUsed) {
                        alert($userName + " 用户名已注册");
                    } else {
                        alert($userName + " 用户名尚未注册");
                    }
                }
            )
        }
    </script>
    <title>session_login</title>
</head>
<body>
<%!
    String userName;
%>
<%
    userName = (String) session.getAttribute("userName");

    //加入token机制可以防止表单重复提交
    /*
        如果不加入token机制
        1、用户在登陆成功页面刷新，会进行多次登陆，导致多次访问数据库
        2、提交表单的延迟时段如果用户点击多次提交按钮，将会进行多次登陆，导致多次访问数据库
        3、登陆成功后回退到登陆页面，再点击提交按钮，又会再次访问数据库
     */
    String token = UUID.randomUUID().toString();
    session.setAttribute("token", token);

%>
<form action="../LoginServlet" method="post">
    用户名：<input id="userName" type="text" name="userName" value="<%=(userName == null? "":userName)%>">
    <input type="button" value="验证" onclick="checkUserNameByAjax()">
    <br/>
    密码：<input type="password" name="userPassword"><br/>
    <br/>
    token：<input type="text" name="token" value="<%= token %>">
    <input type="submit">
</form>
<br/>

<%-- jndi --%>
<%
    Context ctx = new InitialContext();
    String testJndi = (String) ctx.lookup("java:comp/env/jndiName");
    /*
    response.getWriter()和out的区别：
    (1)、out和response.getWriter的类不一样，一个是JspWriter，另一个是java.io.PrintWriter。
    (2)、执行原理不同:JspWriter相当于一个带缓存功能的printWriter，它不是直接将数据输出到页面，而是将数据刷新到response的缓冲区后再输出，
      response.getWriter直接输出数据（response.print()），所以（out.print）只能在其后输出。
    (3)、out为jsp的内置对象，刷新jsp页面，自动初始化获得out对象，所以使用out对象是需要刷新页面的，
       而response.getWriter()响应信息通过out对象输出到网页上，当响应结束时它自动被关闭，与jsp页面无关，无需刷新页面
       形象的比喻：当我们调用response.getWriter()这个对象同时获得了网页的画笔，这时你就可以通过这个画笔在网页上画任何你想要显示的东西。
    (4)、out的print()方法和println()方法在缓冲区溢出并且没有自动刷新时候会产生ioexception，
       而response.getWrite()方法的print和println中都是抑制ioexception异常的，不会有ioexception
     */
    out.print("jndi: " + testJndi);
    PrintWriter writer = response.getWriter();
    writer.write("response.getWriter()：虽然我代码写在out后面，但是一定是我先输出");
%>
</body>
</html>
