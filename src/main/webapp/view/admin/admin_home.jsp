<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/admin.css">
    <script src="${pageContext.request.contextPath}/Asset/js/admin.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>
<div class="menu" id="menu">
    <div class="logo">
        <img src="${pageContext.request.contextPath}/Asset/img/white-logo.png" alt="">
    </div>
    <div class="info">
        <div class="info-img">
            <img src="${user_info.getAvatar()}" alt="">
            <p>${user_name}</p>
            <i class="fas fa-chevron-left" id="icon0" onclick="OpenChoose(0)"></i>
        </div>
        <div class="info-link" id="choose0">
            <a href="admin_home?logout=true"><i class="far fa-circle"></i> Đăng xuất</a>
        </div>

    </div>
    <div class="manager">
        <ul>
            <li onclick="OpenChoose(1)" id="header1"><i class="fas fa-user-edit"></i>
                <a>Quản lý người dùng</a>
                <i class="fas fa-chevron-left icon" id="icon1" ></i>
            </li>
            <div class="info-link" id="choose1">
                <a href="ViewUserForAdmin" target="frame"><i class="far fa-circle"></i> Danh sách người dùng</a>
                <a href="AddUser" target="frame"><i class="far fa-circle"></i> Thêm người dùng</a>
                <a href="DelUser" target="frame"><i class="far fa-circle"></i> Xóa người dùng</a>
            </div>

            <li onclick="OpenChoose(2)" id="header2"><i class="fas fa-edit"></i>
                <a>Quản lý bài đăng</a>
                <i class="fas fa-chevron-left icon" id="icon2" ></i>

            </li>
            <div class="info-link" id="choose2">
                <a href="ViewPost" target="frame"><i class="far fa-circle"></i> Danh sách bài đăng</a>
            </div>

            <li><i class="fas fa-flag"></i>
                <a href="viewReport" target="frame">Xử lý báo cáo</a>
                <p class="new-report">1</p>

            </li>
            <li id="header3"><i class="fas fa-map-marked-alt "></i>
                <a href="getProv" target="frame" >Quản lý địa chỉ</a>

            </li>
            <li><i class="fas fa-exclamation-triangle"></i>
                <a >Đăng thông báo</a>
            </li>
        </ul>
    </div>

</div>
<div class="main" id="main">
    <div class="task">
        <i class="fas fa-bars" onclick="HideMenu()"></i>
        <p>Home</p>
        <i class="far fa-comments"></i>
    </div>
    <iframe src="" name="frame" frameborder="0">
        <p>asdasd</p>
    </iframe>
</div>
</body>

</html>
