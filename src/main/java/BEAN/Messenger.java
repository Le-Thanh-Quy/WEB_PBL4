package BEAN;

public class Messenger {
    private int UserID;
    private String Messenger;
    private String Time;

    public Messenger() {
    }

    public Messenger(int userID, String messenger, String time) {
        UserID = userID;
        Messenger = messenger;
        Time = time;
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

    @Override
    public String toString() {
        return UserID + ": " + Messenger + " lúc "+ Time ;
    }
}
