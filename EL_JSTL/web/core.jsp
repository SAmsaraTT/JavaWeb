<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/25
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--往域里面保存数据--%>
保存之前：${requestScope.abc}<br>
<c:set scope="request" var="abc" value="abcValue"/>
保存之后：${requestScope.abc}<br>

<%--if标签
test属性使用EL表达式
--%>
<c:if test="${12 != 12}">
    <h1>12等于12</h1>
</c:if>

<%--多路判断--%>
<%
    request.setAttribute("height", 155);
%>

<c:choose>
    <c:when test="${requestScope.height > 190}">
        <h2>小巨人</h2>
    </c:when>
    <c:when test="${requestScope.height > 180}">
        <h2>很高</h2>
    </c:when>
    <c:when test="${requestScope.height > 170}">
        <h2>还可以</h2>
    </c:when>
    <c:otherwise>
       <c:choose>
           <c:when test="${requestScope.height > 160}">
               <h3>大于160</h3>
           </c:when>
           <c:when test="${requestScope.height > 150}">
               <h3>大于150</h3>
           </c:when>
           <c:when test="${requestScope.height > 140}">
               <h3>大于140</h3>
           </c:when>
           <c:otherwise>
               <h3>小于于140</h3>
           </c:otherwise>
       </c:choose>
    </c:otherwise>
</c:choose>
</body>
</html>
