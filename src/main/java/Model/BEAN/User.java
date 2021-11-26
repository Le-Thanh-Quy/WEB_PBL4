package Model.BEAN;

import Model.DAO.Connect;

import java.util.Date;

public class User {
    private int ID;
    private String Name;
    private String Age;
    private String Sex;
    private String Phone_Number;
    private String Address;
    private String Avatar;
    private String Status;
    private int AssessID;
    private String AccountID;
    private Assess Assess;
    private int Permission;

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

    public void setPermission(int permission) {
        Permission = permission;
    }

    public int getPermission() {
        return Permission;
    }


    public Assess getAssess() {
        return Assess;
    }

    public void setAssess(Assess assess) {
        Assess = assess;
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
