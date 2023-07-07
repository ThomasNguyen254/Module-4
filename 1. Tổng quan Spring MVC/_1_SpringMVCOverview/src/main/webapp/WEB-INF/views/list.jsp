
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>
    </tr>
    <c:forEach items="${studentList}" var="student" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.gender}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>