<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Model.BEAN.ChatRoom" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/chat_detail.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>
<div class="header">
    <c:if test="${admin == false}">
        <img src="${chatRoom.getTheirUser().getAvatar()}" alt="">
        <div class="header-info">
            <p>${chatRoom.getTheirUser().getName()}</p>
            <pre>${chatRoom.getTheirUser().getStatus()}</pre>
        </div>
    </c:if>
    <c:if test="${admin == true}">
        <img src="${pageContext.request.contextPath}/Asset/img/logo/logo_user.png" alt="">
        <div class="header-info">
            <p>Admin QTH</p>
            <pre>Welcome to QTH</pre>
        </div>
    </c:if>

</div>
<div class="header-fake">

</div>

<div class="main_frame" id="main_frame">
    <div class="main" id="main">
        <div class="list_mess" id="list_mess">

            <c:if test="${admin == true}">
                <div class="their_mess">
                    <img src="${pageContext.request.contextPath}/Asset/img/logo/logo_user.png">
                    <div class="mess_detail">
                        <p>Chúng tôi có thể giúp gì cho bạn?</p>
                        <div class="their_time">
                            <p></p>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${listMess != null}">
                <c:forEach items="${listMess}" var="Mess">
                    <c:if test="${Mess.getUserID() != chatRoom.getMyUser().getID()}">
                        <div class="their_mess">
                            <img src="${chatRoom.getTheirUser().getAvatar()}">
                            <div class="mess_detail" onmouseover="ShowTime(${Mess.getID()})"
                                 onmouseleave="OffTime(${Mess.getID()})">
                                <p>${Mess.getMessenger()}</p>
                                <div class="their_time" id="${Mess.getID()}">
                                    <p>${Mess.getTime()}</p>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${Mess.getUserID() == chatRoom.getMyUser().getID()}">
                        <div class="my_mess">
                            <div class="fake_mess">
                                <p>${Mess.getMessenger()}</p>
                            </div>
                            <div class="mess_detail" onmouseover="ShowTime(${Mess.getID()})"
                                 onmouseleave="OffTime(${Mess.getID()})">
                                <p>${Mess.getMessenger()}</p>
                                <div class="my_time" id="${Mess.getID()}">
                                    <p>${Mess.getTime()}</p>
                                </div>
                            </div>
                        </div>

                    </c:if>

                </c:forEach>
            </c:if>
        </div>
    </div>
</div>


<c:if test="${chatRoom == null}">
    <div class="chat-input">
        <div class="input">
            <i class="far fa-images"></i>
            <i class="fas fa-sticky-note"></i>
            <input name="textMessage" id="textMessageFake" onkeyup="if(event.keyCode===13){ChatAdmin()}" type="text"
                   placeholder="Aa">
            <i class="fas fa-location-arrow" onclick="ChatAdmin()"></i>
        </div>
    </div>
</c:if>
<c:if test="${chatRoom != null}">
    <div class="chat-input">
        <div class="input">
            <i class="far fa-images"></i>
            <i class="fas fa-sticky-note"></i>
            <input name="textMessage" id="textMessage" type="text" placeholder="Aa">
            <i class="fas fa-location-arrow" onclick="sendMessage()"></i>
        </div>
    </div>
</c:if>


<div>

</div>
<script type="text/javascript">
    function ChatAdmin() {
        var textMessage = document.getElementById("textMessageFake");
        websocket.send(textMessage.value + "!!##@@admin!!##@@${myID}");
        textMessage.value = "";
        setTimeout(function () {
            window.location.href = "chatDetail?RoomID=Admin&myID=${myID}";
        }, 2000)
    }

    var websocket = new WebSocket('ws://' + window.location.hostname + '/Chatroom');
    websocket.onopen = function (message) {
        processOpen(message);
    };
    websocket.onmessage = function (message) {
        processMessage(message);
    };
    websocket.onclose = function (message) {
        processClose(message);
    };

    function processOpen(message) {
    }

    function processClose(message) {
    }

    function processMessage(message) {
        const words = message.data.split('!!##@@');
        var list_mess = document.getElementById("list_mess");
        var main = document.getElementById("main");
        let id = -1;
        <c:if test="${listMess != null}">
        id = ${chatRoom.getMyUser().getID()};
        </c:if>

        if (words[1] != id) {
            list_mess.innerHTML += ' <div class="their_mess"> ' +
                '<img src="${chatRoom.getTheirUser().getAvatar()}">' +
                '<div class="mess_detail" onmouseover="ShowTime(' + words[3] + ')" onmouseleave="OffTime(' + words[3] + ')"> <p>' + words[0] + '</p>' +
                '<div class="their_time" id="' + words[3] + '">' +
                '<p>' + words[2] + '</p>' +
                '</div>' +
                '</div></div>';
            main.setAttribute("style", "height:" + list_mess.getBoundingClientRect().height);

        } else {
            list_mess.innerHTML += '<div class="my_mess">' +
                '<div class="fake_mess">' +
                '<p>' + words[0] + '</p>' +
                '</div>' +
                '<div class="mess_detail" onmouseover="ShowTime(' + words[3] + ')" onmouseleave="OffTime(' + words[3] + ')">' +
                '<p>' + words[0] + '</p>' +
                '<div class="my_time" id="' + words[3] + '">' +
                '<p>' + words[2] + '</p>' +
                '</div>' +
                ' </div></div>';
            main.setAttribute("style", "height:" + list_mess.getBoundingClientRect().height);
            document.getElementById("main_frame").scrollTo(0, document.getElementById("main_frame").scrollHeight);
        }

    }

    function sendMessage() {
        var textMessage = document.getElementById("textMessage");
        if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
            if (textMessage.value.trim() != "") {
                websocket.send(textMessage.value + "!!##@@${chatRoom.getID()}!!##@@${chatRoom.getMyUser().getID()}");
                textMessage.value = "";
            }

        }
    }

    <c:if test="${listMess != null}">
    var textMessage = document.getElementById("textMessage");

    textMessage.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            sendMessage();
        }
    });

    window.onload = ev => {
        if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
            websocket.send("1!2!@@12@@!!##@@${chatRoom.getID()}!!##@@1");
        }
        var list_mess = document.getElementById("list_mess");
        var main = document.getElementById("main");
        main.setAttribute("style", "height:" + list_mess.getBoundingClientRect().height);
        document.getElementById("main_frame").scrollTo(0, document.getElementById("main_frame").scrollHeight);
    }
    </c:if>


    function ShowTime(id) {
        var box = document.getElementById(id);
        box.style.display = "block";
    }

    function OffTime(id) {
        var box = document.getElementById(id);
        box.style.display = "none";
    }
</script>

</body>

</html>
