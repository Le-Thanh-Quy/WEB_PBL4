<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/table.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <title>Danh sach nguoi dung</title>
</head>

<body>
<input type="search" name="searchBox" id="searchBox">
<button for="searchBox">OK</button>
<br>
<label for="phan_quyen">Chọn phân quyền người dùng:</label>
<select id="phan_quyen">
    <option value="0">Chọn đi nào</option>
    <option value="1">Admin</option>
    <option value="2">Người dùng</option>
</select>
<table>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Giới tính</th>
        <th>Đánh giá</th>
        <th>Phân quyền</th>
        <th>Action</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Huy Hoàng</td>
        <td>06/06/2001</td>
        <td>Nam</td>
        <td>Rất tốt</td>
        <td>Tao là admin</td>
        <td>
            <a href=""> <i class="fas fa-eye"></i> </a>
            <a href=""> <i class="fas fa-edit"></i> </a>
            <a href=""> <i class="fas fa-trash-alt"></i> </a>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td>Thanh Quý</td>
        <td>Bố chiệu</td>
        <td>Nam</td>
        <td>Nên xóa</td>
        <td>Chúa lừa</td>
        <td>
            <a href=""> <i class="fas fa-eye"></i> </a>
            <a href=""> <i class="fas fa-edit"></i> </a>
            <a href=""> <i class="fas fa-trash-alt"></i> </a>
        </td>
    </tr>
    <tr>
        <td>3</td>
        <td>Anh Trình</td>
        <td>Chiệu nốt</td>
        <td>Nam</td>
        <td>Cũng thường</td>
        <td>Người dùng</td>
        <td>
            <a href=""> <i class="fas fa-eye"></i> </a>
            <a href=""> <i class="fas fa-edit"></i> </a>
            <a href=""> <i class="fas fa-trash-alt"></i> </a>
        </td>
    </tr>
    <tr>
        <td>4</td>
        <td>Quý lừa đảo</td>
        <td>30/02/2001</td>
        <td>Nam</td>
        <td>Xóa luôn</td>
        <td>Người lừa</td>
        <td>
            <a href=""> <i class="fas fa-eye"></i> </a>
            <a href=""> <i class="fas fa-edit"></i> </a>
            <a href=""> <i class="fas fa-trash-alt"></i> </a>
        </td>
    </tr>
</table>
</body>

</html>
