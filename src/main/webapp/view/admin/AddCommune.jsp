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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/updateAddress.css">
</head>
<body>
<h3>Thêm mới Xã/Phường</h3>
<form action="${pageContext.request.contextPath}/AddCommune" method="post">
    <ul>
        <li>
            <label>Tên Xã/Phường</label>
            <input type="text" name="name" placeholder="Tên Xã/Phường">
        </li>
        <li>
            <label>Kiểu</label>
            <input type="text" name="type" placeholder="Kiểu">
        </li>
        <li>
            <label>Mã QH</label>
            <input type="text" name="IDDistrict" value="${IDDistrict}" readonly="readonly">
        </li>
    </ul>
    <input type="submit" value="Thêm mới">

</form>
</body>
</html>
