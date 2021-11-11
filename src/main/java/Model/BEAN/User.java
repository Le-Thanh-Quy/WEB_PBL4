package Model.BEAN;

import java.util.Date;

public class User {
    public int ID;
    public String Name;
    public String Age;
    public String Sex;
    public String Phone_Number;
    public String Address;
    public String Avatar;
    public String Status;
    public int AssessID;
    public String AccountID;

    public User(int ID, String name, String age, String sex, String phone_Number, String address, String avatar, String status, int assessID, String accountID) {
        this.ID = ID;
        Name = name;
        Age = age;
        Phone_Number = phone_Number;
        Address = address;
        Avatar = avatar;
        Status = status;
        AssessID = assessID;
        AccountID = accountID;
        Sex = sex;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Age='" + Age + '\'' +
                ", Phone_Number='" + Phone_Number + '\'' +
                ", Address='" + Address + '\'' +
                ", Avatar='" + Avatar + '\'' +
                ", Status='" + Status + '\'' +
                ", AssessID=" + AssessID +
                ", AccountID='" + AccountID + '\'' +
                '}';
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getAge() {
        return Age;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public String getAddress() {
        return Address;
    }

    public String getAvatar() {
        return Avatar;
    }

    public String getStatus() {
        return Status;
    }

    public int getAssessID() {
        return AssessID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setAssessID(int assessID) {
        AssessID = assessID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }
}
