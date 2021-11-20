package Model.BEAN;

public class ChatRoom {
    int ID;
    int UserID1;
    int UserID2;
    boolean StatusU1;
    boolean StatusU2;
    boolean MyStatus;
    User myUser;
    User theirUser;

    public ChatRoom(int ID, int userID1, int userID2, boolean statusU1, boolean statusU2, boolean myStatus, User myUser, User theirUser) {
        this.ID = ID;
        UserID1 = userID1;
        UserID2 = userID2;
        StatusU1 = statusU1;
        StatusU2 = statusU2;
        MyStatus = myStatus;
        this.myUser = myUser;
        this.theirUser = theirUser;
    }

    public ChatRoom() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID1() {
        return UserID1;
    }

    public void setUserID1(int userID1) {
        UserID1 = userID1;
    }

    public int getUserID2() {
        return UserID2;
    }

    public void setUserID2(int userID2) {
        UserID2 = userID2;
    }

    public boolean isStatusU1() {
        return StatusU1;
    }

    public void setStatusU1(boolean statusU1) {
        StatusU1 = statusU1;
    }

    public boolean isStatusU2() {
        return StatusU2;
    }

    public void setStatusU2(boolean statusU2) {
        StatusU2 = statusU2;
    }

    public boolean isMyStatus() {
        return MyStatus;
    }

    public void setMyStatus(boolean myStatus) {
        MyStatus = myStatus;
    }

    public User getMyUser() {
        return myUser;
    }

    public void setMyUser(User myUser) {
        this.myUser = myUser;
    }

    public User getTheirUser() {
        return theirUser;
    }

    public void setTheirUser(User theirUser) {
        this.theirUser = theirUser;
    }
}
