package Model.DAO;

import Model.BEAN.*;
import Model.BO.CommentBO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connect {
    private static Connect instance;

    public static Connect getInstance() {
        if (instance == null) {
            instance = new Connect();
        }
        return instance;
    }

    public Connection con;

    public Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pbl4", "root", "1111");
            System.out.println("Successs");
            Statement statement = con.createStatement();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public List<Tinh> getTinh() {
        List<Tinh> tinhs = new ArrayList<Tinh>();
        try {
            String str = "SELECT * FROM tinh;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                String matp = resultSet.getString("matp");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String slug = resultSet.getString("slug");
                Tinh tinh = new Tinh(matp, name, type, slug);
                tinhs.add(tinh);
            }
            resultSet.close();
            statement.close();
            return tinhs;
        } catch (Exception e) {
            return tinhs;
        }
    }

    public List<Huyen> getHuyen(String idTinh) {
        List<Huyen> huyens = new ArrayList<Huyen>();
        try {
            String str = "SELECT * FROM huyen WHERE  matp = '" + idTinh + "';";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                String maqh = resultSet.getString("maqh");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String matp = resultSet.getString("matp");
                Huyen huyen = new Huyen(maqh, name, type, matp);
                huyens.add(huyen);
            }
            resultSet.close();
            statement.close();
            return huyens;
        } catch (Exception e) {
            return huyens;
        }

    }

    public List<XaPhuong> getXa(String idHuyen) {
        List<XaPhuong> xaPhuongs = new ArrayList<XaPhuong>();
        try {
            String str = "SELECT * FROM xaphuong WHERE  maqh = '" + idHuyen + "';";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                String xaid = resultSet.getString("xaid");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String maqh = resultSet.getString("maqh");
                XaPhuong xaPhuong = new XaPhuong(xaid, name, type, maqh);
                xaPhuongs.add(xaPhuong);
            }
            resultSet.close();
            statement.close();
            return xaPhuongs;
        } catch (Exception e) {
            return xaPhuongs;
        }

    }

    public int checkLogin(String Username, String Password) {
        try {
            String str = "SELECT * FROM account WHERE  UserName = '" + Username + "' and PassWord = '" + Password + "';";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int Permission = -1;
            if (resultSet.next()) {
                Permission = resultSet.getInt("Permission");
            }
            resultSet.close();
            statement.close();
            return Permission;

        } catch (Exception e) {
            return -1;
        }
    }

    public int checkSignUp(String Username) {
        try {
            String str = "SELECT * FROM account WHERE  UserName = '" + Username + "' ;";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int Permission = -1;
            if (resultSet.next()) {
                Permission = resultSet.getInt("Permission");
            }
            resultSet.close();
            statement.close();
            return Permission;

        } catch (Exception e) {
            return -1;
        }
    }

    public boolean Register(String Username, String PassWord) {
        try {
            String str = "INSERT INTO account VALUES('" + Username + "' , '" + PassWord + "' , 0) ;";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int GetIDAssess() {
        try {
            String str = "SELECT MAX(ID) from assess;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("MAX(ID)");
            }
            resultSet.close();
            statement.close();
            return id + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int GetMaxIDPost() {
        try {
            String str = "SELECT MAX(ID) from post;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("MAX(ID)");
            }
            resultSet.close();
            statement.close();
            return id + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int GetIDUser() {
        try {
            String str = "SELECT MAX(ID) from user;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("MAX(ID)");
            }
            resultSet.close();
            statement.close();
            return id + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void DeleteAccount(String user_name) {
        try {
            String str = "DELETE FROM account WHERE UserName = '" + user_name + "';";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
        } catch (Exception e) {

        }

    }


    public boolean AddUser(User user) {
        try {
            int IDAssess = GetIDAssess();
            if (IDAssess != -1) {
                String str = "INSERT INTO assess VALUES( " + IDAssess + ", 0 , 0) ;";
                Statement statement = con.createStatement();
                statement.executeUpdate(str);
                statement.close();

            } else {
                return false;
            }
            if (GetIDUser() != -1) {

                String str = "INSERT INTO user  VALUES ('" + GetIDUser() + "', '" + user.getName() + "', '" + user.getAge() + "', '" + user.getSex() + "' , '" + user.getPhone_Number() + "', '" + user.getAddress() + "', '" + user.getAvatar() + "', '" + user.getStatus() + "', '" + IDAssess + "', '" + user.getAccountID() + "');";
                Statement statement = con.createStatement();
                statement.executeUpdate(str);
                statement.close();
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User GetUser(String user_name, int ID) {
        User user = new User();
        try {
            String str;
            if ("-1".equals(user_name)) {
                str = "SELECT * FROM user WHERE  ID = '" + ID + "' ;";
            } else {
                str = "SELECT * FROM user WHERE  AccountID = '" + user_name + "' ;";
            }

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
                user.setID(resultSet.getInt("ID"));
                user.setName(resultSet.getString("Name"));
                user.setAge(resultSet.getString("Age"));
                user.setSex(resultSet.getString("Sex"));
                user.setPhone_Number(resultSet.getString("PhoneNumber"));
                user.setAddress(resultSet.getString("Address"));
                user.setAvatar(resultSet.getString("Avatar"));
                user.setStatus(resultSet.getString("Status"));
                user.setAssessID(resultSet.getInt("AssessID"));
                user.setAccountID(resultSet.getString("AccountID"));
            }
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean setAssess(Assess assess) {
        try {
            String str = "UPDATE assess SET Rate = '" + assess.getRate() +
                    "', Reviews = '" + assess.getReview() +
                    "' WHERE ID = " + assess.getID() + ";";

            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Assess GetAssess(int ID) {
        Assess assess = new Assess();
        try {
            String str = "SELECT * FROM assess WHERE  ID = '" + ID + "' ;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
                assess.setID(resultSet.getInt("ID"));
                assess.setRate(resultSet.getDouble("Rate"));
                assess.setReview(resultSet.getInt("Reviews"));
            }
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return assess;
    }

    public String GetAddress(String idXa) {
        String result = "";
        try {

            String str = "SELECT" +
                    "  xaphuong.name," +
                    "  huyen.name," +
                    "  tinh.name " +
                    "FROM xaphuong " +
                    "JOIN huyen " +
                    "  ON xaphuong.maqh = huyen.maqh " +
                    "JOIN tinh " +
                    "  ON tinh.matp = huyen.matp " +
                    "WHERE  xaid = '" + idXa + "';";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
                result += resultSet.getString("xaphuong.name") + ", ";
                result += resultSet.getString("huyen.name") + ", ";
                result += resultSet.getString("tinh.name");
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    public List<Post> postList(int ID, String Date) {
        List<Post> postList = new ArrayList<Post>();

        try {
            String str = "SELECT * FROM post WHERE ID < " + ID + " and Date >= '" + Date + "' ORDER BY ID DESC   LIMIT 5;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                Post post = new Post();
                post.setID(resultSet.getInt("ID"));
                post.setStartAddress(resultSet.getString("StartID"));
                post.setEndAddress(resultSet.getString("EndID"));
                post.setDateTime(resultSet.getString("Time"));
                post.setTimeStart(resultSet.getString("TimeStart"));
                post.setDate(resultSet.getString("Date"));
                post.setCaption(resultSet.getString("Caption"));
                post.setUserID(resultSet.getInt("UserID"));
                post.setImage(resultSet.getString("Image"));

                postList.add(post);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return postList;
    }

    public List<Post> postListWithUser(int ID, int IDUser) {
        List<Post> postList = new ArrayList<Post>();

        try {
            String str = "SELECT * FROM post WHERE ID < " + ID + " and UserID = " + IDUser + " ORDER BY ID DESC   LIMIT 5;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                Post post = new Post();
                post.setID(resultSet.getInt("ID"));
                post.setStartAddress(resultSet.getString("StartID"));
                post.setEndAddress(resultSet.getString("EndID"));
                post.setDateTime(resultSet.getString("Time"));
                post.setTimeStart(resultSet.getString("TimeStart"));
                post.setDate(resultSet.getString("Date"));
                post.setCaption(resultSet.getString("Caption"));
                post.setUserID(resultSet.getInt("UserID"));
                post.setImage(resultSet.getString("Image"));

                postList.add(post);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return postList;
    }

    public boolean AddNewPost(Post post) {
        try {
            int ID = GetMaxIDPost();
            if (ID == -1) {
                return false;
            }
            String str = "INSERT INTO post VALUES('" + ID + "' , '" + post.getUserID() +
                    "' , '" + post.getStartAddress() +
                    "' , '" + post.getEndAddress() +
                    "' , '" + post.getDateTime() +
                    "' , '" + post.getTimeStart() +
                    "' , '" + post.getDate() +
                    "' , '" + post.getCaption() +
                    "' , '" + post.getImage() + "') ;";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Post> SearchPost(int ID, String StartID, String EndID, String Time, String Date) {
        List<Post> postList = new ArrayList<Post>();

        try {
            String str = "SELECT * FROM post WHERE StartID = '" + StartID + "' and EndID = '" + EndID +
                    "' and TimeStart = '" + Time + "' and Date = '" + Date + "' and ID < " + ID +
                    " ORDER BY ID DESC   LIMIT 5;";
            if (StartID.equals("null")) {
                str = str.replace("StartID = '" + StartID + "' and", "");
            }
            if (EndID.equals("null")) {
                str = str.replace("EndID = '" + EndID + "' and", "");
            }
            if (Time.equals("null")) {
                str = str.replace("TimeStart = '" + Time + "' and", "");
            }
            if (Date.equals("null")) {
                str = str.replace("Date = '" + Date + "' and", "");
            }
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                Post post = new Post();
                post.setID(resultSet.getInt("ID"));
                post.setStartAddress(resultSet.getString("StartID"));
                post.setEndAddress(resultSet.getString("EndID"));
                post.setDateTime(resultSet.getString("Time"));
                post.setTimeStart(resultSet.getString("TimeStart"));
                post.setDate(resultSet.getString("Date"));
                post.setCaption(resultSet.getString("Caption"));
                post.setUserID(resultSet.getInt("UserID"));
                post.setImage(resultSet.getString("Image"));

                postList.add(post);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return postList;
    }

    public List<ChatRoom> getListChatRoom(String idUser) {
        List<ChatRoom> chatRoomList = new ArrayList<ChatRoom>();

        try {
            String str = "SELECT * FROM chatroom WHERE UserID1 = " + idUser + " or UserID2 = " + idUser + " order by ID DESC ;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                ChatRoom chatRoom = new ChatRoom();
                chatRoom.setID(resultSet.getInt("ID"));
                chatRoom.setUserID1(resultSet.getInt("UserID1"));
                chatRoom.setUserID2(resultSet.getInt("UserID2"));
                chatRoom.setStatusU1(resultSet.getBoolean("StatusU1"));
                chatRoom.setStatusU2(resultSet.getBoolean("StatusU2"));
                chatRoomList.add(chatRoom);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chatRoomList;
    }

    public ChatRoom getChatRoomByID(String id) {
        ChatRoom chatRoom = new ChatRoom();

        try {
            String str = "SELECT * FROM chatroom WHERE ID = " + id + ";";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                chatRoom.setID(resultSet.getInt("ID"));
                chatRoom.setUserID1(resultSet.getInt("UserID1"));
                chatRoom.setUserID2(resultSet.getInt("UserID2"));
                chatRoom.setStatusU1(resultSet.getBoolean("StatusU1"));
                chatRoom.setStatusU2(resultSet.getBoolean("StatusU2"));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chatRoom;
    }

    public int getChatID() {
        try {
            String str = "SELECT MAX(ID) from chat;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("MAX(ID)");
            }
            resultSet.close();
            statement.close();
            return id + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getCommentID() {
        try {
            String str = "SELECT MAX(ID) from comment;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("MAX(ID)");
            }
            resultSet.close();
            statement.close();
            return id + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getRequestID(int postID, int senderID) {
        try {
            String str = "SELECT ID from request WHERE  SenderID = '" + senderID + "' and PostID = '" + postID + "';";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = -1;
            if (resultSet.next()) {
                id = resultSet.getInt("ID");
            }
            resultSet.close();
            statement.close();
            if(id != -1){
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        try {
            String str = "SELECT MAX(ID) from request;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("MAX(ID)");
            }
            resultSet.close();
            statement.close();
            return id + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean addChat(Chat chat) {
        try {
            String str = "INSERT INTO chat VALUES('" + chat.getID() +
                    "', '" + chat.getChatRoomID() + "', '" + chat.getUserID() +
                    "', '" + chat.getMessenger() + "', '" + chat.getTime() + "') ;";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addComment(Comment comment) {
        try {
            String str = "INSERT INTO comment VALUES('" + comment.getID() +
                    "', '" + comment.getPostID() + "', '" + comment.getUserID() +
                    "', '" + comment.getContent() + "', '" + comment.getTime() + "') ;";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Chat> getListChat(String roomID) {
        List<Chat> chatList = new ArrayList<Chat>();
        try {
            String str = "SELECT * FROM chat WHERE ChatRoomID = " + roomID + ";";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                Chat chat = new Chat();
                chat.setID(resultSet.getInt("ID"));
                chat.setChatRoomID(resultSet.getInt("ChatRoomID"));
                chat.setUserID(resultSet.getInt("UserID"));
                chat.setMessenger(resultSet.getString("Messenger"));
                chat.setTime(resultSet.getString("Time"));
                chatList.add(chat);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chatList;
    }

    public int getRoomChatID() {
        try {
            String str = "SELECT MAX(ID) from chatroom;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("MAX(ID)");
            }
            resultSet.close();
            statement.close();
            return id + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean addRoomChat(int id, int my_userID, int their_userID) {
        try {
            String str = "INSERT INTO chatroom VALUES('" + id + "', '" + my_userID + "', '" + their_userID + "' , '1' , '1');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int checkRoomChatExist(int my_userID, int their_userID) {
        try {
            String str = "SELECT ID FROM chatroom WHERE (UserID1 = " + my_userID + " and UserID2 = " + their_userID +
                    " ) or (UserID2 = " + my_userID + " and UserID1 = " + their_userID + ");";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = -1;
            if (resultSet.next()) {
                id = resultSet.getInt("ID");
            }
            resultSet.close();
            statement.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public boolean sendStatus(ChatRoom chatRoom) {
        try {
            int statusU1 = chatRoom.isStatusU1() ? 1 : 0;
            int statusU2 = chatRoom.isStatusU2() ? 1 : 0;
            String str = "UPDATE chatroom SET StatusU1 = '" + statusU1 +
                    "', StatusU2 = '" + statusU2 +
                    "' WHERE ID = " + chatRoom.getID() + ";";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Comment> getListComment(int postID) {
        List<Comment> comments = new ArrayList<Comment>();
        try {
            String str = "SELECT * FROM comment WHERE PostID = " + postID + ";";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setID(resultSet.getInt("ID"));
                comment.setPostID(resultSet.getInt("PostID"));
                comment.setUserID(resultSet.getInt("UserID"));
                comment.setContent(resultSet.getString("Comment"));
                comment.setTime(resultSet.getString("Time"));

                comments.add(comment);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public Interact checkInteractID(String myID, String theirID) {
        Interact interact = new Interact();
        interact.setID(-1);
        try {
            String str = "SELECT * from interact WHERE (UserID1 = " + myID + " and UserID2 = " + theirID +
                    ") or (UserID1 = " + theirID + " and UserID2 = " + myID + ");";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
                interact.setID(resultSet.getInt("ID"));
                interact.setUserID1(resultSet.getInt("UserID1"));
                interact.setUserID2(resultSet.getInt("UserID2"));
                interact.setRankUser1(resultSet.getInt("User1ToUser2"));
                interact.setRankUser2(resultSet.getInt("User2ToUser1"));
            }
            resultSet.close();
            statement.close();
            return interact;
        } catch (Exception e) {
            e.printStackTrace();
            return interact;
        }
    }

    public int getInteractID() {
        try {
            String str = "SELECT MAX(ID) from interact;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("MAX(ID)");
            }
            resultSet.close();
            statement.close();
            return id + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean setInteractID(Interact interact, int ID) {
        try {
            String str = "";
            if (ID == -1) {
                str = "UPDATE interact SET User1ToUser2 = '" + interact.getRankUser1() +
                        "', User2ToUser1 = '" + interact.getRankUser2() +
                        "' WHERE ID = " + interact.getID() + ";";
            } else {
                str = "INSERT INTO interact VALUES('" + interact.getID() +
                        "', '" + interact.getUserID1() +
                        "', '" + interact.getUserID2() +
                        "' , '" + interact.getRankUser1() +
                        "' , '" + interact.getRankUser2() + "');";
            }

            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public int getReportID() {
        try {
            String str = "SELECT MAX(ID) from report;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;
            if (resultSet.next()) {
                id = resultSet.getInt("MAX(ID)");
            }
            resultSet.close();
            statement.close();
            return id + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean addReport(int id, String myID, String theirID, String content, String format) {
        try {
            String str = "INSERT INTO report VALUES ('" + id + "', '" + myID + "', '" + theirID + "', '" + content + "', '" + format + "', '0', '');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePost(String postID) {
        try {
            String str = "DELETE FROM post WHERE (`ID` = '" + postID + "');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Report> getListReport(int id) {
        List<Report> reports = new ArrayList<Report>();
        try {
            String str = "SELECT * from report WHERE UserReportID = '" + id + "';";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                Report report = new Report();
                report.setID(resultSet.getInt("ID"));
                report.setUserReportID(resultSet.getInt("UserReportID"));
                report.setUserViolateID(resultSet.getInt("UserViolateID"));
                report.setContent(resultSet.getString("Content"));
                report.setTime(resultSet.getString("Time"));
                report.setStatus(resultSet.getBoolean("Status"));
                report.setFeedback(resultSet.getString("Feedback"));
                reports.add(report);
            }
            resultSet.close();
            statement.close();
            return reports;
        } catch (Exception e) {
            e.printStackTrace();
            return reports;
        }
    }

    public boolean newRequest(Request requestPost) {
        try {
            String str = "INSERT INTO request VALUES ('" + requestPost.getID() + "', '" + requestPost.getSenderID() + "', '" + requestPost.getReceiverID() + "', '" + requestPost.getPostID() + "', '" + requestPost.getContent() + "', '0');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
