<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11/23/2021
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AddCommune" method="post">
    <input type="text" name="name" placeholder="name"><br><br>
    <input type="text" name="type" placeholder="type"><br><br>
    <input type="text" name="IDDistrict" value="${IDDistrict}" readonly="readonly"><br><br>
    <input type="submit" value="Add Commune">
</form>
</body>
</html>
