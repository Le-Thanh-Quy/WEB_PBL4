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
    <h1><i class="far fa-comment-alt"></i> Bình luận</h1>
</div>
<div class="header-fake">

</div>

<div class="main_frame" id="main_frame">
    <div class="main" id="main">
        <div class="list_mess" id="list_mess">

            <c:forEach items="${listComment}" var="Comment">
                <c:if test="${Comment.getUserID() != myID}">
                    <div class="their_mess">
                        <img src="${Comment.getUser().getAvatar()}">
                        <div class="mess_detail" onmouseover="ShowTime(${Comment.getID()})"
                             onmouseleave="OffTime(${Comment.getID()})">
                            <h3>${Comment.getUser().getName()}</h3>
                            <p>${Comment.getContent()}</p>
                            <div class="their_time" id="${Comment.getID()}">
                                <p>${Comment.getTime()}</p>
                            </div>
                        </div>
                    </div>
                </c:if>
                <c:if test="${Comment.getUserID() == myID}">
                    <div class="my_mess">
                        <div class="fake_mess">
                            <p>${Comment.getContent()}</p>
                        </div>
                        <div class="mess_detail" onmouseover="ShowTime(${Comment.getID()})"
                             onmouseleave="OffTime(${Comment.getID()})">
                            <p>${Comment.getContent()}</p>
                            <div class="my_time" id="${Comment.getID()}">
                                <p>${Comment.getTime()}</p>
                            </div>
                        </div>
                    </div>

                </c:if>

            </c:forEach>

        </div>
    </div>
</div>


<div class="comment-input">
    <div class="input">
        <input name="textMessage" id="textMessage" type="text" placeholder="Viết bình luận...">
        <i class="fas fa-location-arrow" onclick="sendMessage()"></i>
    </div>
</div>

<div>

</div>
<script type="text/javascript">
    var websocket = new WebSocket(`ws://`+ window.location.hostname + '/commentServer');
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
        let id = ${myID};
        if (words[1] != id) {
            var name = "";
            var avatar = "";
            const xhttp = new XMLHttpRequest();
            xhttp.onload = function () {
                const myObj = JSON.parse(this.responseText);
                name = myObj.Name;
                avatar = myObj.Avatar;
                list_mess.innerHTML += ' <div class="their_mess"> ' +
                    '<img src="' + avatar + '">' +
                    '<div class="mess_detail" onmouseover="ShowTime(' + words[3] + ')" onmouseleave="OffTime(' + words[3] + ')">' +
                    '<h3>' + name + '</h3>' +
                    ' <p>' + words[0] + '</p>' +
                    '<div class="their_time" id="' + words[3] + '">' +
                    '<p>' + words[2] + '</p>' +
                    '</div>' +
                    '</div></div>';
                main.setAttribute("style", "height:" + list_mess.getBoundingClientRect().height);
            }
            xhttp.open("POST", "comment?userID=" + words[1]);
            xhttp.send();
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
                websocket.send(textMessage.value + "!!##@@${postID}!!##@@${myID}");
                textMessage.value = "";
            }

        }
    }

    var textMessage = document.getElementById("textMessage");

    textMessage.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            sendMessage();
        }
    });

    window.onload = ev => {
        if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
            websocket.send("1!2!@@12@@!!##@@${postID}!!##@@1");
        }
        var list_mess = document.getElementById("list_mess");
        var main = document.getElementById("main");
        main.setAttribute("style", "height:" + list_mess.getBoundingClientRect().height);
        document.getElementById("main_frame").scrollTo(0, document.getElementById("main_frame").scrollHeight);
    }

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
