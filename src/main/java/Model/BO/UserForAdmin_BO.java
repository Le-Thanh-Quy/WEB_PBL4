package Model.BO;

import Model.BEAN.User;
import Model.DAO.Connect;
import Model.DAO.ConnectAdmin;
import org.apache.commons.codec.digest.DigestUtils;


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

    public String FormatDate(String date) {
        String[] strings = date.split("-");
        return strings[2] + "/" + strings[1] + "/" + strings[0];
    }

    public List<User> GetListUserForAdminList() {
        List<User> userList = new ArrayList<>();
        for (User i : ConnectAdmin.getInstance().GetListUserForAdminList()) {
            i.setAge(FormatDate(i.getAge()));
            i.setPermission(Connect.getInstance().checkSignUp(i.getAccountID()));
            userList.add(i);
        }
        return userList;
    }

    public int GetIDAssess() {
        return Connect.getInstance().GetIDAssess();
    }

    public int GetIDAccount() {
        return ConnectAdmin.getInstance().GetIDAccount();
    }

    public boolean AddAssess(int idAssess) {
        return ConnectAdmin.getInstance().AddAssess(idAssess);
    }

    public boolean AddAccount(String userName, String passWord, String permission) {
        String md5Hex = DigestUtils.md5Hex(passWord).toUpperCase();
        return ConnectAdmin.getInstance().AddAccount(userName, md5Hex, permission);
    }

    public int getIDUser() {
        return ConnectAdmin.getInstance().getIDUser();
    }

    public boolean AddUser(int idUser, String name, String age, String sex, String phoneNumber, String address, String avatar, String status, int idAssess, String userName) {
        User user = new User(idUser, name, age, sex, phoneNumber, address, avatar, status, idAssess, userName);
        return Connect.getInstance().AddUser(user);
    }

    public List<User> FindUser(String key, boolean check) {
        List<User> list = new ArrayList<>();
        for (User i : UserForAdmin_BO.getInstance().GetListUserForAdminList()) {
            if (check) {
                if (String.valueOf(i.getID()).toUpperCase().trim().contains(key.toUpperCase().trim())
                        || i.getName().toUpperCase().trim().contains(key.toUpperCase().trim())
                        || i.getSex().toUpperCase().trim().contains(key.toUpperCase().trim())) {
                    list.add(i);
                } else if (i.getPhone_Number().toUpperCase().trim().contains(key.toUpperCase().trim()) && key.length() > 4) {
                    list.add(i);
                }

            } else {

                if (String.valueOf(i.getPermission()).toUpperCase().trim().equals(key.toUpperCase().trim())) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    public boolean DelUser(List<String> listID) {
        for (String id : listID) {
            if(!ConnectAdmin.getInstance().DelUser(id)){
                return false;
            }
        }
        return true;
    }

    public User getUser() {
        return Connect.getInstance().GetUser("-1", 0);
    }

    public User getUserbyID(String userID) {
        return Connect.getInstance().GetUser("-1" , Integer.parseInt(userID));
    }

    public boolean UpdateUser(User user) {
        return ConnectAdmin.getInstance().UpdateUser(user);
    }
}
