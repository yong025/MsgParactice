<%--
  Created by IntelliJ IDEA.
  User: stell
  Date: 2021-08-14
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>

<%
session.removeAttribute("mid");
session.invalidate();

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>logout</h1>
</body>
</html>
