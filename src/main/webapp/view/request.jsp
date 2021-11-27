<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/request.css">
    <script src="${pageContext.request.contextPath}/Asset/js/request.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>
<%--<div class="null">--%>
<%--    <img src="${pageContext.request.contextPath}/Asset/img/logo/cannotfound.jpg" alt="">--%>
<%--    <h4>Chưa có giao dịch</h4>--%>
<%--</div>--%>


<div class="task-Info">
    <p class="active-info" id="btnReceive" onclick="ChangePage(1)">Đã nhận</p>
    <p id="btnSend" onclick="ChangePage(2)">Đã gửi</p>
</div>

<div class="receive" id="receive">

    <div class="request">
        <img src="${pageContext.request.contextPath}/Asset/img/logo/listing-06.jpg" alt="">
        <div class="info">
            <h3 class="dacbiet1">Lê Thanh Quý</h3>
            <div class="position">
                <ul class="address">
                    <li><i class="fas fa-map-marker-alt dacbiet"></i> Tam Xuân 223123123áda</li>
                    <li><i class="fas fa-map-marker-alt dacbiet"></i> Huyện Dương Minh Châu</li>
                    <li><i class="fas fa-map-marker-alt dacbiet"></i> Thành Phố Hồ Chí Minh</li>
                </ul>
                <ul class="address">
                    <li><i class="fas fa-map-marker dacbiet"></i> Tam Xuân 223123123áda</li>
                    <li><i class="fas fa-map-marker dacbiet"></i> Huyện Dương Minh Châu</li>
                    <li><i class="fas fa-map-marker dacbiet"></i> Thành Phố Hồ Chí Minh</li>
                </ul>
            </div>

            <ul class="address">
                <li> <i class="far fa-calendar-alt dacbiet"></i>  12/01/2001 12:00 - 13:00</li>
            </ul>
            <h3>Nội dung yêu cầu:</h3>
            <h4 class="dacbiet1">Trần Nguyễn Anh Trình <span>12/12/2001 lúc 12:00</span></h4>
            <ul class="content">
                <li> <i class="far fa-clipboard dacbiet"></i>  Gửi bao gạo</li>
            </ul>
        </div>

        <div class="submit">
            <i class="far fa-comment-alt"></i>
            <i class="fas fa-check"></i>
            <i class="fas fa-times"></i>
        </div>

    </div>

</div>

<div class="receive" id="send">

    <div class="request">
        <img src="${pageContext.request.contextPath}/Asset/img/logo/listing-06.jpg" alt="">
        <div class="info">
            <h3 class="dacbiet1">Lê Thanh Quý</h3>
            <div class="position">
                <ul class="address">
                    <li><i class="fas fa-map-marker-alt dacbiet"></i> Tam Xuân 223123123áda</li>
                    <li><i class="fas fa-map-marker-alt dacbiet"></i> Huyện Dương Minh Châu</li>
                    <li><i class="fas fa-map-marker-alt dacbiet"></i> Thành Phố Hồ Chí Minh</li>
                </ul>
                <ul class="address">
                    <li><i class="fas fa-map-marker dacbiet"></i> Tam Xuân 223123123áda</li>
                    <li><i class="fas fa-map-marker dacbiet"></i> Huyện Dương Minh Châu</li>
                    <li><i class="fas fa-map-marker dacbiet"></i> Thành Phố Hồ Chí Minh</li>
                </ul>
            </div>

            <ul class="address">
                <li> <i class="far fa-calendar-alt dacbiet"></i>  12/01/2001 12:00 - 13:00</li>
            </ul>
            <h3>Nội dung yêu cầu:</h3>
            <h4 class="dacbiet1">Trần Nguyễn Anh Trình <span>12/12/2001 lúc 12:00</span></h4>
            <ul class="content">
                <li> <i class="far fa-clipboard dacbiet"></i>  Gửi bao gạo</li>
            </ul>
        </div>

        <div class="submitSend">
            <i class="far fa-comment-alt"></i>
        </div>
        <div class="status">
            <i class="fas fa-check statusIcon"></i>Chấp nhận
        </div>

    </div>

</div>







</body>
</html>
