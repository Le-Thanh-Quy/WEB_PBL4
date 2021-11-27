package Model.BEAN;

public class Request {
    int ID;
    int SenderID;
    int ReceiverID;
    int PostID;
    String Content;
    int Status;

    public Request(int ID, int senderID, int receiverID, int postID, String content, int status) {
        this.ID = ID;
        SenderID = senderID;
        ReceiverID = receiverID;
        PostID = postID;
        Content = content;
        Status = status;
    }

    public Request() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSenderID() {
        return SenderID;
    }

    public void setSenderID(int senderID) {
        SenderID = senderID;
    }

    public int getReceiverID() {
        return ReceiverID;
    }

    public void setReceiverID(int receiverID) {
        ReceiverID = receiverID;
    }

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int postID) {
        PostID = postID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}