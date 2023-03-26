<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/24
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  //1.值为null值的时候，为空
  request.setAttribute("emptyNull", null);

  //2.值为空串的时候
  request.setAttribute("emptyString", "");

  //3.值是Object对象类型的数组
  request.setAttribute("emptyArr", new Object[]{});

  //4.list集合， 元素个数为零
  request.setAttribute("emptyList", new ArrayList<>());

  //5.map集合， 元素个数为零
  request.setAttribute("emptyMap", new HashMap<>());

%>
${empty emptyNull}<br/>
${empty emptyString}<br/>
${empty emptyArr}<br/>
${empty emptyList}<br/>
${empty emptyMap}<br/>

<hr>

${12 == 12 ? "牛的" : "不牛的"}
</body>
</html>
