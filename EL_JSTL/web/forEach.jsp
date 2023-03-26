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

<%--2.遍历Object数组--%>
<%
    request.setAttribute("arr", new String[]{"12312312", "5423521342", "25123414125"});
%>

</body>
</html>
