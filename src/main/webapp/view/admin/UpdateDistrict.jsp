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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/updateAddress.css">
</head>
<body>
<h3>Cập nhật Quận/Huyện</h3>
<form action="${pageContext.request.contextPath}/UpdateDistrict" method="post">
    <ul>
        <li>
            <label>Mã QH</label>
            <input type="text" name="maqh" placeholder="Mã QH" value="${District.maqh}" readonly="readonly">
        </li>
        <li>
            <label>Tên Quận/Huyện</label>
            <input type="text" name="name" placeholder="Tên Quận/Huyện" value="${District.name}">
        </li>
        <li>
            <label>Kiểu</label>
            <input type="text" name="type" placeholder="Kiểu" value="${District.type}">
        </li>
        <li>
            <label>Mã TP</label>
            <input type="text" name="matp" placeholder="Mã TP" value="${District.matp}" readonly="readonly">
        </li>

    </ul>
    <input type="submit" value="Cập nhật">
</form>
</body>
</html>
