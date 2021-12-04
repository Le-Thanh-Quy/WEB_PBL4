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
    <title>report</title>

</head>
<body>
<form>
    <table>
        <tr>
            <th>ID</th>
            <th>Người báo cáo</th>
            <th>Thời gian</th>
            <th>Trạng thái</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listReport}" var="item">
            <tr class="tag${listReport.indexOf(item)%2}">
                <td>${item.getID()}</td>
                <td>${item.getUserReport().getName()}</td>
                <td>${item.getTime()}</td>
                <c:if test="${!item.isStatus()}">
                    <td>Chưa xử lý</td>
                </c:if>
                <c:if test="${item.isStatus()}">
                    <td>Đã xử lý</td>
                </c:if>
                <td>
                    <a href="detailReport?IDRP=${item.getID()}"> <i class="fas fa-eye"></i> </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
