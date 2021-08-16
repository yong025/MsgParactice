<%--
  Created by IntelliJ IDEA.
  User: stell
  Date: 2021-08-13
  Time: 오후 6:03
  To change this template use File | Settings | File Templates.
--%>

<%
    Object obj = session.getAttribute("mid");

    if(obj == null){
        response.sendRedirect("/login?result=fail");
        return;
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>write</h1>
<form action="logout.jsp">
    <button type="submit">Logout</button>
</form>
</body>
</html>
