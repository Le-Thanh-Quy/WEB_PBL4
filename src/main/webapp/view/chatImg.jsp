<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Model.BEAN.ChatRoom" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>

<body>
<script type="text/javascript">

    function processOpen(message) {
    }

    function processClose(message) {
    }

    function processMessage(message) {
    }

    window.onload = ev => {
        var websocket = new WebSocket('ws://' + window.location.hostname + '/Chatroom');//' + window.location.hostname + ' localhost:8080/WebPBL4_war_exploded
        websocket.onopen = function (message) {
            processOpen(message);
            if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
                console.log("a");
                websocket.send("${imgID}" + "!!##@@${chatRoom.getID()}!!##@@${chatRoom.getMyUser().getID()}!!##@@2");
            }
        };
        websocket.onmessage = function (message) {
            processMessage(message);
        };
        websocket.onclose = function (message) {
            processClose(message);
        };
    }
</script>

</body>

</html>
