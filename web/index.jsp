<%@page import="org.student.entity.Student" %>
<%@page import="java.util.List" %>
<%@ page import="org.student.entity.Page" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("tr:odd").css("background-color", "lightgray");
        });

    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生信息列表</title>
</head>

<body>
<%
    //error:adderror 失败
    //否则：1 确实执行了增加    2直接访问查询全部页面
    String error = (String) request.getAttribute("error");//addError
    if (error != null) {
        if (error.equals("addError")) {
            out.print("增加失败！");
        } else if (error.equals("noaddError")) {
            out.print("增加成功！");
        }//根本没有执行增加
    }

%>


<table border="1px">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>

    <%
        //获取request域中的数据
        Page p = (Page) request.getAttribute("page");
        if (p == null) {
            request.getRequestDispatcher("QueryStudentByPageServlet").forward(request, response);
        }

        for(Student student : p.getItems()){
    %>
    <tr>
        <td><a href="QueryStudentBySnoServlet?sno=<%=student.getSno() %>"><%=student.getSno() %>
        </a></td>

        <td><%=student.getSname() %>
        </td>
        <td><%=student.getSage() %>
        </td>
        <td><a href="DeleteStudentServlet?sno=<%=student.getSno() %>">删除</a></td>

    </tr>
    <%
        }
    %>

</table>
<a href="add.jsp">新增</a><br/>
当前总数据：<%=p.getTotalItems()%>
&nbsp;当前页数：<%=p.getCurrentPage()%>/<%=p.getTotalPage()%>
<%
    if(p.getCurrentPage()==1){

%>
<a href="QueryStudentByPageServlet?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
<a href="QueryStudentByPageServlet?currentPage=<%=p.getTotalPage()%>">尾页</a>
<%
    }
    else if(p.getCurrentPage() == p.getTotalPage()){
%>
<a href="QueryStudentByPageServlet?currentPage=1">首页</a>
<a href="QueryStudentByPageServlet?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
<%
    }
    else {
%>
<a href="QueryStudentByPageServlet?currentPage=1">首页</a>
<a href="QueryStudentByPageServlet?currentPage=<%=p.getCurrentPage()-1%>">上一页</a>
<a href="QueryStudentByPageServlet?currentPage=<%=p.getCurrentPage()+1%>">下一页</a>
<a href="QueryStudentByPageServlet?currentPage=<%=p.getTotalPage()%>">尾页</a>
<%
    }
%>

<br/>
调整页面大小：<select name="pageSize">
    <option value="3">3</option>
    <option value="5">5</option>
    <option value="10">10</option>

</select>
</body>
</html>