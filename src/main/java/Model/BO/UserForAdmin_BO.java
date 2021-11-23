package Model.BO;

import Model.BEAN.User;
import Model.BEAN.UserForAdmin;
import Model.DAO.Connect;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

public class UserForAdmin_BO {
    private static UserForAdmin_BO instance;

    public static UserForAdmin_BO getInstance() {
        if (instance == null) {
            instance = new UserForAdmin_BO();
        }
        return instance;
    }

    public List<UserForAdmin> GetListUserForAdminList(){
        return Connect.getInstance().GetListUserForAdminList();
    }

    public int GetIDAssess() {
        return Connect.getInstance().GetIDAssess();
    }

    public int GetIDAccount() {
        return  Connect.getInstance().GetIDAccount();
    }

    public boolean AddAssess(int idAssess) {
        return Connect.getInstance().AddAssess(idAssess);
    }

    public boolean AddAccount(String userName, String passWord, String permission) {
        return Connect.getInstance().AddAccount(userName, passWord, permission);
    }

    public int getIDUser() {
        return Connect.getInstance().getIDUser();
    }

    public boolean AddUser(int idUser, String name, String age, String sex, String phoneNumber, String address, String avatar, String status, int idAssess, String userName) {
        User user = new User(idUser, name, age, sex, phoneNumber, address, avatar, status, idAssess, userName);
        return Connect.getInstance().AddUser(user);
    }

    public List<UserForAdmin> FindUser(String key){
        List<UserForAdmin> list = new ArrayList<>();
        for (UserForAdmin i: UserForAdmin_BO.getInstance().GetListUserForAdminList()) {
            if(i.getRoles().toUpperCase().trim().equals(key.toUpperCase().trim())){
                list.add(i);
            }
            if(i.getName().toUpperCase().trim().contains(key.toUpperCase().trim())){
                list.add(i);
            }
        }
        return list;
    }

    public boolean DelUser(String id) {
        return Connect.getInstance().DelUser(id);
    }
}
