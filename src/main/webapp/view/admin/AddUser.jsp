<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" icontent="width=device-width, initial-scale=1.0">
    <title>Cập nhật thông tin cá nhân</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/updateUser.css">
    <script src="${pageContext.request.contextPath}/Asset/js/register.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>

<div class="modal">
    <form action="${pageContext.request.contextPath}/AddUser" method="post" enctype="multipart/form-data">
        <div class="avatarFrame">
            <img id="out_img" src="https://drive.google.com/uc?export=view&id=1sAFmlSiwY_fporn9AdbnhUp3KTe5tL24" alt="">
            <input type="hidden" name="avatarIMG"
                   value="https://drive.google.com/uc?export=view&id=1sAFmlSiwY_fporn9AdbnhUp3KTe5tL24">
            <div class="chooseIMGFrame">
                <i class="fas fa-camera"></i>
                <input name="avatar" id="chooseIMG" class="chooseIMG" type="file" accept="image/*"
                       onchange="loadFile(event)">
            </div>
            <input id="permission" type="hidden" name="permission" value="0">
            <h3 id="permissionTxt">
                Người dùng
                <i style="color: #1877F2" class="fas fa-sync-alt" onclick="ChangePermission()"></i></h3>
        </div>
        <ul>
            <li>
                <input type="text" placeholder="Tên tài khoản" value="">
                <input type="text" placeholder="Mật khẩu" value="">
            </li>
            <li><label>Họ tên</label>
                <input name="name" type="text" maxlength="30" value="" placeholder="Nhập vào tên của bạn...">
                <i class="fas fa-exclamation-circle" id="icon_name"></i>
            </li>
            <li><label>Ngày sinh</label>
                <input name="age" type="date" value="2001-01-01">
            </li>
            <li><label>Giới tính</label>
                <select name="sex" id="sex">
                    <option value="Nam">Nam</option>
                    <option value="Nữ">Nữ</option>
                    <option value="Khác">Khác</option>
                </select>
            </li>
            <li><label>Số điện thoại</label>
                <input name="phone" type="number"
                       onKeyDown="if(this.value.length==11 && event.keyCode>47 && event.keyCode < 58)return false;"
                       maxlength="11"
                       placeholder="Nhập vào số điện thoại..."
                       value=""
                >
                <i class="fas fa-exclamation-circle" id="icon_phone"></i>
            </li>
            <li><label>Địa chỉ</label>
                <select id="selectTinh" onchange="selectTinhRegister()">
                    <option selected>Tỉnh/Thành Phố</option>
                    <c:forEach items="${Tinhs}" var="Tinh">
                        <option value="${Tinh.matp}">${Tinh.name}</option>
                    </c:forEach>
                </select>
            </li>
            <li>
                <label></label>
                <select id="selectHuyen" onchange="selectHuyenRegister()">
                    <option selected>Quận/Huyện</option>
                </select>
            </li>
            <li><label></label>
                <select name="address" id="selectXa">
                    <option selected>Xã/Phường</option>
                </select>
                <i class="fas fa-exclamation-circle" id="icon_address"></i>
            </li>
            <li><label>Mô tả</label></li>
            <li><textarea name="status" id="" cols="30" rows="4"></textarea>
                <i class="fas fa-exclamation-circle dacbiet" id="icon_status"></i></li>
            <li>
                <input class="btnSubmit" name="submitRegister" type="submit" value="Xác nhận đăng ký">
            </li>
        </ul>

    </form>


</div>


<script>
    function ChangePermission() {
        var permission = document.getElementById("permission");
        var permissionTxt = document.getElementById("permissionTxt");
        if (permission.value == "1") {
            permission.value = "0";
            permissionTxt.innerHTML = 'Người dùng <i style="color: #1877F2" class="fas fa-sync-alt" onclick="ChangePermission()"></i>';
        } else {
            permission.value = "1";
            permissionTxt.innerHTML = 'Quản lý <i style="color: #1877F2" class="fas fa-sync-alt" onclick="ChangePermission()"></i>';
        }
    }

    function Mess() {

        <c:forEach items="${Mess}" var="item">
        var test = ${item};
        if (test == 1) {
            var icon_name = document.getElementById("icon_name");
            icon_name.style.display = "block";
        } else if (test == 2) {
            var icon_phone = document.getElementById("icon_phone");
            icon_phone.style.display = "block";
        } else if (test == 3) {
            var icon_address = document.getElementById("icon_address");
            icon_address.style.display = "block";
        } else if (test == 4) {
            var icon_status = document.getElementById("icon_status");
            icon_status.style.display = "block";
        }
        </c:forEach>
    }

    Mess();
</script>


</body>

</html>
