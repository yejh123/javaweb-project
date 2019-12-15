<%--
  Created by IntelliJ IDEA.
  User: yejh
  Date: 2019/10/5
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax.jsp</title>
    <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function checkUserName() {
            var $userName = $("#userName").val();

            /*$.ajax({
                url: "../UserNameServlet",
                type: "post",
                data: "userName=" + $userName,
                success: function (result, testStatus) {
                    if (result === "true") {
                        alert("已存在！注册失败！");
                    } else {
                        alert("注册成功！");
                    }
                },
                error: function (xhr, errrorMessage, e) {
                    alert("系统异常！");
                }
            });*/


            /*$.post(
                "../UserNameServlet",
                "userName=" + $userName,
                function (result) {
                    if (result === "true") {
                        alert("已存在！注册失败！");
                    } else {
                        alert("注册成功！");
                    }
                },
                "text"
            );*/


            /*$.get(
                "../UserNameServlet",
                "userName=" + $userName,
                function (result) {
                    if (result === "true") {
                        alert("已存在！注册失败！");
                    } else {
                        alert("注册成功！");
                    }
                }
            );*/


            /*$("#tip").load(
                "../UserNameServlet",
                "userName=" + $userName
            );*/


            /*var student = {"name": "zs", "age": 23};

            //alert(student.name +"--" +student.age) ;
            //var name = ["xx","xx","xx"] ;
            var students = [

                {"name": "zs", "age": 23},
                {"name": "ls", "age": 24},
                {"name": "ww", "age": 25}

            ];
            alert(students[1].name + "--" + students[1].age);*/

            $.getJSON(
                "../UserNameServlet",
                //	"mobile="+$mobile,
                {"userName": $userName},
                function (result) {//msg:true|false
                    if (result.msg === "true") {
                        alert("已存在！注册失败！");
                    } else {
                        alert("注册成功！");
                    }
                }
            );
        }

        function testJson() {
            $.getJSON(
                "../JsonServlet",
                {"userName":"傻逼昌", "age":24},
                function (result) {
                    //result已经是json对象
                    alert("result = " + result);
                    var json = eval(result);
                    alert("json = " + json);
                    $.each(result, function (i, element) {
                        alert( this.sname +"---"+ this.sage + "---" + this);
                    } );
                }
            )
        }
    </script>

</head>
<body>

用户名：<input id="userName" type="text" name="userName">
<input type="button" value="验证" onclick="checkUserName()"><br/>

<span id="tip"></span>
<input type="button" value="测试json" onclick="testJson()" />
</body>
</html>
