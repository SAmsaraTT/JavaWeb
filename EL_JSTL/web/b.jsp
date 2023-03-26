<%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/24
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //四个域
    //pageContext.setAttribute("key", "pageContext");
    //request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
${key}
</body>
</html>
