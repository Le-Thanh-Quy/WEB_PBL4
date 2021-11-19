package Model.BO;

import Model.BEAN.Post;
import Model.BEAN.User;
import Model.DAO.Connect;

import java.time.LocalDateTime;
import java.util.Calendar;
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

    public int[] NextDay(int manyDay , int Day , int Month , int Year){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, manyDay);
        int NextDay = calendar.getTime().getDate();
        if(NextDay > Day){
            Day = NextDay;
        }else{
            Day = NextDay;
            if(Month == 12){
                Month = 1;
                Year += 1;
            }else{
                Month += 1;
            }
        }
        int[] Date = new int[3];
        Date[0] = Day;
        Date[1] = Month;
        Date[2] = Year;
        return Date;
    }
    public String DateSearch(String Date){
        String resultDate = "";
        LocalDateTime now = LocalDateTime.now();

        int Day = now.getDayOfMonth();
        int Month = now.getMonthValue();
        int Year = now.getYear();
        if(Date.equals("0")){
            resultDate = Year + "-" + Month + '-' + Day;
        }else  if(Date.equals("1")){
            Day = NextDay(1 , Day , Month , Year)[0];
            Month = NextDay(1 , Day , Month , Year)[1];
            Year = NextDay(1 , Day , Month , Year)[2];
            resultDate = Year + "-" + Month + '-' + Day;
        }else  if(Date.equals("2")){
            Day = NextDay(2 , Day , Month , Year)[0];
            Month = NextDay(2 , Day , Month , Year)[1];
            Year = NextDay(2 , Day , Month , Year)[2];
            resultDate = Year + "-" + Month + '-' + Day;
        }else  if(Date.equals("3")){
            Day = NextDay(3 , Day , Month , Year)[0];
            Month = NextDay(3 , Day , Month , Year)[1];
            Year = NextDay(3 , Day , Month , Year)[2];
            resultDate = Year + "-" + Month + '-' + Day;
        }else  if(Date.equals("4")){
            Day = NextDay(4 , Day , Month , Year)[0];
            Month = NextDay(4 , Day , Month , Year)[1];
            Year = NextDay(4 , Day , Month , Year)[2];
            resultDate = Year + "-" + Month + '-' + Day;
        }else  if(Date.equals("5")){
            Day = NextDay(5 , Day , Month , Year)[0];
            Month = NextDay(5 , Day , Month , Year)[1];
            Year = NextDay(5 , Day , Month , Year)[2];
            resultDate = Year + "-" + Month + '-' + Day;
        }
        return  resultDate;
    }

    public List<Post> SearchPost(int ID ,  String StartID , String EndID , String Time , String Date){
        List<Post> postList = null;
        if(StartID.equals("")){
            StartID = "null";
        }
        if(EndID.equals("")){
            EndID = "null";
        }
        if(Time.equals("Thời gian khởi hành")){
            Time = "null";
        }
        if(Date.equals("Ngày khởi hành")){
            Date = "null";
        }else{
            Date = DateSearch(Date);
        }
        if (ID == -1) {
            postList = Connect.getInstance().SearchPost(Connect.getInstance().GetMaxIDPost(), StartID , EndID , Time , Date);
        } else {
            postList = Connect.getInstance().SearchPost(ID,  StartID , EndID , Time , Date);
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
}
