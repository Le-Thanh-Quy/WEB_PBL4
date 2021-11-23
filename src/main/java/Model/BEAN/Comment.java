package Model.BEAN;

public class Comment {
    int ID;
    int PostID;
    int UserID;
    String Content;
    String Time;
    User user;

    public Comment(int ID, int postID, int userID, String content, String time, User user) {
        this.ID = ID;
        PostID = postID;
        UserID = userID;
        Content = content;
        Time = time;
        this.user = user;
    }

    public Comment() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int postID) {
        PostID = postID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
