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
    <title>Danh sach bai dang</title>
</head>
<body>
<input type="search" name="searchBox" id="searchBox">
<button for="searchBox" onclick="findPost()">OK</button>
<div id="data">
    <c:forEach items="${listPost}" var="post">
        <br><br>${post}<br>
        <a href="DeletePost?IDPost=${post.ID}">Delete</a>
    </c:forEach>
</div>

</body>
</html>
