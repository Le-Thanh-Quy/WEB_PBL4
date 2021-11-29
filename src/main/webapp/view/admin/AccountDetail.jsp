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
    <a href="ViewUserForAdmin"><i class="fas fa-arrow-left"></i></a>
    <form action="${pageContext.request.contextPath}/ViewUserForAdmin" method="post" enctype="multipart/form-data">
        <input type="hidden" name="user_txt" value="${User.getAccountID()}">
        <input type="hidden" name="userID" value="${User.getID()}">
        <div class="avatarFrame">
            <img id="out_img" src="${User.getAvatar()}" alt="">
            <input type="hidden" name="avatarIMG" value="${User.getAvatar()}">
            <div class="chooseIMGFrame">
                <i class="fas fa-camera"></i>
                <input name="avatar" id="chooseIMG" class="chooseIMG" type="file" accept="image/*"
                       onchange="loadFile(event)">
            </div>
            <h2>${User.getAccountID()}</h2>
            <input id="permission" type="hidden" name="permission" value="${Permission}">
            <h3 id="permissionTxt">
                <c:if test="${Permission == 1}">
                    Quản lý
                </c:if>
                <c:if test="${Permission == 0}">
                    Người dùng
                </c:if>
                <i style="color: #1877F2" class="fas fa-sync-alt" onclick="ChangePermission()"></i></h3>
        </div>
        <ul>
            <li><label>Họ tên</label>
                <input name="name" type="text" maxlength="30"
                <c:if test="${name == null}">
                       value="${User.getName()}"
                </c:if>
                >
                <i class="fas fa-exclamation-circle" id="icon_name"></i>
            </li>
            <li><label>Ngày sinh</label>
                <input name="age" type="date"
                <c:if test="${age == null}">
                       value="${User.getAge()}"
                </c:if>
                >
            </li>
            <script>
                window.onload = ev => {
                    var sex = document.getElementById("sex");
                    sex.value = "${User.getSex()}";
                    var selectTinh = document.getElementById("selectTinh");
                    selectTinh.value = "${Address.get(2)}";
                    selectTinhRegister();
                    setTimeout(function () {
                        var selectHuyen = document.getElementById("selectHuyen");
                        selectHuyen.value = "${Address.get(1)}";
                        selectHuyenRegister();
                    }, 500);

                    setTimeout(function () {
                        var selectXa = document.getElementById("selectXa");
                        selectXa.value = "${Address.get(0)}";
                    }, 1000);
                }
            </script>
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
                <c:if test="${phone == null}">
                       value="${User.getPhone_Number()}"
                </c:if>
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
            <li><textarea name="status" id="" cols="30" rows="4"><c:if test="${status != null}">${status}</c:if><c:if test="${status == null}">${User.getStatus()}</c:if>
            </textarea>
                <i class="fas fa-exclamation-circle dacbiet" id="icon_status"></i></li>
            <li>
                <input class="btnSubmit" name="submitRegister" type="submit" value="Cập nhật">
                <input class="btnSubmit" name="submitRegister" type="submit" value="Xóa người dùng">
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
