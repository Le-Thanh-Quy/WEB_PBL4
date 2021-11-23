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

<body onclick="checkLogOut = true;">

<%
    if (session.getAttribute("logged") == null) {
        session.setAttribute("Mess", "Bạn đã đăng xuất khỏi tài khoản!");
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
        return;
    }
%>

<header id="menu">
    <div class="nav" id="nav">
        <img id="logo" src="${pageContext.request.contextPath}/Asset/img/white-logo.png" alt="">
        <ul>

            <li><a class="tab" id="active" href="index.jsp">Trang Chủ</a></li>
            <li><a class="tab" href="">Liên Hệ</a></li>
            <li><a class="tab avatar_menu" href="${pageContext.request.contextPath}/account?others_user_name=null"
                   onmouseover="MenuOn()" onmouseleave="MenuOff()"><img
                    class="avatar" src="${myAccount.getAvatar()}" alt=""> ${myAccount.getAccountID()}</a></li>
        </ul>
    </div>
    <div class="menu_logout" id="menu_logout" onmouseover="MenuOn()" onmouseleave="MenuOff()">
        <div class="menu_model">
        </div>
        <div class="menu_info">
            <ul>
                <li>Cập nhật thông tin</li>
                <a href="${pageContext.request.contextPath}/logout" onclick="LogOut()">
                    <li>Đăng Xuất</li>
                </a>
            </ul>
        </div>
    </div>

</header>

<div id="viewAvatar" class="modal-avatar">
    <div class="modal-content">
        <div class="modal-body">
            <img src="${user.getAvatar()}" alt="">
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
            <p class="active-info" id="post-info" onclick="ChangePage(1)">Bài Viết</p>
            <p id="detal-info" onclick="ChangePage(2)">Giới Thiệu</p>
            <c:if test="${rankAssess != null}">
                <p id="especially-info" onclick="ChangePage(3)">Đánh Giá</p>
            </c:if>
            <c:if test="${rankAssess == null}">
                <p id="especially-info" onclick="ChangePage(3)">Báo Cáo</p>
            </c:if>
        </div>
    </div>
</div>

<c:if test="${rankAssess != null}">
    <div class="frameEspeciallyInfo" id="frameEspeciallyInfo">
        <div class="rate-choose">
            <i class='far fa-star choose' id="choose1" onclick="ChooseStar(1)"></i>
            <i class='far fa-star choose' id="choose2" onclick="ChooseStar(2)"></i>
            <i class='far fa-star choose' id="choose3" onclick="ChooseStar(3)"></i>
            <i class='far fa-star choose' id="choose4" onclick="ChooseStar(4)"></i>
            <i class='far fa-star choose' id="choose5" onclick="ChooseStar(5)"></i>
        </div>
        <button onclick="SubmitAssess(${myAccount.getID()} , ${user.getID()})">Đánh giá</button>
    </div>
    <script>
        function GetAssess() {
            var choose = document.getElementById("choose" + ${rankAssess});
            choose.onclick();
        }

        GetAssess();

    </script>
</c:if>
<div class="frameEspeciallyInfos" id="frameEspeciallyInfo">

</div>

<div class="framePost" id="framePostInfo">
    <div class="title">
        <h1></h1>
    </div>
    <div class="list-post" id="list-post">
        <c:if test="${ListPost != []}">
            <c:forEach items="${ListPost}" var="Post">
                <div class="post">
                    <img class="post-img" src="${Post.getImage()}" alt="">

                    <div class="post-main">
                        <h1>${Post.getUser().getName()}</h1>
                        <h5>${Post.getDateTime()}</h5>

                        <ul class="rate">

                            <c:forEach begin="1" end="${Post.getUser().getAssess().getRate()}" varStatus="loop">
                                <li><i class='fas fa-star'></i></li>
                            </c:forEach>
                            <c:forEach begin="${Post.getUser().getAssess().getRate()}" end="4" varStatus="loop">
                                <li><i class='far fa-star'></i></li>
                            </c:forEach>
                            <li>(${Post.getUser().getAssess().getReview()}) Lượt đánh giá</li>
                        </ul>

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
                        <div class="post-button">
                            <a
                                    <c:if test="${myAccount.getID() != Post.getUser().getID()}">
                                        href="chat?myID=${myAccount.getID()}&theirID=${Post.getUser().getID()}"
                                    </c:if>
                            ><i class="far fa-comment"></i> Liên Hệ </a>
                            <a href=""><i class="far fa-comment-alt"></i> Bình Luận </a>
                            <a href=""><i class="fas fa-exclamation-triangle"></i> Báo Cáo</a>
                        </div>
                    </div>
                </div>

            </c:forEach>
            <script>
                let UserID = ${user.getID()};
                ID = ${ListPost.get(ListPost.size() - 1).getID()};
            </script>
        </c:if>
    </div>
</div>
<div class="frameDetalInfo" id="frameDetalInfo">
    <div class="detal-info">
        <ul class="rate rate-info">
            <p><i class="fas fa-edit iconDetalInfo"></i> Đánh giá:</p>
            <%
                int rate = (int) ((Assess) request.getAttribute("assess")).getRate();
                for (int i = 0; i < rate; i++) {
                    out.write("<li><i class='fas fa-star'></i></li>");

                }
                for (int i = rate; i < 5; i++) {
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


<div class="formLoader" id="loadPost">
    <ul class="formLoading">
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>

<div class="end_body">

</div>
</body>

</html>