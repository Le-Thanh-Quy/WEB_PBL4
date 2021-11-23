<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11/23/2021
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/UpdateCommune" method="post">
    <input type="text" name="xaid" placeholder="xaid" value="${Commune.xaid}" readonly="readonly"><br><br>
    <input type="text" name="name" placeholder="name" value="${Commune.name}"><br><br>
    <input type="text" name="type" placeholder="type" value="${Commune.type}"><br><br>
    <input type="text" name="maqh" placeholder="maqh" value="${Commune.maqh}" readonly="readonly"><br><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
