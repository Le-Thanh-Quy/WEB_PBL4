<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/table.css">
    <title>Xoa cac bai dang</title>
</head>
<body>
<input type="search" name="searchBox" id="searchBox">
<button for="searchBox">OK</button>
<button>Xóa mẹ đi</button>
<table>
    <tr>
        <th>ID.Post</th>
        <th>Người đăng</th>
        <th>Đi từ</th>
        <th>Đến</th>
        <th>Ngày</th>
        <th>Giờ</th>
        <th>Mô tả</th>
        <th>Choose</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Huy Hoàng</td>
        <td>Duy Thu, Duy Xuyên, Quảng Nam</td>
        <td>Nam Phước, Duy Xuyên, Quảng Nam</td>
        <td>20/11/2021</td>
        <td>7:00-9:00</td>
        <td>Uy tín</td>
        <td><input type="checkbox" name="checkDelete" id="1"></td>
    </tr>
    <tr>
        <td>2</td>
        <td>Thanh Quý</td>
        <td>Tam Xuân, Núi Thành, Quảng Nam</td>
        <td>Nam Phước, Duy Xuyên, Quảng Nam</td>
        <td>20/11/2021</td>
        <td>10:00-12:00</td>
        <td>Lừa đảo</td>
        <td><input type="checkbox" name="checkDelete" id="2"></td>
    </tr>
</table>
</body>
</html>
