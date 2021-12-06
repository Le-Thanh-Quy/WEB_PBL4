<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a onclick="setTitle('<a href=\'\'>Trang chủ</a> > Quản lý người dùng > Danh sách người dùng')" href="ViewUserForAdmin" target="frame"><i class="far fa-circle" ></i> Danh sách người dùng</a>
                <a onclick="setTitle('<a href=\'\'>Trang chủ</a> > Quản lý người dùng > Thêm người dùng')" href="AddUser" target="frame"><i class="far fa-circle"></i> Thêm người dùng</a>
                <a onclick="setTitle('<a href=\'\'>Trang chủ</a> > Quản lý người dùng > Xóa người dùng')" href="DelUser" target="frame"><i class="far fa-circle"></i> Xóa người dùng</a>
            </div>

            <li onclick="OpenChoose(2)" id="header2"><i class="fas fa-edit"></i>
                <a>Quản lý bài đăng</a>
                <i class="fas fa-chevron-left icon" id="icon2" ></i>

            </li>
            <div class="info-link" id="choose2">
                <a onclick="setTitle('<a href=\'\'>Trang chủ</a> > Quản lý bài đăng > Danh sách bài đăng')" href="ViewPost" target="frame"><i class="far fa-circle"></i> Danh sách bài đăng</a>
            </div>

            <li onclick="document.getElementById('reportTag').click()"><i class="fas fa-flag"></i>
                <a id="reportTag" onclick="setTitle('<a href=\'\'>Trang chủ</a> > Xử lý báo cáo')" href="viewReport" target="frame">Xử lý báo cáo</a>
                <c:if test="${noiReport == true}">
                    <p class="new-report">!</p>
                </c:if>
            </li>
            <li onclick="document.getElementById('addressTag').click()"><i class="fas fa-map-marked-alt "></i>
                <a id="addressTag" onclick="setTitle('<a href=\'\'>Trang chủ</a> > Quản lý địa chỉ')" href="getProv" target="frame" >Quản lý địa chỉ</a>

            </li>
<%--            <li onclick="document.getElementById('notificationTag').click()"><i class="fas fa-exclamation-triangle"></i>--%>
<%--                <a id="notificationTag" onclick="setTitle('<a href=\'\'>Trang chủ</a> > Đăng thông báo')" >Đăng thông báo</a>--%>
<%--            </li>--%>
        </ul>
    </div>

</div>
<script !src="">
    function setTitle(title) {
        document.getElementById("title").innerHTML = title;
    }
</script>
<div class="main" id="main">
    <div class="task">
        <i class="fas fa-bars" onclick="HideMenu()"></i>
        <p id="title"><a href=''>Trang chủ</a></p>
        <a onclick="setTitle('<a href=\'\'>Trang chủ</a> > Liên hệ')" href="${pageContext.request.contextPath}/chat?myID=0" target="frame"><i class="far fa-comments"></i></a>
    </div>
    <iframe src="${pageContext.request.contextPath}/view/admin/imageHome.jsp" name="frame" frameborder="0">
    </iframe>
</div>
</body>

</html>
