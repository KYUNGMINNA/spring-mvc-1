<%--
  Created by IntelliJ IDEA.
  User: na
  Date: 2023-02-25
  Time: 오후 4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id=${member.id}</li>
  <li>username=${member.username}</li>
  <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>