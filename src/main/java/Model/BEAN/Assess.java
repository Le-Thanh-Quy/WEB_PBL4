package Model.BEAN;

public class Assess {
    public int ID;
    public int Rate;
    public int Review;

    public Assess() {
    }

    public Assess(int ID, int rate, int review) {
        this.ID = ID;
        Rate = rate;
        Review = review;
    }

    public int getID() {
        return ID;
    }

    public int getRate() {
        return Rate;
    }

    public int getReview() {
        return Review;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public void setReview(int review) {
        Review = review;
    }
}
