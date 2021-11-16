<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11/14/2021
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Demo websocket</title>
</head>
<body onload="OL()">
<h1>Demo WebSocket</h1>
<input id="textMessage" type="text" />
<input id="btnSend" onclick="sendMessage()" value="Send Message" type="button" /> <br/><br/>

<textarea id="textAreaMessage" rows="10" cols="50">
<c:forEach items="${listMess}" var="item">
    <c:out value="${item}"/>
</c:forEach>
</textarea>
<script type="text/javascript">
    var websocket = new WebSocket("ws://localhost:8080/ChatWebSocket_war_exploded/Chatroom");
    websocket.onopen = function(message) {processOpen(message);};
    websocket.onmessage = function(message) {processMessage(message);};
    websocket.onclose = function(message) {processClose(message);};

    function processOpen(message) {
        var clone=textAreaMessage.value;
        textAreaMessage.value = "Server connect...\n";
        textAreaMessage.value +=clone;
    }
    function processMessage(message) {
        const now = new Date();
        now.setTime(now.getTime() - new Date().getTimezoneOffset()*60*1000);
        textAreaMessage.value += message.data +" lúc "+ now.getUTCFullYear().toString() + "-" +
            (now.getUTCMonth() + 1).toString() +
            "-" + now.getUTCDate() + " " + now.getUTCHours() +
            ":" + now.getUTCMinutes() + ":" + now.getUTCSeconds()+" \n";
    }
    function processClose(message) {
        textAreaMessage.value += "Server Disconnect... \n";
    }
    if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
        websocket.send('1, 2');
    }
    function sendMessage() {
        if (typeof websocket != 'undefined' && websocket.readyState == WebSocket.OPEN) {
            websocket.send(textMessage.value);
            textMessage.value = "";
            document.getElementById("textAreaMessage").scrollTo(0, document.getElementById("textAreaMessage").scrollHeight);
        }
    }
    function OL(){
        websocket.send("1, 2");
    }
    // window.onload = function (){
    //     websocket.send("1, 2");
    // }

</script>
</body>
</html>
