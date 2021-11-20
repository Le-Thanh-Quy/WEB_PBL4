package Model.BEAN;

public class Chat {
    int ID;
    int ChatRoomID;
    int UserID;
    String Messenger;
    String Time;

    public Chat(int ID, int chatRoomID, int userID, String messenger, String time) {
        this.ID = ID;
        ChatRoomID = chatRoomID;
        UserID = userID;
        Messenger = messenger;
        Time = time;
    }

    public Chat() {
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setChatRoomID(int chatRoomID) {
        ChatRoomID = chatRoomID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setMessenger(String messenger) {
        Messenger = messenger;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getID() {
        return ID;
    }

    public int getChatRoomID() {
        return ChatRoomID;
    }

    public int getUserID() {
        return UserID;
    }

    public String getMessenger() {
        return Messenger;
    }

    public String getTime() {
        return Time;
    }
}
