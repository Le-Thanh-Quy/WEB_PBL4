package Model.BO;

import Model.BEAN.Assess;
import Model.BEAN.User;
import Model.DAO.Connect;


public class AuthBO {
    private static AuthBO instance;

    public static AuthBO getInstance() {
        if (instance == null) {
            instance = new AuthBO();
        }
        return instance;
    }

    public int checkSignUp(String Username) {

        return Connect.getInstance().checkSignUp(Username);
    }

    public int checkLogin(String Username, String Password) {
        return Connect.getInstance().checkLogin(Username, Password);
    }

    public boolean AddUser(User user) {
        return Connect.getInstance().AddUser(user);
    }

    public void DeleteAccount(String user_name) {
        Connect.getInstance().DeleteAccount(user_name);
    }


    public String Format(String date) {
        String[] strings = date.split("-");
        String result = "";
        result = strings[2] + "/" + strings[1] + "/" + strings[0];
        return result;
    }

    public User GetUser(String user_name) {
        User user = Connect.getInstance().GetUser(user_name , 0);
        user.setAge(Format(user.getAge()));
        return user;
    }

    ;

    public Assess GetAssess(int ID) {

        return Connect.getInstance().GetAssess(ID);
    }

    public String GetAddress(String idXa) {

        return Connect.getInstance().GetAddress(idXa);
    }

    public boolean Register(String Username, String PassWord) {
        return Connect.getInstance().Register(Username , PassWord);
    }
}
