package BO;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.CheckedInputStream;

import BO.ChatBO;


@ServerEndpoint(value = "/Chatroom")
public class ChatRoomServer {
    static Set<Session> chatRoomUser = Collections.synchronizedSet(new HashSet<Session>());
    static String userID1 = null;
    static String userID2 = null;

    @OnOpen
    public void handleOpen(Session userSession) {
        chatRoomUser.add(userSession);
    }

    @OnMessage
    public void handleMessages(String message, Session userSession) throws Exception {
        String userName = (String) userSession.getUserProperties().get("userName");
        if (userName == null) {
            String[] cutString = message.split(", ");
            userID1 =cutString[0];
            userID2 = cutString[1];
            userSession.getUserProperties().put("userName", userID1);
            userSession.getBasicRemote().sendText("System: You are now connected as " + userID1);
        } else {
            if (!(userSession.getUserProperties().get("userName").toString().equals(userID1)
                    || userSession.getUserProperties().get("userName").toString().equals(userID2))) {
                return;
            }
            int checkChatRoom=-1;
            for (Session session : chatRoomUser) {
                if (session.getUserProperties().get("userName").toString().equals(userID1)
                        || session.getUserProperties().get("userName").toString().equals(userID2)) {
                    session.getBasicRemote().sendText(userName + ": " + message);
                }
            }
            int userSend = Integer.parseInt(userSession.getUserProperties().get("userName").toString());
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dateTimeNow = dateFormat.format(date);
            try {
                checkChatRoom = ChatBO.getInstance().checkChatRoom(Integer.parseInt(userID1), Integer.parseInt(userID2));
                if(checkChatRoom==-1){
                    ChatBO.getInstance().addChatRoom(Integer.parseInt(userID1), Integer.parseInt(userID2));
                }
                checkChatRoom = ChatBO.getInstance().checkChatRoom(Integer.parseInt(userID1), Integer.parseInt(userID2));
                ChatBO.getInstance().addChat(checkChatRoom, userSend, message, dateTimeNow);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @OnClose
    public void handleClose(Session userSession) {
        chatRoomUser.remove(userSession);
    }

}
