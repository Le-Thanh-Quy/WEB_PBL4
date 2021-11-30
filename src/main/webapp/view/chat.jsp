<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chat</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/chat.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <script src="${pageContext.request.contextPath}/Asset/js/chat.js"></script>
</head>
<body>
<%
    if(session.getAttribute("logged") == null){
        session.setAttribute("Mess", "Bạn đã đăng xuất khỏi tài khoản!");
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
        return;
    }
%>
<div class="chat_title">
    <div class="logo">
        <a href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/Asset/img/white-logo.png" alt=""></a>
    </div>
    <div class="title">
        <h1>Liên Hệ</h1>
    </div>


</div>
<div class="main_frame">
    <div class="chat_list">
        <div class="chat_list_title">
            <h1>Tin nhắn gần đây</h1>
            <i style="opacity: 0" class="fas fa-sync-alt" onclick="ReloadChatRoom('${myID}')" id="reloadRoom"></i>
        </div>
        <div class="search">
            <input id="searchRoomChat" type="text" placeholder="Tìm kiếm tin nhắn" value="" onkeydown="SearchRoomChat()">
            <i class="fas fa-search" ></i>
        </div>
        <div class="recent_messages" id="recent_messages">
            <a href="chat?myID=${myID}">
                <div class="messages">
                    <img src="${pageContext.request.contextPath}/Asset/img/logo/logo_user.png" alt="">
                    <div class="content">
                        <pre> Admin QTH</pre>
                        <p></p>
                    </div>
                </div>
            </a>

            <c:forEach items="${ListChatRoom}" var="ChatRoom">
                <c:if test="${ChatRoom.getTheirUser().getID() != 0}">
                    <a href="chatDetail?RoomID=${ChatRoom.getID()}&myID=${ChatRoom.getMyUser().getID()}" target="chat_detail">
                        <div class="messages">
                            <img src="${ChatRoom.getTheirUser().getAvatar()}" alt="">
                            <div class="content">
                                <pre>${ChatRoom.getTheirUser().getName()}</pre>
                                <p><i class="fas fa-sms"
                                        <c:if test="${ChatRoom.isMyStatus() == false}">
                                            style="display: block!important;"
                                        </c:if>
                                ></i></p>
                            </div>
                        </div>
                    </a>
                </c:if>
            </c:forEach>
        </div>
        <div class="autoReload" style="opacity: 0">
            <input id="autoReload" type="checkbox" checked>
            <p>Tự động cập nhật</p>
        </div>

    </div>
    <div class="chat_detal">
        <iframe name="chat_detail"
                <c:if test="${RoomID != null}">
                    src="chatDetail?RoomID=${RoomID}&myID=${myID}"
                </c:if>
                <c:if test="${RoomID == null}">
                    src="chatDetail?RoomID=Admin&myID=${myID}"
                </c:if>
        ></iframe>
    </div>
</div>
<script !src="">
    myID = ${myID};
</script>
</body>
</html>
