package Model.BEAN;

public class Report {
    int ID;
    int UserReportID;
    int UserViolateID;
    int PostID;
    String Content;
    String Time;
    boolean Status;
    String Feedback;
    User UserViolate;
    User UserReport;



    public Report(int ID, int userReportID, int userViolateID, int postID, String content, String time, boolean status, String feedback, User userViolate, User userReport) {
        this.ID = ID;
        UserReportID = userReportID;
        UserViolateID = userViolateID;
        PostID = postID;
        Content = content;
        Time = time;
        Status = status;
        Feedback = feedback;
        UserViolate = userViolate;
        UserReport = userReport;
    }

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int postID) {
        PostID = postID;
    }

    public User getUserViolate() {
        return UserViolate;
    }

    public User getUserReport() {
        return UserReport;
    }

    public void setUserReport(User userReport) {
        UserReport = userReport;
    }

    public void setUserViolate(User userViolate) {
        UserViolate = userViolate;
    }

    public Report() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserReportID() {
        return UserReportID;
    }

    public void setUserReportID(int userReportID) {
        UserReportID = userReportID;
    }

    public int getUserViolateID() {
        return UserViolateID;
    }

    public void setUserViolateID(int userViolateID) {
        UserViolateID = userViolateID;
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

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }
}
