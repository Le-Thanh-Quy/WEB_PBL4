<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/report.css">
</head>
<body>
<div class="header">
    <h2>Báo cáo</h2>
</div>
<h3>Hãy mô tả chi tiết hành vi vi phạm để chúng tôi xem xét xử lý!</h3>
<h3>Bạn chắc chắn muốn báo cáo: <span><a style="text-decoration: none; color: #1877F2"  href="account?others_user_name=${theirUser.getAccountID()}" target="_top">${theirUser.getName()}</a></span></h3>
<form action="${pageContext.request.contextPath}/report" method="post">
    <textarea name="content" id="" cols="52" rows="6" placeholder="Nội dung..." ></textarea>
    <input type="hidden" name="myID" value="${myID}">
    <input type="hidden" name="theirID" value="${theirUser.getID()}">
    <input type="submit" value="Báo cáo">
</form>
</body>
</html>
