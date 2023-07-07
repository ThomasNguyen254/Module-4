
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ứng dụng gia vị Sandwich</h1>

<h2>Gia vị:</h2>
<form id="spiceForm" action="/view?action=save" method="post">
    <label>
        <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Tomato"> Tomato
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Mustard"> Mustard
    </label>
    <label>
        <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
    </label>
    <br>
    <button type="submit">Save</button>
</form>
</body>
</html>
