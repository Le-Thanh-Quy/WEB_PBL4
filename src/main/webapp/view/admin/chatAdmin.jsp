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

<div class="main_frame_1">
    <div class="chat_list">
        <div class="chat_list_title">
            <h1>Tin nhắn gần đây</h1>
            <i style="opacity: 0" class="fas fa-sync-alt" onclick="ReloadChatRoom('${myID}')" id="reloadRoom"></i>
        </div>
        <div class="search">
            <input id="searchRoomChat" type="text" placeholder="Tìm kiếm tin nhắn" value=""
                   onkeyup="SearchRoomChat()">
            <i class="fas fa-search"></i>
        </div>
        <div class="recent_messages" id="recent_messages">

            <c:forEach items="${ListChatRoom}" var="ChatRoom">
                <a href="${pageContext.request.contextPath}/chatDetail?RoomID=${ChatRoom.getID()}&myID=0" target="chat_detail">
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

            </c:forEach>
        </div>
    </div>
    <div class="autoReload" style="opacity: 0">
        <input id="autoReload" type="checkbox" checked>
        <p>Tự động cập nhật</p>
    </div>
    <div class="chat_detal">
        <iframe name="chat_detail"></iframe>
    </div>
</div>
<script !src="">
    myID = 0;
</script>
</body>
</html>
