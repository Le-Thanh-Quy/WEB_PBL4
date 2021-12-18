package Model.BO;

import Model.BEAN.Assess;
import Model.BEAN.Interact;
import Model.BEAN.Report;
import Model.BEAN.User;
import Model.DAO.Connect;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
        User user = Connect.getInstance().GetUser(user_name, 0);
        if (user.getAge() != null) {
            user.setAge(Format(user.getAge()));
        }
        return user;
    }


    public Assess GetAssess(int ID) {

        return Connect.getInstance().GetAssess(ID);
    }

    public String GetAddress(String idXa) {

        return Connect.getInstance().GetAddress(idXa);
    }

    public boolean Register(String Username, String PassWord) {
        return Connect.getInstance().Register(Username, PassWord);
    }

    public boolean Assess(String rank, String myID, String theirID) {
        Interact interact = Connect.getInstance().checkInteractID(myID, theirID);
        if (interact.getID() == -1) {

            int ID = Connect.getInstance().getInteractID();
            if (ID == -1) {
                return false;
            }
            interact.setID(ID);
            interact.setUserID1(Integer.parseInt(myID));
            interact.setUserID2(Integer.parseInt(theirID));
            interact.setRankUser1(Integer.parseInt(rank));
            interact.setRankUser2(0);

            if (Connect.getInstance().setInteractID(interact, ID)) {
                return setAssess(theirID, rank, true);
            }
        } else {
            if (interact.getUserID1() == Integer.parseInt(myID)) {
                interact.setRankUser1(Integer.parseInt(rank));
            } else {
                interact.setRankUser2(Integer.parseInt(rank));
            }
            if (Connect.getInstance().setInteractID(interact, -1)) {
                return setAssess(theirID, rank, false);
            }
        }
        return false;
    }

    public boolean setAssess(String theirID, String rank, boolean check) {
        User user = Connect.getInstance().GetUser("-1", Integer.parseInt(theirID));
        Assess assess = Connect.getInstance().GetAssess(user.getAssessID());
        int total = assess.getReview();
        if (check) {
            total = total + 1;
        }
        double newRank = (assess.getReview() * assess.getRate() + Double.parseDouble(rank) + 0.5) / (assess.getReview() + 1);
        if (newRank > 5) {
            newRank = 5;
        }
        assess.setReview(total);
        assess.setRate(newRank);
        return Connect.getInstance().setAssess(assess);
    }

    public int getInteract(String myID, String theirID) {
        Interact interact = Connect.getInstance().checkInteractID(myID, theirID);
        if (interact.getUserID1() == Integer.parseInt(myID)) {
            return interact.getRankUser1();
        } else {
            return interact.getRankUser2();
        }
    }


    public boolean addReport(String myID, String theirID, String content , String postID) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = new Date(System.currentTimeMillis() + 25200000);
        int ID = Connect.getInstance().getReportID();
        if(ID == -1){
            return false;
        }
        return  Connect.getInstance().addReport(ID , myID , theirID , content , formatter.format(date) , postID);
    }

    public String FormatDateTime(String date) {
        String[] strings = date.split(" ");
        String result = "";
        result = Format(strings[0]) + " lúc " + strings[1];
        return result;
    }
    public List<Report> getListReport(int id) {
        List<Report> reports = new ArrayList<Report>();
        for (Report i:Connect.getInstance().getListReport(id)) {
            i.setUserViolate(Connect.getInstance().GetUser("-1" , i.getUserViolateID()));
            i.setTime(FormatDateTime(i.getTime()));
            reports.add(i);
        }
        return reports;
    }

    public boolean UpdateUser(User user) {
        return Connect.getInstance().UpdateUser(user);
    }

    public boolean changePassWord(String userName, String passWord, String newPassWord) {
        if(Connect.getInstance().checkLogin(userName , passWord) == -1){
            return false;
        }else{
            return Connect.getInstance().changePassWord(userName , passWord , newPassWord);
        }
    }
}
