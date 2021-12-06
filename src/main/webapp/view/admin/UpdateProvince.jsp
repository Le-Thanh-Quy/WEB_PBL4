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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/updateAddress.css">
</head>
<body>
<h3>Cập nhật Tỉnh/Thành Phố</h3>
<form action="${pageContext.request.contextPath}/UpdateProvince" method="post">
    <ul>
        <li>
            <label>Mã TP</label>
            <input type="text" name="matp" placeholder="Mã Thành Phố" value="${Province.matp}" readonly="readonly">
        </li>
        <li>
            <label>Tên Tỉnh/Thành Phố</label>
            <input type="text" name="name" placeholder="Tên Tỉnh Thành Phố" value="${Province.name}">
        </li>
        <li>
            <label>Kiểu</label>
            <input type="text" name="type" placeholder="Kiểu" value="${Province.type}">
        </li>
        <li>
            <label>Slug</label>
            <input type="text" name="slug" placeholder="slug" value="${Province.slug}">
        </li>

    </ul>
    <input type="submit" value="Cập nhật">
</form>
</body>
</html>
