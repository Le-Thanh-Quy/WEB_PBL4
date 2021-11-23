<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11/22/2021
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AddProvince" method="post">
    <input type="text" name="matp" placeholder="matp" value="${IDProvince}" readonly="readonly"><br><br>
    <input type="text" name="name" placeholder="name"><br><br>
    <input type="text" name="type" placeholder="type"><br><br>
    <input type="text" name="slug" placeholder="slug"><br><br>
    <input type="submit" value="Add province">
</form>
</body>
</html>
