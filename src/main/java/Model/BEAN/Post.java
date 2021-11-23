package Model.BEAN;

public class Post {
    int ID;
    User user;
    int UserID;
    String StartProvince;
    String StartDistrict;
    String StartCommune;
    String EndProvince;
    String EndDistrict;
    String EndCommune;
    String StartAddress;
    String EndAddress;
    String DateTime;
    String TimeStart;
    String Date;
    String Caption;
    String Image;


    public Post(){

    }
    public Post(int ID, User user, String startAddress, String endAddress, String dateTime, String timeStart, String date, String caption , String Image) {
        this.ID = ID;
        this.user = user;
        StartAddress = startAddress;
        EndAddress = endAddress;
        DateTime = dateTime;
        TimeStart = timeStart;
        Date = date;
        Caption = caption;
        this.Image = Image;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStartProvince(String startProvince) {
        StartProvince = startProvince;
    }

    public void setStartDistrict(String startDistrict) {
        StartDistrict = startDistrict;
    }

    public void setStartCommune(String startCommune) {
        StartCommune = startCommune;
    }

    public void setEndProvince(String endProvince) {
        EndProvince = endProvince;
    }

    public void setEndDistrict(String endDistrict) {
        EndDistrict = endDistrict;
    }

    public void setEndCommune(String endCommune) {
        EndCommune = endCommune;
    }

    public void setStartAddress(String startAddress) {
        StartAddress = startAddress;
    }

    public void setEndAddress(String endAddress) {
        EndAddress = endAddress;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public void setTimeStart(String timeStart) {
        TimeStart = timeStart;
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

    public User getUser() {
        return user;
    }

    public String getStartProvince() {
        return StartProvince;
    }

    public String getStartDistrict() {
        return StartDistrict;
    }

    public String getStartCommune() {
        return StartCommune;
    }

    public String getEndProvince() {
        return EndProvince;
    }

    public String getEndDistrict() {
        return EndDistrict;
    }

    public String getEndCommune() {
        return EndCommune;
    }

    public String getStartAddress() {
        return StartAddress;
    }

    public String getEndAddress() {
        return EndAddress;
    }

    public String getDateTime() {
        return DateTime;
    }

    public String getTimeStart() {
        return TimeStart;
    }

    public String getDate() {
        return Date;
    }

    public String getCaption() {
        return Caption;
    }

    @Override
    public String toString() {
        return "Post{" +
                "ID=" + ID +
                ", user=" + user +
                ", UserID=" + UserID +
                ", StartProvince='" + StartProvince + '\'' +
                ", StartDistrict='" + StartDistrict + '\'' +
                ", StartCommune='" + StartCommune + '\'' +
                ", EndProvince='" + EndProvince + '\'' +
                ", EndDistrict='" + EndDistrict + '\'' +
                ", EndCommune='" + EndCommune + '\'' +
                ", StartAddress='" + StartAddress + '\'' +
                ", EndAddress='" + EndAddress + '\'' +
                ", DateTime='" + DateTime + '\'' +
                ", TimeStart='" + TimeStart + '\'' +
                ", Date='" + Date + '\'' +
                ", Caption='" + Caption + '\'' +
                ", Image='" + Image + '\'' +
                '}';
    }
}
