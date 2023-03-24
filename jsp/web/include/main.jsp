<%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/23
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
头部信息<br/>
主体内容<br/>
<%--这就是静态包含--%>
<%--<%@ include file="/include/foot.jsp"%>--%>

<%--这是动态包含
会把被包含的jsp页也翻译为java代码
--%>
<jsp:include page="/include/foot.jsp"></jsp:include>
</body>
</html>
