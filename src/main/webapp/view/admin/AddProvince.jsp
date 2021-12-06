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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/updateAddress.css">
</head>
<body>
<h3>Thêm mới Tỉnh/Thành Phố</h3>
<form action="${pageContext.request.contextPath}/AddProvince" method="post">
    <ul>
        <li>
            <label>Mã TP</label>
            <input type="text" name="matp" placeholder="Mã TP" value="${IDProvince}" readonly="readonly">
        </li>
        <li>
            <label>Tên Thỉnh/Thành Phố</label>
            <input type="text" name="name" placeholder="Tên Tỉnh/Thành Phố">
        </li>
        <li>
            <label>Kiểu</label>
            <input type="text" name="type" placeholder="Kiểu">
        </li>
        <li>
            <label>Slug</label>
            <input type="text" name="slug" placeholder="slug">
        </li>
    </ul>
    <input type="submit" value="Thêm mới">
</form>
</body>
</html>
