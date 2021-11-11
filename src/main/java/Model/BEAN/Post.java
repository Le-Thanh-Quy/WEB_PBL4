package Model.BEAN;

public class Post {
    int ID;
    int UserID;
    String StartID;
    String EndID;
    String Time;
    String Date;
    String Caption;

    public Post(int ID, int userID, String startID, String endID, String time, String date, String caption) {
        this.ID = ID;
        UserID = userID;
        StartID = startID;
        EndID = endID;
        Time = time;
        Date = date;
        Caption = caption;
    }

    public Post() {
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setStartID(String startID) {
        StartID = startID;
    }

    public void setEndID(String endID) {
        EndID = endID;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setCaption(String caption) {
        Caption = caption;
    }

    public int getID() {
        return ID;
    }

    public int getUserID() {
        return UserID;
    }

    public String getStartID() {
        return StartID;
    }

    public String getEndID() {
        return EndID;
    }

    public String getTime() {
        return Time;
    }

    public String getDate() {
        return Date;
    }

    public String getCaption() {
        return Caption;
    }
}
