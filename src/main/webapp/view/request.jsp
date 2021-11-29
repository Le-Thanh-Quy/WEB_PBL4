<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/request.css">
    <script src="${pageContext.request.contextPath}/Asset/js/request.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

</head>
<body>


<div class="task-Info">
    <p class="active-info" id="btnReceive" onclick="ChangePage(1)">Đã nhận</p>
    <p id="btnSend" onclick="ChangePage(2)">Đã gửi</p>
</div>


<div class="receive" id="receive">

    <c:if test="${listRequestReceive == []}">
        <div class="null">
            <img src="${pageContext.request.contextPath}/Asset/img/logo/cannotfound.jpg" alt="">
            <h3>Chưa có yêu cầu nào!</h3>
        </div>
    </c:if>
    <c:forEach items="${listRequestReceive}" var="RequestReceive">
        <div class="request">
            <img src="${RequestReceive.getPost().getImage()}" alt="">
            <div class="info">
                <h3 class="dacbiet1">${RequestReceive.getPost().getUser().getName()}</h3>
                <div class="position">
                    <ul class="address">
                        <li><i class="fas fa-map-marker-alt dacbiet"></i> ${RequestReceive.getPost().getStartCommune()}
                        </li>
                        <li><i class="fas fa-map-marker-alt dacbiet"></i> ${RequestReceive.getPost().getStartDistrict()}
                        </li>
                        <li><i class="fas fa-map-marker-alt dacbiet"></i> ${RequestReceive.getPost().getStartProvince()}
                        </li>
                    </ul>
                    <i class="fas fa-truck-moving"></i>
                    <ul class="address">
                        <li><i class="fas fa-map-marker dacbiet"></i> ${RequestReceive.getPost().getEndCommune()}</li>
                        <li><i class="fas fa-map-marker dacbiet"></i> ${RequestReceive.getPost().getEndDistrict()}</li>
                        <li><i class="fas fa-map-marker dacbiet"></i> ${RequestReceive.getPost().getEndProvince()}</li>
                    </ul>
                </div>


                <ul class="address">
                    <li><i class="far fa-calendar-alt dacbiet"></i> ${RequestReceive.getPost().getDate()} khởi hành
                        lúc ${RequestReceive.getPost().getTimeStart()}</li>
                </ul>
                <h3>Nội dung yêu cầu:</h3>
                <h4 class="dacbiet1"><a
                        href="account?others_user_name=${RequestReceive.getSender().getAccountID()}"
                        style="text-decoration: none" target="_top">${RequestReceive.getSender().getName()}</a>
                    <span>${RequestReceive.getDatetime()}</span></h4>
                <ul class="content">
                    <li><i class="far fa-clipboard dacbiet"></i> ${RequestReceive.getContent()}</li>
                </ul>
            </div>

            <div class="submit">

                <c:if test="${RequestReceive.getStatus() == 0}">
                    <a href="request?userID=${RequestReceive.getReceiverID()}&Status=true&requestID=${RequestReceive.getID()}" class="fas fa-check"></a>
                    <a href="request?userID=${RequestReceive.getReceiverID()}&Status=false&requestID=${RequestReceive.getID()}" class="fas fa-times"></a>
                </c:if>
                <a target="_top"
                   href="chat?myID=${RequestReceive.getReceiverID()}&theirID=${RequestReceive.getSenderID()}"
                   class="far fa-comment-alt"> </a>

            </div>
            <div class="status">
                <c:if test="${RequestReceive.getStatus() == 0}">
                    <p><i class="fas fa-clock statusIcon"></i> Đang đợi phản hồi</p>
                </c:if>
                <c:if test="${RequestReceive.getStatus() == 1}">
                    <p><i class="fas fa-check statusIcon"></i> Bạn đã chấp nhận</p>
                </c:if>
                <c:if test="${RequestReceive.getStatus() == 2}">
                    <p><i class="fas fa-times statusIcon"></i> Bạn đã từ chối</p>
                </c:if>
            </div>

        </div>
    </c:forEach>
</div>

<div class="receive" id="send">

    <c:if test="${listRequestSend == []}">
        <div class="null">
            <img src="${pageContext.request.contextPath}/Asset/img/logo/cannotfound.jpg" alt="">
            <h3>Chưa có yêu cầu nào!</h3>
        </div>
    </c:if>
    <c:forEach items="${listRequestSend}" var="RequestSend">
        <div class="request">
            <img src="${RequestSend.getPost().getImage()}" alt="">
            <div class="info">
                <h3 class="dacbiet1"><a
                        href="account?others_user_name=${RequestSend.getPost().getUser().getAccountID()}"
                        style="text-decoration: none" target="_top">${RequestSend.getPost().getUser().getName()}</a>
                </h3>
                <div class="position">
                    <ul class="address">
                        <li><i class="fas fa-map-marker-alt dacbiet"></i> ${RequestSend.getPost().getStartCommune()}
                        </li>
                        <li><i class="fas fa-map-marker-alt dacbiet"></i> ${RequestSend.getPost().getStartDistrict()}
                        </li>
                        <li><i class="fas fa-map-marker-alt dacbiet"></i> ${RequestSend.getPost().getStartProvince()}
                        </li>
                    </ul>
                    <i class="fas fa-truck-moving"></i>
                    <ul class="address">
                        <li><i class="fas fa-map-marker dacbiet"></i> ${RequestSend.getPost().getEndCommune()}</li>
                        <li><i class="fas fa-map-marker dacbiet"></i> ${RequestSend.getPost().getEndDistrict()}</li>
                        <li><i class="fas fa-map-marker dacbiet"></i> ${RequestSend.getPost().getEndProvince()}</li>
                    </ul>
                </div>

                <ul class="address">
                    <li><i class="far fa-calendar-alt dacbiet"></i> ${RequestSend.getPost().getDate()} khởi hành
                        lúc ${RequestSend.getPost().getTimeStart()}</li>
                </ul>
                <h3>Nội dung yêu cầu:</h3>
                <h4 class="dacbiet1">${RequestSend.getSender().getName()} <span>${RequestSend.getDatetime()}</span></h4>
                <ul class="content">
                    <li><i class="far fa-clipboard dacbiet"></i> ${RequestSend.getContent()}</li>
                </ul>
            </div>

            <div class="submit">
                <a target="_top" href="chat?myID=${RequestSend.getSenderID()}&theirID=${RequestSend.getReceiverID()}"
                   class="far fa-comment-alt"></a>
            </div>
            <div class="status">
                <c:if test="${RequestSend.getStatus() == 0}">
                    <p><i class="fas fa-clock statusIcon"></i> Đang đợi phản hồi</p>
                </c:if>
                <c:if test="${RequestSend.getStatus() == 1}">
                    <p><i class="fas fa-check statusIcon"></i> Đã được chấp nhận</p>
                </c:if>
                <c:if test="${RequestSend.getStatus() == 2}">
                    <p><i class="fas fa-times statusIcon"></i> Đã bị từ chối</p>
                </c:if>

            </div>

        </div>
    </c:forEach>
</div>


</body>
</html>
