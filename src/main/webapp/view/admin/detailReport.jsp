<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/report.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <script>
        function goBack() {
            window.history.back();
        }
    </script>

</head>
<body style="background-image: url(${pageContext.request.contextPath}/Asset/img/banner-bg.jpg); background-size: cover;">
<div class="main_frame">
    <a href="viewReport"><i class="far fa-arrow-alt-circle-left" ></i></a>

    <form method="post" action="updateReport">

        <div class="title">
            <div class="left">
                <img src="${report.getUserReport().getAvatar()}" alt="">
                <h2><a href="ViewUserForAdmin?userID=${report.getUserReport().getID()}">${report.getUserReport().getName()}</a></h2>
            </div>
            <i class="fas fa-arrow-right"></i>
            <div class="right">
                <img src="${report.getUserViolate().getAvatar()}" alt="">
                <h2><a href="ViewUserForAdmin?userID=${report.getUserViolate().getID()}">${report.getUserViolate().getName()}</a></h2>
            </div>
        </div>

        <input type="hidden" name="ID" value="${report.getID()}">

        <div class="reportDetail">
            <div class="left">
                <h2>Thời gian: ${report.getTime()}</h2>
                <h2>Nội dung: </h2>
                <p>${report.getContent()}</p>
                <h2 >Tình trạng:
                    <c:if test="${report.isStatus()}">
                        <span> <i class="fas fa-check" style="color: #2bbb1b"></i> Đã xử lý</span>

                    </c:if>
                    <c:if test="${!report.isStatus()}">
                        <span><i class="fas fa-times" style="color: #c91919"></i> Chưa xử lý</span>
                    </c:if>
                </h2>
                <h2>Chi tiết bài đăng: <a href="postDetail?postID=${report.getPostID()}">Tại đây</a></h2>
            </div>

            <div class="right">
                <h2>Phản hồi</h2>
                <textarea placeholder="Aaa..." name="feedback" cols="" rows="10">${report.getFeedback()}</textarea>
            </div>
        </div>

        <input class="submitBtn" type="submit" value="Gửi phản hồi">
        <input style="position: relative; float: none; opacity: 0; cursor: default;" type="text" value="Gửi phản hồi">
    </form>
</div>

</body>
</html>
