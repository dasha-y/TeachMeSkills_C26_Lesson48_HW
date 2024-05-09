<%--
  Created by IntelliJ IDEA.
  User: Darya
  Date: 09.05.2024
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator history</title>
</head>
<body>
<ul>
    <c:forEach items="${operationList}" var="operation">
        <li>${operation}</li>
    </c:forEach>
</ul>
</body>
</html>
