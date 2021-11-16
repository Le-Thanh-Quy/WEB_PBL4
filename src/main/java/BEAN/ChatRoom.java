package BEAN;

import java.util.PrimitiveIterator;

public class ChatRoom {
    private int ChatRoomID;
    private int UserID1;
    private int USerID2;

    public ChatRoom() {
    }

    public ChatRoom(int chatRoomID, int userID1, int USerID2) {
        ChatRoomID = chatRoomID;
        UserID1 = userID1;
        this.USerID2 = USerID2;
    }

    public int getChatRoomID() {
        return ChatRoomID;
    }

    public void setChatRoomID(int chatRoomID) {
        ChatRoomID = chatRoomID;
    }

    public int getUserID1() {
        return UserID1;
    }

    public void setUserID1(int userID1) {
        UserID1 = userID1;
    }

    public int getUSerID2() {
        return USerID2;
    }

    public void setUSerID2(int USerID2) {
        this.USerID2 = USerID2;
    }
}
