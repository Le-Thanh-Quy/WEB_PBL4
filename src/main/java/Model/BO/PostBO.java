package Model.BO;

import Model.BEAN.*;
import Model.DAO.Connect;
import Model.DAO.ConnectAdmin;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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

    public List<Post> getPostListWithUser(int ID, int UserID) {

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

    public boolean AddNewPost(Post post) {
        LocalDateTime now = LocalDateTime.now();
        String datetime = "";
        datetime = now.getYear() + "-" + now.getMonthValue() +
                "-" + now.getDayOfMonth() + " " + now.getHour() +
                ":" + now.getMinute() + ":" + now.getSecond();
        post.setDateTime(datetime);
        return Connect.getInstance().AddNewPost(post);
    }

    public int[] NextDay(int manyDay, int Day, int Month, int Year) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, manyDay);
        int NextDay = calendar.getTime().getDate();
        if (NextDay > Day) {
            Day = NextDay;
        } else {
            Day = NextDay;
            if (Month == 12) {
                Month = 1;
                Year += 1;
            } else {
                Month += 1;
            }
        }
        int[] Date = new int[3];
        Date[0] = Day;
        Date[1] = Month;
        Date[2] = Year;
        return Date;
    }

    public String DateSearch(String Date) {
        String resultDate = "";
        LocalDateTime now = LocalDateTime.now();

        int Day = now.getDayOfMonth();
        int Month = now.getMonthValue();
        int Year = now.getYear();
        if (Date.equals("0")) {
            resultDate = Year + "-" + Month + '-' + Day;
        } else if (Date.equals("1")) {
            Day = NextDay(1, Day, Month, Year)[0];
            Month = NextDay(1, Day, Month, Year)[1];
            Year = NextDay(1, Day, Month, Year)[2];
            resultDate = Year + "-" + Month + '-' + Day;
        } else if (Date.equals("2")) {
            Day = NextDay(2, Day, Month, Year)[0];
            Month = NextDay(2, Day, Month, Year)[1];
            Year = NextDay(2, Day, Month, Year)[2];
            resultDate = Year + "-" + Month + '-' + Day;
        } else if (Date.equals("3")) {
            Day = NextDay(3, Day, Month, Year)[0];
            Month = NextDay(3, Day, Month, Year)[1];
            Year = NextDay(3, Day, Month, Year)[2];
            resultDate = Year + "-" + Month + '-' + Day;
        } else if (Date.equals("4")) {
            Day = NextDay(4, Day, Month, Year)[0];
            Month = NextDay(4, Day, Month, Year)[1];
            Year = NextDay(4, Day, Month, Year)[2];
            resultDate = Year + "-" + Month + '-' + Day;
        } else if (Date.equals("5")) {
            Day = NextDay(5, Day, Month, Year)[0];
            Month = NextDay(5, Day, Month, Year)[1];
            Year = NextDay(5, Day, Month, Year)[2];
            resultDate = Year + "-" + Month + '-' + Day;
        }
        return resultDate;
    }

    public List<Post> SearchPost(int ID, String StartID, String EndID, String Time, String Date) {
        List<Post> postList = null;
        if (StartID.equals("")) {
            StartID = "null";
        }
        if (EndID.equals("")) {
            EndID = "null";
        }
        if (Time.equals("Thời gian khởi hành")) {
            Time = "null";
        }
        if (Date.equals("Ngày khởi hành")) {
            Date = "null";
        } else {
            Date = DateSearch(Date);
        }
        if (ID == -1) {
            postList = Connect.getInstance().SearchPost(Connect.getInstance().GetMaxIDPost(), StartID, EndID, Time, Date);
        } else {
            postList = Connect.getInstance().SearchPost(ID, StartID, EndID, Time, Date);
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


    public List<Post> getAllPost() {
        List<Post> list = null;
        list = ConnectAdmin.getInstance().getAllPost();
        for (int i = 0; i < list.size(); i++) {
            User user = Connect.getInstance().GetUser("-1", list.get(i).getUserID());
            list.get(i).setUser(user);
            list.get(i).setDateTime(FormatDateTime(list.get(i).getDateTime()));
            list.get(i).setDate(Format(list.get(i).getDate()));
            String[] startAddress = handleString(Connect.getInstance().GetAddress(list.get(i).getStartAddress()));
            String[] endAddress = handleString(Connect.getInstance().GetAddress(list.get(i).getEndAddress()));
            list.get(i).setStartCommune(startAddress[0]);
            list.get(i).setStartDistrict(startAddress[1]);
            list.get(i).setStartProvince(startAddress[2]);
            list.get(i).setEndCommune(endAddress[0]);
            list.get(i).setEndDistrict(endAddress[1]);
            list.get(i).setEndProvince(endAddress[2]);
        }
        return list;
    }

    public Post getPost(int id) {
        List<Post> list = null;
        list = ConnectAdmin.getInstance().getAllPost();
        Post post = new Post();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID() == id) {
                User user = Connect.getInstance().GetUser("-1", list.get(i).getUserID());
                list.get(i).setUser(user);
                list.get(i).setDateTime(FormatDateTime(list.get(i).getDateTime()));
                list.get(i).setDate(Format(list.get(i).getDate()));
                String[] startAddress = handleString(Connect.getInstance().GetAddress(list.get(i).getStartAddress()));
                String[] endAddress = handleString(Connect.getInstance().GetAddress(list.get(i).getEndAddress()));
                list.get(i).setStartCommune(startAddress[0]);
                list.get(i).setStartDistrict(startAddress[1]);
                list.get(i).setStartProvince(startAddress[2]);
                list.get(i).setEndCommune(endAddress[0]);
                list.get(i).setEndDistrict(endAddress[1]);
                list.get(i).setEndProvince(endAddress[2]);
                post = list.get(i);
            }

        }
        return post;
    }

    public List<Post> getPostByFind(String key) {
        List<Post> list = new ArrayList<>();
        for (Post p : PostBO.getInstance().getAllPost()) {
            if (String.valueOf(p.getUserID()).toUpperCase().trim().contains(key.toUpperCase().trim())
                    || String.valueOf(p.getID()).toUpperCase().trim().contains(key.toUpperCase().trim())) {
                list.add(p);
            }
        }
        return list;
    }

    public boolean DeletePost(String idPost) {
        return Connect.getInstance().deletePost(idPost);
    }

    public boolean newRequest(Request requestPost) {
        int ID = Connect.getInstance().getRequestID(requestPost.getPostID(), requestPost.getSenderID());
        if (ID == -1) {
            return false;
        } else {
            requestPost.setID(ID);
            return Connect.getInstance().newRequest(requestPost);
        }

    }


    public List<Request> getRequestSend(String userID) {
        List<Request> requests = new ArrayList<>();
        for (Request i : Connect.getInstance().getRequestSend(userID)) {
            i.setDatetime(FormatDateTime(i.getDatetime()));
            i.setPost(getInstance().getPost(i.getPostID()));
            requests.add(i);
        }

        return requests;
    }

    public List<Request> getRequestReceive(String userID) {
        List<Request> requests = new ArrayList<>();
        for (Request i : Connect.getInstance().getRequestReceive(userID)) {
            i.setDatetime(FormatDateTime(i.getDatetime()));
            i.setPost(getInstance().getPost(i.getPostID()));
            requests.add(i);
        }

        return requests;
    }


    public void confirmRequest(String status, String requestID) {
        Connect.getInstance().confirmRequest(status, requestID);
    }

    public String checkRequest(String newRequest) {
        if (Connect.getInstance().checkRequest(newRequest)) {
            return "true";
        } else {
            return "false";
        }
    }

    public List<Request> getRequestWithPost(int id) {
        List<Request> requests = new ArrayList<>();
        for (Request i : ConnectAdmin.getInstance().getRequestWithPost(id)) {
            i.setDatetime(FormatDateTime(i.getDatetime()));
            requests.add(i);
        }

        return requests;
    }
}
