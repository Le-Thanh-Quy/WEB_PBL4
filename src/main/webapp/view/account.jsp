<%@ page import="Model.BEAN.User" %>
<%@ page import="Model.BEAN.Assess" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tài khoản</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/post.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/account.css">

    <script src="${pageContext.request.contextPath}/Asset/js/account.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>

<header id="menu">
    <div class="nav" id="nav">
        <img id="logo" src="${pageContext.request.contextPath}/Asset/img/white-logo.png" alt="">
        <ul>

            <li><a class="tab" id="active" href="index.jsp">Trang Chủ</a></li>
            <li><a class="tab" href="">Liên Hệ</a></li>
            <li><a class="tab avatar_menu" href="" onmouseover="MenuOn()" onmouseleave="MenuOff()"><img
                    class="avatar" src="${user.getAvatar()}" alt=""> ${user.getAccountID()}</a></li>
        </ul>
    </div>
    <div class="menu_logout" id="menu_logout" onmouseover="MenuOn()" onmouseleave="MenuOff()">
        <div class="menu_model">
        </div>
        <div class="menu_info">
            <ul>
                <li>Cập nhật thông tin</li>
                <a href="${pageContext.request.contextPath}/logout"><li>Đăng Xuất</li></a>
            </ul>
        </div>
    </div>

</header>

<div id="viewAvatar" class="modal-avatar">
    <div class="modal-content">
        <div class="modal-body">
            <img src="${pageContext.request.contextPath}/Asset/img/logo/lethanhquy.jpg" alt="">
        </div>
    </div>
</div>
<div class="frameInfo">
    <div class="frameInfo-1">
        <div class="Info-Avatar">
            <img onclick="viewAvatar()" src="${user.getAvatar()}" alt="">
        </div>
    </div>
    <div class="frameInfo-2">
        <h1>${user.getName()}</h1>
        <h3>${user.getStatus()}</h3>
        <div class="task-Info">
            <p class="active-info" id="post-info" onclick="ChangePage1()">Bài Viết</p>
            <p id="detal-info" onclick="ChangePage2()">Giới Thiệu</p>
        </div>
    </div>
</div>
<div class="framePost" id="framePostInfo">
    <div class="title">
        <h1></h1>
    </div>
    <div class="list-post" id="list-post">
        <div class="post">
            <img class="post-img" src="${pageContext.request.contextPath}/Asset/img/logo/listing-01.jpg" alt="">

            <div class="post-main">
                <h1>Lê Thanh Quý</h1>
                <h5>12:00</h5>

                <ul class="rate">
                    <%
                        int rate = ((Assess)request.getAttribute("assess")).getRate();
                        for (int i = 0 ; i < rate ; i++){
                            out.write("<li><i class='fas fa-star'></i></li>");

                        }
                        for (int i = rate ; i < 5 ; i++){
                            out.write("<li><i class='far fa-star'></i></li>");
                        }

                    %>

                    <li>(${assess.getReview()}) Lượt đánh giá</li>
                </ul>

                <div class="info">
                    <div class="start-info">
                        <h3>Điểm Xuất Phát</h3>
                        <ul class="address">
                            <li><i class="fas fa-map-marker-alt"></i> Tam Xuân 2</li>
                            <li><i class="fas fa-map-marker-alt"></i> Núi Thành</li>
                            <li><i class="fas fa-map-marker-alt"></i> Quảng Nam</li>
                        </ul>
                    </div>
                    <div class="time-info">
                        <h3>Thời gian: </h3>
                        <p><i class="far fa-clock"></i> 13:00 - 15:00</p>
                        <p><i class="far fa-calendar-alt"></i> 30/10/2021</p>
                    </div>
                    <div class="end-info">
                        <h3>Điểm Đến</h3>
                        <ul class="address">
                            <li><i class="fas fa-map-marker"></i> Hòa Khánh Bắc</li>
                            <li><i class="fas fa-map-marker"></i> Liên Chiểu</li>
                            <li><i class="fas fa-map-marker"></i> Đà Nẵng</li>
                        </ul>
                    </div>


                </div>
                <div class="status">
                    <p><i class="far fa-clipboard"></i> Bao uy tín</p>
                </div>
                <div class="post-button">
                    <a href=""><i class="far fa-thumbs-up"></i> Thích </a>
                    <a href=""><i class="far fa-comment-alt"></i> Bình Luận </a>
                    <a href=""><i class="fas fa-exclamation-triangle"></i> Báo Cáo</a>
                </div>
            </div>
        </div>

    </div>
</div>
<div class="frameDetalInfo" id="frameDetalInfo">
    <div class="detal-info">
        <ul class="rate rate-info">
            <p><i class="fas fa-edit iconDetalInfo"></i> Đánh giá:</p>
            <%
                for (int i = 0 ; i < rate ; i++){
                    out.write("<li><i class='fas fa-star'></i></li>");

                }
                for (int i = rate ; i < 5 ; i++){
                    out.write("<li><i class='far fa-star'></i></li>");
                }

            %>
            <li>(${assess.getReview()}) Reviews</li>
        </ul>

        <p><i class="fas fa-map-marker-alt iconDetalInfo"></i> Địa chỉ: ${address}</p>
        <p><i class="fas fa-calendar-alt iconDetalInfo"></i> Ngày sinh: ${user.getAge()}</p>
        <p><i class="fas fa-venus-mars iconDetalInfo"></i> Giới tính: ${user.getSex()}</p>
        <p><i class="fas fa-phone iconDetalInfo"></i> Di động: ${user.getPhone_Number()}</p>
    </div>


</div>





</body>

</html>