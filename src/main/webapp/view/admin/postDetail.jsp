<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/30/2021
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/post.css">
</head>
<body style="background-image: url('${pageContext.request.contextPath}/Asset/img/banner-bg.jpg')">
<form action="postDetail" method="post">
    <div class="postDetail">
        <a onclick="window.history.back()" class="back"><i class="fas fa-chevron-circle-left"></i></a>
        <img class="postImg" src="${Post.getImage()}" alt="">
        <div class="post-main">
            <h1><a href="ViewUserForAdmin?userID=${Post.getUser().getID()}">${Post.getUser().getName()}</a></h1>
            <h5>${Post.getDateTime()}</h5>
            <div class="info">
                <div class="start-info">
                    <h3>Điểm Xuất Phát</h3>
                    <ul class="address">
                        <li><i class="fas fa-map-marker-alt"></i> ${Post.getStartProvince()}</li>
                        <li><i class="fas fa-map-marker-alt"></i> ${Post.getStartDistrict()}</li>
                        <li><i class="fas fa-map-marker-alt"></i> ${Post.getStartCommune()}</li>
                    </ul>
                </div>
                <div class="time-info">
                    <h3>Thời gian: </h3>
                    <p><i class="far fa-clock"></i> ${Post.getTimeStart()}</p>
                    <p><i class="far fa-calendar-alt"></i> ${Post.getDate()}</p>
                </div>
                <div class="end-info">
                    <h3>Điểm Đến</h3>
                    <ul class="address">
                        <li><i class="fas fa-map-marker"></i> ${Post.getEndProvince()}</li>
                        <li><i class="fas fa-map-marker"></i> ${Post.getEndDistrict()}</li>
                        <li><i class="fas fa-map-marker"></i> ${Post.getEndCommune()}</li>
                    </ul>
                </div>
            </div>
            <div class="status">
                <p><i class="far fa-clipboard"></i> ${Post.getCaption()}</p>
            </div>
            <div class="postButton">
                <input type="hidden" value="${Post.getID()}" name="postID">
                <input type="submit" value="Xóa bài">
            </div>
        </div>
    </div>
</form>
<div class="listRequest">
    <h1>Danh sách yêu cầu</h1>
    <c:if test="${ListRequest == []}">
        <div class="null">
            <img src="${pageContext.request.contextPath}/Asset/img/iconS/sticker34.png" alt="">
            <h2>Chưa có yêu cầu nào!</h2>
        </div>
    </c:if>

    <c:forEach items="${ListRequest}" var="request">
        <div class="request" style="margin-bottom: 1%">
            <div class="userInfo">
                <img src="${request.getSender().getAvatar()}">
                <div class="content">
                    <h2><a href="ViewUserForAdmin?userID=${request.getSender().getID()}">${request.getSender().getName()}</a></h2>
                    <h4>${request.getDatetime()}</h4>
                    <h3><span>Nội dung: </span>${request.getContent()}</h3>
                </div>
                <div class="status">
                    <c:if test="${request.getStatus() == 0}">
                        <p><i class="fas fa-clock"></i> Đang đợi phản hồi</p>
                    </c:if>
                    <c:if test="${request.getStatus() == 1}">
                        <p><i class="fas fa-check" style="color: #14b718"></i> Đã được chấp nhận</p>
                    </c:if>
                    <c:if test="${request.getStatus() == 2}">
                        <p><i class="fas fa-times" style="color: #b91414"></i> Đã bị từ chối</p>
                    </c:if>
                </div>
            </div>


        </div>
    </c:forEach>


</div>
</body>
</html>
