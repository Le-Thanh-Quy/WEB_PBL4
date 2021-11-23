package Model.BEAN;

public class UserForAdmin {
    public int ID;
    public String Name;
    public String Age;
    public String Sex;
    public int Rate;
    public String Roles;

    public UserForAdmin() {
    }

    public UserForAdmin(int ID, String name, String age, String sex, int rate, String roles) {
        this.ID = ID;
        Name = name;
        Age = age;
        Sex = sex;
        Rate = rate;
        Roles = roles;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String roles) {
        Roles = roles;
    }
}
