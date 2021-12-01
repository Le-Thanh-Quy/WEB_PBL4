package Controller.Client.Server;

import Model.BEAN.Chat;
import Model.BO.ChatBO;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


@ServerEndpoint(value = "/Chatroom")
public class ChatRoomServer {
    static Set<Session> chatRoomUser = Collections.synchronizedSet(new HashSet<Session>());


    @OnOpen
    public void handleOpen(Session userSession) {
    }

    @OnClose
    public void handleClose(Session userSession) {
        chatRoomUser.remove(userSession);

    }

    @OnMessage
    public void handleMessages(String message, Session userSession) throws Exception {

        chatRoomUser.add(userSession);
        String[] strings = message.split("!!##@@");
        String mess = strings[0];
        String ID = strings[1];
        String IDUser = strings[2];
        String Type = strings[3];
        userSession.getUserProperties().put("RoomID", ID);

        if (ID.equals("admin")) {
            int RoomID = ChatBO.getInstance().CreateRoomChatAdmin(Integer.parseInt(IDUser), mess);
            return;
        }


        if (mess.equals("1!2!@@12@@")) {
            return;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        Chat chat = new Chat();
        chat.setChatRoomID(Integer.parseInt(ID));
        chat.setMessenger(mess);
        chat.setTime(formatter.format(date));
        chat.setUserID(Integer.parseInt(IDUser));
        chat.setType(Integer.parseInt(Type));
        int ChatID = ChatBO.getInstance().addChat(chat);

        for (Session session : chatRoomUser) {
            if (session.getUserProperties().get("RoomID").toString().equals(ID)) {
                if (ChatID != -1) {
                    if (ChatBO.getInstance().sendStatus(ID, IDUser)) {
                        session.getBasicRemote().sendText(mess + "!!##@@" + IDUser + "!!##@@" + GetDateTime() + "!!##@@" + ChatID + "!!##@@" + Type);
                    }
                }
            }
        }
    }

    public String GetDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'lúc' HH:mm");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }


}
