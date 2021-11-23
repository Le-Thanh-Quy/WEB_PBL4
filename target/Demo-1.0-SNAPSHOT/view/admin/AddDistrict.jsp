<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11/22/2021
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AddDistrict" method="post">
    <input type="text" name="name" placeholder="name"><br><br>
    <input type="text" name="type" placeholder="type"><br><br>
    <input type="text" name="IDProvince" value="${IDProvince}" readonly="readonly"><br><br>
    <input type="submit" value="Add district">
</form>
</body>
</html>
