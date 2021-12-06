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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/updateAddress.css">
</head>
<body>
<h3>Thêm mới Quận/Huyện</h3>
<form action="${pageContext.request.contextPath}/AddDistrict" method="post">
    <ul>
        <li>
            <label>Tên Quận/Huyện</label>
            <input type="text" name="name" placeholder="Tên Quận/Huyện">
        </li>
        <li>
            <label>Kiểu</label>
            <input type="text" name="type" placeholder="Kiểu">
        </li>
        <li>
            <label>Mã TP</label>
            <input type="text" name="IDProvince" value="${IDProvince}" readonly="readonly">
        </li>
    </ul>
    <input type="submit" value="Thêm mới">
</form>
</body>
</html>
