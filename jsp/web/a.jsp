<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/22
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--1.声明类属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String, Object> map;
%>

<%--2.声明静态代码块--%>
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("key1", "v1");
        map.put("key2", "v2");
        map.put("key3", "v3");
    }
%>

<%--3.声明类的方法--%>
<%!
    public int abc() {
        return 12;
    }
%>

<%--4.声明内部类--%>
<%!
    public static class A {
        private Integer id = 12;
        private String abc = "abc";
    }
%>

<%--输出对象--%>
<%=12 %><br/>
<%=12.0 %><br/>
<%="我是字符串" %><br/>
<%=map %><br/>
<%=request.getParameter("username") %><br/>

<%--代码脚本--%>
<%--1. if语句--%>
<%
    int i = 12;
    if (i == 12) {
%>
<h1>牛的</h1>
<%
} else {
%>
<h1>不牛的</h1>
<%
    }
%>

<%--2.for 循环--%>
<table border="1" cellspacing="0">


<%
    for (int j = 0; j < 10; j++) {

%>
    <tr>
        <td>第<%=j %>行</td>
    </tr>
<%
        System.out.println(j);
    }
%>
</table>

<%--java文件中_jspService方法内的代码都可以写--%>
<%
    String username = request.getParameter("username");
    System.out.println(username);
%>
</body>
</html>
