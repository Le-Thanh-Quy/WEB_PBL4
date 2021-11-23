package Model.DAO;

import Model.BEAN.*;


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
    public Statement statement;
    public ResultSet resultSet;

    public Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pbl4", "root", "mysql");
            System.out.println("Successs");
            statement = con.createStatement();
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
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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

            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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

            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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
            statement = con.createStatement();
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
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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
            statement = con.createStatement();
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
                statement = con.createStatement();
                statement.executeUpdate(str);
                statement.close();

            } else {
                return false;
            }
            if (GetIDUser() != -1) {

                String str = "INSERT INTO user  VALUES ('" + GetIDUser() + "', '" + user.getName() + "', '" + user.getAge() + "', '" + user.getSex() + "' , '" + user.getPhone_Number() + "', '" + user.getAddress() + "', '" + user.getAvatar() + "', '" + user.getStatus() + "', '" + IDAssess + "', '" + user.getAccountID() + "');";
                statement = con.createStatement();
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

            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
                user.setID(resultSet.getInt("ID"));
                user.setName(resultSet.getString("Name"));
                user.setAge(resultSet.getString("Age"));
                user.setSex(resultSet.getString("Sex"));
                user.setPhone_Number(resultSet.getString("Phone Number"));
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

    public Assess GetAssess(int ID) {
        Assess assess = new Assess();
        try {
            String str = "SELECT * FROM assess WHERE  ID = '" + ID + "' ;";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
                assess.setID(resultSet.getInt("ID"));
                assess.setRate(resultSet.getInt("Rate"));
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
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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
            statement = con.createStatement();
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
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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

    //các chức năng trang admin...................M vieets owr ddaay nghe............................................
    //Lấy all post
    public List<Post> getAllPost() {
        List<Post> list = new ArrayList<Post>();
        try {
            String sql = "SELECT * FROM post";
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Post post = new Post();
                post.setID(resultSet.getInt("ID"));
                post.setUserID(resultSet.getInt("UserID"));
                post.setStartAddress(resultSet.getString("StartID"));
                post.setEndAddress(resultSet.getString("EndID"));
                post.setDateTime(resultSet.getString("Time"));
                post.setTimeStart(resultSet.getString("TimeStart"));
                post.setDate(resultSet.getString("Date"));
                post.setCaption(resultSet.getString("Caption"));
                post.setImage(resultSet.getString("Image"));

                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<UserForAdmin> GetListUserForAdminList() {
        List<UserForAdmin> userForAdminList = new ArrayList<>();
        try {
            String str = "SELECT *FROM pbl4.user" +
                    " INNER JOIN pbl4.assess" +
                    " ON pbl4.user.AssessID = pbl4.assess.ID" +
                    " INNER JOIN pbl4.account" +
                    " ON pbl4.user.AccountID = pbl4.account.UserName;";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                UserForAdmin userForAdmin = new UserForAdmin();
                userForAdmin.setID(resultSet.getInt("ID"));
                userForAdmin.setName(resultSet.getString("Name"));
                userForAdmin.setAge(resultSet.getString("Age"));
                userForAdmin.setSex(resultSet.getString("Sex"));
                userForAdmin.setRate(resultSet.getInt("Rate"));
                userForAdmin.setRoles(resultSet.getString("Permission"));

                userForAdminList.add(userForAdmin);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userForAdminList;
    }

    public int GetIDAccount() {
        try {
            String str = "SELECT MAX(ID) from account;";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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

    public boolean AddAssess(int idAssess) {
        try {
            String str = "INSERT INTO assess VALUES ('" + idAssess + "', '0', '0');";
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean AddAccount(String userName, String passWord, String permission) {
        try {
            String str = "INSERT INTO account VALUES ('" + userName + "', '" + passWord + "', b'" + permission + "');";
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getIDUser() {
        try {
            String str = "SELECT MAX(ID) from user;";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
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

    public List<String> GetIDAssessAndIDAccountToDel(String id){
        List<String > list = new ArrayList<>();
        try {
            String str = "SELECT * FROM user WHERE ID = '"+id+"';";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            if(resultSet.next()){
                list.add(resultSet.getString("AssessID"));
                list.add(resultSet.getString("AccountID"));
            }
            resultSet.close();
            statement.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
    }

    public boolean DelUser(String id) {
        try {
            List<String> list = GetIDAssessAndIDAccountToDel(id);
            String str1 = "DELETE FROM account WHERE (UserName = '"+list.get(1)+"');";
            String str2 = "DELETE FROM assess WHERE (ID = '"+list.get(0)+"');";
            String str = "DELETE FROM user WHERE (ID = '"+id+"');";
            statement = con.createStatement();
            statement.executeUpdate(str);
            statement.executeUpdate(str1);
            statement.executeUpdate(str2);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getIDProvince() {
        try {
            String str = "SELECT * FROM tinh ORDER BY matp DESC LIMIT 1;";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            int id = 0;

            if (resultSet.next()) {
                id = resultSet.getInt("matp");
            }
            resultSet.close();
            statement.close();
            String idString = String.valueOf(id+1);
            return idString;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public boolean addProvince(Tinh tinh) {
        try {
            String str = "INSERT INTO tinh VALUES ('" + tinh.getMatp() + "', '"+tinh.getName()+"', '"+tinh.getType()+"', '"+tinh.getSlug()+"');";
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteProvince(String id) {
        try {
            String str = "DELETE FROM tinh WHERE (matp = '"+id+"');";
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Tinh getProvinceByID(String idProvince) {
        Tinh tinh = new Tinh();
        try {
            String str = "SELECT * from tinh WHERE matp = "+idProvince+";";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            if(resultSet.next()){
                tinh = new Tinh(resultSet.getString("matp"), resultSet.getString("name"), resultSet.getString("type"), resultSet.getString("slug"));

            }
            resultSet.close();
            statement.close();
            return tinh;
        } catch (Exception e) {
            e.printStackTrace();
            return tinh;
        }
    }

    public boolean UpdateProvince(String matp, String name, String type, String slug) {
        try {
            String str = "UPDATE tinh SET matp = '"+matp+"', name = '"+name+"', type = '"+type+"', slug = '"+slug+"' WHERE (matp = '"+matp+"');";
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getAllIDProv() {
        List<String> lisID = new ArrayList<>();
        try {
            String str = "SELECT matp from tinh;";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            while (resultSet.next()){
                lisID.add(resultSet.getString("matp"));
            }
            resultSet.close();
            statement.close();
            return lisID;
        } catch (Exception e) {
            e.printStackTrace();
            return lisID;
        }
    }

    public String getIDDistrict() {
        try {
            String str = "SELECT * FROM huyen ORDER BY maqh DESC LIMIT 1;";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            int id = 0;

            if (resultSet.next()) {
                id = resultSet.getInt("maqh");
            }
            resultSet.close();
            statement.close();
            String idString = String.valueOf(id+1);
            return idString;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public boolean addDistrict(Huyen huyen) {
        try {
            String str = "INSERT INTO huyen VALUES ('" + huyen.getMaqh() + "', '"+huyen.getName()+"', '"+huyen.getType()+"', '"+huyen.getMatp()+"');";
            System.out.println(str);
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Huyen getDistrictByID(String idDistrict) {
        Huyen huyen = new Huyen();
        try {
            String str = "SELECT * from huyen WHERE maqh = "+idDistrict+";";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            if(resultSet.next()){
                huyen = new Huyen(resultSet.getString("maqh"), resultSet.getString("name"), resultSet.getString("type"), resultSet.getString("matp"));

            }
            resultSet.close();
            statement.close();
            return huyen;
        } catch (Exception e) {
            e.printStackTrace();
            return huyen;
        }
    }

    public boolean UpdateDistrict(String maqh, String name, String type, String matp) {
        try {
            String str = "UPDATE huyen SET maqh = '"+maqh+"', name = '"+name+"', type = '"+type+"', matp = '"+matp+"' WHERE (maqh = '"+maqh+"');";
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteDistrict(String id) {
        try {
            String str = "DELETE FROM huyen WHERE (maqh = '"+id+"');";
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getIDCommune() {
        try {
            String str = "SELECT * FROM xaphuong ORDER BY xaid DESC LIMIT 1;";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            int id = 0;

            if (resultSet.next()) {
                id = resultSet.getInt("xaid");
            }
            resultSet.close();
            statement.close();
            String idString = String.valueOf(id+1);
            return idString;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public boolean addCommune(XaPhuong xaPhuong) {
        try {
            String str = "INSERT INTO xaphuong VALUES ('" + xaPhuong.getXaid() + "', '"+xaPhuong.getName()+"', '"+xaPhuong.getType()+"', '"+xaPhuong.getMaqh()+"');";
            System.out.println(str);
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public XaPhuong getCommuneByID(String idCommune) {
        XaPhuong xaPhuong = new XaPhuong();
        try {
            String str = "SELECT * from xaphuong WHERE xaid = "+idCommune+";";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            if(resultSet.next()){
                xaPhuong = new XaPhuong(resultSet.getString("xaid"), resultSet.getString("name"), resultSet.getString("type"), resultSet.getString("maqh"));

            }
            resultSet.close();
            statement.close();
            return xaPhuong;
        } catch (Exception e) {
            e.printStackTrace();
            return xaPhuong;
        }
    }

    public boolean UpdateCommune(String xaid, String name, String type, String maqh) {
        try {
            String str = "UPDATE xaphuong SET xaid = '"+xaid+"', name = '"+name+"', type = '"+type+"', maqh = '"+maqh+"' WHERE (xaid = '"+xaid+"');";
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteCommune(String id) {
        try {
            String str = "DELETE FROM xaphuong WHERE (xaid = '"+id+"');";
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeletePost(String idPost) {
        try {
            String str = "DELETE FROM post WHERE (id = '"+idPost+"');";
            statement = con.createStatement();
            statement.executeUpdate(str);
            resultSet.close();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
