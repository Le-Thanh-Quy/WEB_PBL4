<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11/22/2021
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/UpdateProvince" method="post">
    <input type="text" name="matp" placeholder="matp" value="${Province.matp}" readonly="readonly"><br><br>
    <input type="text" name="name" placeholder="name" value="${Province.name}"><br><br>
    <input type="text" name="type" placeholder="type" value="${Province.type}"><br><br>
    <input type="text" name="slug" placeholder="slug" value="${Province.slug}"><br><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
