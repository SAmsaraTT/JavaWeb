<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/24
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  Map<String, Object> map = new HashMap<>();
  map.put("a.a.a", "aaaVal");
  map.put("b+b+b", "bbbVal");
  map.put("c-c-c", "cccVal");

  request.setAttribute("map", map);
%>

${map['a.a.a']}<br/>
${map["b+b+b"]}<br/>
${map["c-c-c"]}<br/>
</body>
</html>
