package Model;

public class User {
    public int ID;
    public String Name;
    public int Age;
    public double Phone_Number;
    public String Address;
    public String Avatar;
    public String Status;
    public int AssessID;
    public String AccountID;

    public User(int ID, String name, int age, double phone_Number, String address, String avatar, String status, int assessID, String accountID) {
        this.ID = ID;
        Name = name;
        Age = age;
        Phone_Number = phone_Number;
        Address = address;
        Avatar = avatar;
        Status = status;
        AssessID = assessID;
        AccountID = accountID;
    }

    public User() {
    }
}
