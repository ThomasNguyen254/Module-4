<%--
  Created by IntelliJ IDEA.
  User: thomasnguyen
  Date: 03/07/2023
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/view" method="post">
    <input type="text" placeholder="Type USD" name="USD">
    <input type="text" placeholder="Type rate" name="rate">
    <button type="submit">Revert</button>
</form>

<p>Result : ${result}</p>
</body>
</html>
