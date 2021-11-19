<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/table.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <title>Danh sach bai dang</title>
</head>
<body>
<input type="search" name="searchBox" id="searchBox">
<button for="searchBox">OK</button>
<table>
    <tr>
        <th>ID.Post</th>
        <th>Người đăng</th>
        <th>Đi từ</th>
        <th>Đến</th>
        <th>Ngày</th>
        <th>Giờ</th>
        <th>Mô tả</th>
        <th>Action</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Huy Hoàng</td>
        <td>Duy Thu, Duy Xuyên, Quảng Nam</td>
        <td>Nam Phước, Duy Xuyên, Quảng Nam</td>
        <td>20/11/2021</td>
        <td>7:00-9:00</td>
        <td>Uy tín</td>
        <td>
            <a href=""> <i class="fas fa-eye"></i> </a>
            <a href=""> <i class="fas fa-edit"></i> </a>
            <a href=""> <i class="fas fa-trash-alt"></i> </a>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td>Thanh Quý</td>
        <td>Tam Xuân, Núi Thành, Quảng Nam</td>
        <td>Nam Phước, Duy Xuyên, Quảng Nam</td>
        <td>20/11/2021</td>
        <td>10:00-12:00</td>
        <td>Lừa đảo</td>
        <td>
            <a href=""> <i class="fas fa-eye"></i> </a>
            <a href=""> <i class="fas fa-edit"></i> </a>
            <a href=""> <i class="fas fa-trash-alt"></i> </a>
        </td>
    </tr>
</table>
</body>
</html>
