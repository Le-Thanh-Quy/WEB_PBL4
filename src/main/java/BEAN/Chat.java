package BEAN;

public class Chat {
    private int ChatID;
    private int ChatRoomID;
    private int UserID;
    private String Messenger;
    private String Time;

    public Chat() {
    }

    public Chat(int chatID, int chatRoomID, int userID, String messenger, String time) {
        ChatID = chatID;
        ChatRoomID = chatRoomID;
        UserID = userID;
        Messenger = messenger;
        Time = time;
    }

    public int getChatID() {
        return ChatID;
    }

    public void setChatID(int chatID) {
        ChatID = chatID;
    }

    public int getChatRoomID() {
        return ChatRoomID;
    }

    public void setChatRoomID(int chatRoomID) {
        ChatRoomID = chatRoomID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getMessenger() {
        return Messenger;
    }

    public void setMessenger(String messenger) {
        Messenger = messenger;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
