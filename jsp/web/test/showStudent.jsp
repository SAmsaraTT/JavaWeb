<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/23
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <style>
    table{
      border: 1px red solid;
      width: 600px;
      border-collapse: collapse;
    }
    td, th{
      border: 1px red solid;
    }

    td
  </style>
</head>
<body>
<%--输出一个表格包含10个学生信息--%>
<%
    List<Student> studentList = (List<Student>) request.getAttribute("stuList");
%>
<table>
  <tr>
    <td>id</td>
    <td>name</td>
    <td>age</td>
    <td>phone</td>
    <td>action</td>
  </tr>
    <%
        for (Student student : studentList) {
    %>
  <tr>
    <td><%=student.getId()%></td>
    <td><%=student.getName()%></td>
    <td><%=student.getAge()%></td>
    <td><%=student.getPhone()%></td>
    <td>update, delete</td>
  </tr>
    <%
        }
    %>
</table>
</body>
</html>
