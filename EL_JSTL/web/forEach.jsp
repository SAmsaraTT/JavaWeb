<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.atguigu.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/25
  Time: 21:48
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
<%--1.遍历1到10--%>
<table border="1">
    <c:forEach begin="1" end="10" var="i">
    <tr>
        <td>第${i}行</td>
    </tr>
    </c:forEach>
</table>
<hr>
<%--2.遍历Object数组--%>
<%
    request.setAttribute("arr", new String[]{"12312312", "5423521342", "25123414125"});
%>
<c:forEach items="${requestScope.arr}" var="i">
    ${i}<br/>
</c:forEach>

<hr>
<%--3.遍历Map--%>
<%
    Map<String, Object> map = new HashMap<>();
    map.put("key1", "val1");
    map.put("key2", "val2");
    map.put("key3", "val3");
    request.setAttribute("map", map);
%>

<c:forEach items="${requestScope.map}" var="entry">
    <h1>${entry.key}</h1>
</c:forEach>
<hr>
<%--4.遍历List--%>
        <%
            List<Student> list = new ArrayList<>();
            for(int i = 0; i < 10; i++) {
              list.add(new Student(1 + i, "username" + i, "pass" + i, 18 + i, "phone" + i));
            }
            request.setAttribute("stu", list);
        %>
        <table border="1">
            <tr>
                <td>id</td>
                <td>username</td>
                <td>password</td>
                <td>age</td>
                <td>phone</td>
                <td>operations</td>
            </tr>
        <c:forEach begin="2" end="7" step="2" varStatus="status" items="${requestScope.stu}" var="stu">
            <tr>
                <td> ${stu.id}</td>
                <td> ${stu.username}</td>
                <td> ${stu.password}</td>
                <td> ${stu.age}</td>
                <td> ${stu.phone}</td>
                <td> ${status.index}</td>
            </tr>
        </c:forEach>
        </table>
</body>
</html>
