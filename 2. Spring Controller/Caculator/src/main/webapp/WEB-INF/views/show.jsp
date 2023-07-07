<%--
  Created by IntelliJ IDEA.
  User: thomasnguyen
  Date: 05/07/2023
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result" method="post">
    <input type="number" name="num1" required/><br/><br/>
    <input type="number" name="num2" required/><br/><br/>
    <select name="operator" required>
        <option value="add">+</option>
        <option value="subtract">-</option>
        <option value="multiply">*</option>
        <option value="divide">/</option>
    </select>
    <input type="submit" value="Calculate"/>
</form>
</body>
</html>
