package Model.BEAN;

public class Chat {
    int ID;
    int ChatRoomID;
    int UserID;
    String Messenger;
    String Time;
    int type;



    public Chat() {
    }

    public Chat(int ID, int chatRoomID, int userID, String messenger, String time, int type) {
        this.ID = ID;
        ChatRoomID = chatRoomID;
        UserID = userID;
        Messenger = messenger;
        Time = time;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
