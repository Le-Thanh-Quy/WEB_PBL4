package Model.BEAN;

public class Assess {
    private int ID;
    private double Rate;
    private int Review;

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

    public double getRate() {
        return Rate;
    }

    public int getReview() {
        return Review;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    public void setReview(int review) {
        Review = review;
    }
}
