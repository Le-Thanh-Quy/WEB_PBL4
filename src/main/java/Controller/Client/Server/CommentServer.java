package Controller.Client.Server;

import Model.BEAN.Chat;
import Model.BEAN.Comment;
import Model.BO.ChatBO;
import Model.BO.CommentBO;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


@ServerEndpoint(value = "/commentServer")
public class CommentServer {
    static Set<Session> commentRoomUser = Collections.synchronizedSet(new HashSet<Session>());


    @OnOpen
    public void handleOpen(Session userSession) {
    }

    @OnClose
    public void handleClose(Session userSession) {
        commentRoomUser.remove(userSession);
    }

    @OnMessage
    public void handleMessages(String message, Session userSession) throws Exception {

        commentRoomUser.add(userSession);
        String[] strings = message.split("!!##@@");
        String mess = strings[0];
        String ID = strings[1];
        String IDUser = strings[2];
        userSession.getUserProperties().put("RoomID", ID);
        if (mess.equals("1!2!@@12@@")) {
            return;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        Comment comment = new Comment();
        comment.setPostID(Integer.parseInt(ID));
        comment.setContent(mess);
        comment.setTime(formatter.format(date));
        comment.setUserID(Integer.parseInt(IDUser));
        int CommentID = CommentBO.getInstance().addComment(comment);

        for (Session session : commentRoomUser) {
            if (session.getUserProperties().get("RoomID").toString().equals(ID)) {
                if (CommentID != -1) {
                    session.getBasicRemote().sendText(mess + "!!##@@" + IDUser + "!!##@@" + GetDateTime() + "!!##@@" + CommentID);
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
