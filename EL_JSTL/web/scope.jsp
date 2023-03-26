<%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/25
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("key1", "pageContext1");
    pageContext.setAttribute("key2", "pageContext2");
    request.setAttribute("key2", "request2");
    session.setAttribute("key2", "session2");
    application.setAttribute("key2", "application2");
%>
${requestScope.key2}
</body>
</html>
