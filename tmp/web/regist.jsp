<%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/4/3
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="http://localhost:8080/tmp/registServlet" method="get">
    用户名：<input type="text" name="username"><br/>
    验证码：<input type="text" name="code" style="width: 50px">
    <img src="http://localhost:8080/tmp/kaptcha.jpg" style="width: 100px; height: 28px"><br/>
    <input type="submit" value="登录">
  </form>
  </body>
</html>
