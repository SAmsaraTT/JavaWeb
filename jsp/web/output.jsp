<%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/23
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.write("out输出1 <br/>");
    out.flush();
    out.write("out输出2 <br/>");
    response.getWriter().write("response输出1 <br/>");
    response.getWriter().write("response输出2 <br/>");

    out.print(12); //转化为write
%>
</body>
</html>
