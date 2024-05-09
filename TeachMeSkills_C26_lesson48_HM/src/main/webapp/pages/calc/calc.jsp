<%--
  Created by IntelliJ IDEA.
  User: Darya
  Date: 09.05.2024
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<form action="/calc/calc" method="post">
    <input type="number" name="num1" placeholder="Number 1">
    <input type="text" name="operationType" placeholder="Operation type">
    <input type="number" name="num2" placeholder="Number 2">
    <button>Calculate</button>
</form>
</body>
</html>
