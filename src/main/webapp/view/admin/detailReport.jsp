<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>chitiet</title>
    <script>
        function goBack() {
            window.history.back();
        }
    </script>

</head>
<body>
<h3>Chi tiết báo cáo</h3>
<form method="post" action="updateReport">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="ID" value="${report.getID()}" readonly></td>
        </tr>
        <tr>
            <td>Người báo cáo</td>
            <td><input type="text" value="${report.getUserReport().getName()}" readonly></td>
        </tr>
        <tr>
            <td>Người bị báo cáo</td>
            <td><input type="text" value="${report.getUserViolate().getName()}" readonly></td>
        </tr>
        <tr>
            <td>Thời gian</td>
            <td><input type="text" value="${report.getTime()}" readonly></td>
        </tr>
        <tr>
            <td>Nội dung</td>
            <td>
                <textarea name="" cols="30" rows="10" readonly>${report.getContent()}</textarea>
            </td>
        </tr>
        <tr>
            <td>Tình trạng</td>
            <c:if test="${report.isStatus()}">
                <td><label>Đã xử lý</label></td>
            </c:if>
            <c:if test="${!report.isStatus()}">
                <td><label>Chưa xử lý</label></td>
            </c:if>
        </tr>
        <tr>
            <td>Phản hồi</td>
            <td>
                <textarea name="feedback"  cols="30" rows="10">${report.getFeedback()}</textarea>
            </td>
        </tr>
    </table>
    <button onclick="goBack()">Go Back</button>
    <input type="submit" value="Gửi phản hồi">
</form>

</body>
</html>
