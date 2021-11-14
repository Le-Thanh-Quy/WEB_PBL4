package Model.BO;

import Model.BEAN.*;
import Model.DAO.Connect;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostBO {
    private static PostBO instance;

    public static PostBO getInstance() {
        if (instance == null) {
            instance = new PostBO();
        }
        return instance;
    }


    // Xử lý chuỗi
    public String[] handleString(String str) {
        String[] stringList = str.split(", ");
        return stringList;
    }

    public String Format(String date) {
        String[] strings = date.split("-");
        String result = "";
        result = strings[2] + "/" + strings[1] + "/" + strings[0];
        return result;
    }

    public String FormatDateTime(String date) {
        String[] strings = date.split(" ");
        String result = "";
        result = Format(strings[0]) + " lúc " + strings[1];
        return result;
    }

    public List<Post> getPostList(int ID) {
        LocalDateTime now = LocalDateTime.now();
        String date = now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth();

        List<Post> postList = null;
        if (ID == -1) {
            postList = Connect.getInstance().postList(Connect.getInstance().GetMaxIDPost(), date);
        } else {
            postList = Connect.getInstance().postList(ID, date);
        }

        for (int i = 0; i < postList.size(); i++) {
            postList.get(i).setDateTime(FormatDateTime(postList.get(i).getDateTime()));
            postList.get(i).setDate(Format(postList.get(i).getDate()));
            User user = Connect.getInstance().GetUser("-1", postList.get(i).getUserID());
            user.setAssess(Connect.getInstance().GetAssess(user.getAssessID()));
            postList.get(i).setUser(user);
            String[] startAddress = handleString(Connect.getInstance().GetAddress(postList.get(i).getStartAddress()));
            String[] endAddress = handleString(Connect.getInstance().GetAddress(postList.get(i).getEndAddress()));
            postList.get(i).setStartCommune(startAddress[0]);
            postList.get(i).setStartDistrict(startAddress[1]);
            postList.get(i).setStartProvince(startAddress[2]);
            postList.get(i).setEndCommune(endAddress[0]);
            postList.get(i).setEndDistrict(endAddress[1]);
            postList.get(i).setEndProvince(endAddress[2]);
        }

        return postList;
    }

    public List<Post> getPostListWithUser(int ID , int UserID) {

        List<Post> postList = null;
        if (ID == -1) {
            postList = Connect.getInstance().postListWithUser(Connect.getInstance().GetMaxIDPost(), UserID);
        } else {
            postList = Connect.getInstance().postListWithUser(ID, UserID);
        }
        for (int i = 0; i < postList.size(); i++) {
            postList.get(i).setDateTime(FormatDateTime(postList.get(i).getDateTime()));
            postList.get(i).setDate(Format(postList.get(i).getDate()));
            User user = Connect.getInstance().GetUser("-1", postList.get(i).getUserID());
            user.setAssess(Connect.getInstance().GetAssess(user.getAssessID()));
            postList.get(i).setUser(user);
            String[] startAddress = handleString(Connect.getInstance().GetAddress(postList.get(i).getStartAddress()));
            String[] endAddress = handleString(Connect.getInstance().GetAddress(postList.get(i).getEndAddress()));
            postList.get(i).setStartCommune(startAddress[0]);
            postList.get(i).setStartDistrict(startAddress[1]);
            postList.get(i).setStartProvince(startAddress[2]);
            postList.get(i).setEndCommune(endAddress[0]);
            postList.get(i).setEndDistrict(endAddress[1]);
            postList.get(i).setEndProvince(endAddress[2]);
        }

        return postList;
    }
    public boolean AddNewPost(Post post){
        LocalDateTime now = LocalDateTime.now();
        String datetime = "";
        datetime = now.getYear() + "-" + now.getMonthValue() +
                "-" + now.getDayOfMonth() + " " + now.getHour() +
                ":" + now.getMinute() + ":" + now.getSecond();
        post.setDateTime(datetime);
        return  Connect.getInstance().AddNewPost(post);
    }
}
