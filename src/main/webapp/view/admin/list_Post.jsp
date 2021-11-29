<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/table.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <script src="${pageContext.request.contextPath}/Asset/js/FindPost.js"></script>
    <title>Danh sách bài đăng</title>
</head>
<body>
<input type="search" name="searchBox" id="searchBox">
<button for="searchBox" onclick="findPost()">OK</button>
<table>
    <tr>
        <th>ID</th>
        <th>Người đăng</th>
        <th>Điểm xuất phát</th>
        <th>Điểm đến</th>
        <th>Ngày khởi hành</th>
        <th>Giờ khởi hành</th>
        <th>Chi tiết</th>
    </tr>
    <c:forEach items="${listPost}" var="item">
        <tr>
            <td>${item.getID()}</td>
            <td>${item.getUser().getName()}</td>
            <td>${item.getStartCommune()}, ${item.getStartDistrict()}, ${item.getStartProvince()}</td>
            <td>${item.getEndCommune()}, ${item.getEndDistrict()}, ${item.getEndProvince()}</td>
            <td>${item.getDate()}</td>
            <td>${item.getTimeStart()}</td>
            <td>
                <a href=""> <i class="fas fa-eye"></i> </a>
            </td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
