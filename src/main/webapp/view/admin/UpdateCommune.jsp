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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/updateAddress.css">
</head>
<body>
<h3>Cập nhật Xã/Phường</h3>
<form action="${pageContext.request.contextPath}/UpdateCommune" method="post">
    <ul>
        <li>
            <label>Mã XP</label>
            <input type="text" name="xaid" placeholder="Mã XP" value="${Commune.xaid}" readonly="readonly">
        </li>
        <li>
            <label>Tên Xã/Phường</label>
            <input type="text" name="name" placeholder="Tên Xã/Phường" value="${Commune.name}">
        </li>
        <li>
            <label>Kiểu</label>
            <input type="text" name="type" placeholder="Kiểu" value="${Commune.type}">
        </li>
        <li>
            <label>Mã QH</label>
            <input type="text" name="maqh" placeholder="Mã QH" value="${Commune.maqh}" readonly="readonly">
        </li>

    </ul>
    <input type="submit" value="Cập nhật">
</form>
</body>
</html>
