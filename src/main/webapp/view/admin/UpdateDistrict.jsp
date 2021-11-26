<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11/22/2021
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/UpdateDistrict" method="post">
    <input type="text" name="maqh" placeholder="maqh" value="${District.maqh}" readonly="readonly"><br><br>
    <input type="text" name="name" placeholder="name" value="${District.name}"><br><br>
    <input type="text" name="type" placeholder="type" value="${District.type}"><br><br>
    <input type="text" name="matp" placeholder="matp" value="${District.matp}" readonly="readonly"><br><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
