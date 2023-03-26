<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: 81059
  Date: 2023/3/24
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  Person person = new Person();
  person.setName("hliu");
  person.setPhones(new String[]{"12312312312", "9394993493", "34929349234"});
  List<String> list = new ArrayList<>();
  list.add("北京");
  list.add("上海");
  list.add("深圳");
  person.setCities(list);

  Map<String, Object> map = new HashMap<>();
  map.put("key1", "val1");
  map.put("key2", "val2");
  map.put("key3", "val3");
  person.setMap(map);
  pageContext.setAttribute("person", person);
%>
输出Person: ${person}<br/>
输出Person的name属性: ${person.name}<br/>
输出Person的phones属性: ${person.phones[0]}<br/>
输出Person的cities属性: ${person.cities[0]}<br/>
输出Person的map属性: ${person.map.key1}<br/>

</body>
</html>
