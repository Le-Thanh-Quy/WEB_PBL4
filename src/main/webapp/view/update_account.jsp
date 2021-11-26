<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" icontent="width=device-width, initial-scale=1.0">
    <title>Cập nhật thông tin cá nhân</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/register.css">
    <script src="${pageContext.request.contextPath}/Asset/js/register.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>

<div class="modal">
    <form action="${pageContext.request.contextPath}/register" method="post" enctype="multipart/form-data" >
        <input type="hidden" name="user_txt_singup" value="${user_name}">
        <input type="hidden" name="pass_txt_signup" i value="${pass}">
        <div class="avatarFrame">
            <img id="out_img" src="https://drive.google.com/uc?export=view&id=1sAFmlSiwY_fporn9AdbnhUp3KTe5tL24" alt="">
            <div class="chooseIMGFrame">
                <i class="fas fa-camera"></i>
                <input name="avatar" id="chooseIMG" class="chooseIMG" type="file" accept="image/*" onchange="loadFile(event)">
            </div>
        </div>
        <ul>
            <li><label>Họ tên</label>
                <input name="name" type="text" maxlength="30" value="<% if(request.getParameter("name")!= null){
                     out.print(request.getParameter("name"));
                }%>">
                <i class="fas fa-exclamation-circle" id="icon_name"></i>
            </li>
            <li><label>Ngày sinh</label>
                <input name="age" type="date" value="<% if(request.getParameter("age")!= null){
                     out.print(request.getParameter("age"));
                }else{
                    out.print("2001-01-01");
                }%>">
            </li>
            <li><label>Giới tính</label>
                <select name="sex" >
                    <option value="Nam">Nam</option>
                    <option value="Nữ">Nữ</option>
                    <option value="Khác">Khác</option>
                </select>
            </li>
            <li><label>Số điện thoại</label>
                <input name="phone" type="number"
                       onKeyDown="if(this.value.length==11 && event.keyCode>47 && event.keyCode < 58)return false;"
                       maxlength="11"
                       value="<% if(request.getParameter("phone")!= null){
                     out.print(request.getParameter("phone"));
                }%>"
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
            <li><textarea name="status" id="" cols="30" rows="4" ><% if(request.getParameter("status")!= null){
                out.print(request.getParameter("status"));
            }%></textarea>
                <i class="fas fa-exclamation-circle dacbiet" id="icon_status"></i></li>
            <li><button id="SubmitRegister" name="submitRegister" type="submit" >Xác nhận đăng ký</button></li>
        </ul>

    </form>






</div>


<script>
    function Mess() {

        <c:forEach items="${Mess}" var="item">
        var test = ${item};
        if(test == 1){
            var icon_name = document.getElementById("icon_name");
            icon_name.style.display = "block";
        }else if(test == 2){
            var icon_phone = document.getElementById("icon_phone");
            icon_phone.style.display = "block";
        }else if(test == 3){
            var icon_address = document.getElementById("icon_address");
            icon_address.style.display = "block";
        }else if(test == 4){
            var icon_status = document.getElementById("icon_status");
            icon_status.style.display = "block";
        }
        </c:forEach>
    }
    Mess();
</script>


</body>

</html>