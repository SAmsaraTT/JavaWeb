<%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/24
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("key", "val");
%>

表达式脚本输出key的值是：<%=request.getAttribute("key1")%><br/>
EL表达式输出key的值是：${key1}

</body>
</html>
