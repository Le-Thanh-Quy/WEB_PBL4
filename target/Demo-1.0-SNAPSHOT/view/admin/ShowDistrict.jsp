<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11/22/2021
  Time: 8:05 PM
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
    <c:forEach items="${ListDistrict}" var="i">
        <tr>
            <td>${i.getMaqh()}</td>
            <td>${i.getName()}</td>
            <td>${i.getType()}</td>
            <td>${i.getMatp()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
