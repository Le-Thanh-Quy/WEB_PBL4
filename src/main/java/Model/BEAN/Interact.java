package Model.BEAN;

public class Interact {
    int ID;
    int UserID1;
    int UserID2;
    int RankUser1;
    int RankUser2;

    public Interact(int ID, int userID1, int userID2, int rankUser1, int rankUser2) {
        this.ID = ID;
        UserID1 = userID1;
        UserID2 = userID2;
        RankUser1 = rankUser1;
        RankUser2 = rankUser2;
    }

    public Interact() {
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

    public int getRankUser1() {
        return RankUser1;
    }

    public void setRankUser1(int rankUser1) {
        RankUser1 = rankUser1;
    }

    public int getRankUser2() {
        return RankUser2;
    }

    public void setRankUser2(int rankUser2) {
        RankUser2 = rankUser2;
    }
}
