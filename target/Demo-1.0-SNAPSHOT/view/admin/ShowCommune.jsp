<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11/23/2021
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/table.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>maqh</th>
        <th>name</th>
        <th>type</th>
        <th>matp</th>
    </tr>
    <c:forEach items="${ListCommune}" var="i">
        <tr>
            <td>${i.getXaid()}</td>
            <td>${i.getName()}</td>
            <td>${i.getType()}</td>
            <td>${i.getMaqh()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
