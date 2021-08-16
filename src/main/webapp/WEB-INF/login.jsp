<%--
  Created by IntelliJ IDEA.
  User: stell
  Date: 2021-08-13
  Time: 오후 6:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .warnDiv{
        background-color: #974a2d;
    }
</style>
<body>
<h1>Login JSP</h1>

<c:if test="${param.result != null && param.result.equals('fail')}" >
    <div class="warnDiv">
<h2>Login FAILED</h2>
    </div>
</c:if>
<form action="/login" method="post">
ID:<input type="text" name="mid">
PW:<input type="text" name="mpw">
<button type="submit">Login</button>
</form>
</body>
</html>
