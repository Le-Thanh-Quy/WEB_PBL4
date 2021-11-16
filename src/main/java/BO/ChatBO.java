package BO;

import BEAN.Messenger;
import DAO.Connect;

import java.util.List;

public class ChatBO {
    private static ChatBO instance;

    public static ChatBO getInstance() {
        if (instance == null) {
            instance = new ChatBO();
        }
        return instance;
    }

    public boolean addChatRoom(int userID1, int userID2){
        return Connect.getInstance().addChatRoom(userID1, userID2);
    }

    public boolean addChat( int ChatRoomID, int userID, String messenger, String time){
        return Connect.getInstance().addChat(ChatRoomID, userID, messenger, time);
    }

    public List<Messenger> ShowMessenger(int ChatRoomID){
        return Connect.getInstance().ShowMessenger(ChatRoomID);
    }

    public int checkChatRoom(int userID1, int userID2){
        return Connect.getInstance().checkChatRoom(userID1, userID2);
    }
}
