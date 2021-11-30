package Model.DAO;

import Model.BEAN.*;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectAdmin {
    private static ConnectAdmin instance;

    public static ConnectAdmin getInstance() {
        if (instance == null) {
            instance = new ConnectAdmin();
        }
        return instance;
    }

    public Connection con;

    public ConnectAdmin() {
        this.con = Connect.getInstance().con;
    }

    public List<Post> getAllPost() {
        List<Post> list = new ArrayList<Post>();
        try {
            String sql = "SELECT * FROM post";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
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

    public List<User> GetListUserForAdminList() {
        List<User> userForAdminList = new ArrayList<>();
        try {
            String str = "SELECT *FROM pbl4.user";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
                User user = new User();
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

                userForAdminList.add(user);
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

    public boolean AddAssess(int idAssess) {
        try {
            String str = "INSERT INTO assess VALUES ('" + idAssess + "', '0', '0');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
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
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
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

    public List<String> GetIDAssessAndIDAccountToDel(String id) {
        List<String> list = new ArrayList<>();
        try {
            String str = "SELECT * FROM user WHERE ID = '" + id + "';";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
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
            String str1 = "DELETE FROM account WHERE (UserName = '" + list.get(1) + "');";
            String str2 = "DELETE FROM assess WHERE (ID = '" + list.get(0) + "');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str1);
            statement.executeUpdate(str2);
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
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;

            if (resultSet.next()) {
                id = resultSet.getInt("matp");
            }
            resultSet.close();
            statement.close();
            String idString = String.valueOf(id + 1);
            return idString;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public boolean addProvince(Tinh tinh) {
        try {
            String str = "INSERT INTO tinh VALUES ('" + tinh.getMatp() + "', '" + tinh.getName() + "', '" + tinh.getType() + "', '" + tinh.getSlug() + "');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteProvince(String id) {
        try {
            String str = "DELETE FROM tinh WHERE (matp = '" + id + "');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
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
            String str = "SELECT * from tinh WHERE matp = " + idProvince + ";";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
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
            String str = "UPDATE tinh SET matp = '" + matp + "', name = '" + name + "', type = '" + type + "', slug = '" + slug + "' WHERE (matp = '" + matp + "');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
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
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            while (resultSet.next()) {
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
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;

            if (resultSet.next()) {
                id = resultSet.getInt("maqh");
            }
            resultSet.close();
            statement.close();
            String idString = String.valueOf(id + 1);
            return idString;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public boolean addDistrict(Huyen huyen) {
        try {
            String str = "INSERT INTO huyen VALUES ('" + huyen.getMaqh() + "', '" + huyen.getName() + "', '" + huyen.getType() + "', '" + huyen.getMatp() + "');";
            System.out.println(str);
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
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
            String str = "SELECT * from huyen WHERE maqh = " + idDistrict + ";";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
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
            String str = "UPDATE huyen SET maqh = '" + maqh + "', name = '" + name + "', type = '" + type + "', matp = '" + matp + "' WHERE (maqh = '" + maqh + "');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteDistrict(String id) {
        try {
            String str = "DELETE FROM huyen WHERE (maqh = '" + id + "');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
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
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            int id = 0;

            if (resultSet.next()) {
                id = resultSet.getInt("xaid");
            }
            resultSet.close();
            statement.close();
            String idString = String.valueOf(id + 1);
            return idString;
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public boolean addCommune(XaPhuong xaPhuong) {
        try {
            String str = "INSERT INTO xaphuong VALUES ('" + xaPhuong.getXaid() + "', '" + xaPhuong.getName() + "', '" + xaPhuong.getType() + "', '" + xaPhuong.getMaqh() + "');";
            System.out.println(str);
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
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
            String str = "SELECT * from xaphuong WHERE xaid = " + idCommune + ";";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
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
            String str = "UPDATE xaphuong SET xaid = '" + xaid + "', name = '" + name + "', type = '" + type + "', maqh = '" + maqh + "' WHERE (xaid = '" + xaid + "');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteCommune(String id) {
        try {
            String str = "DELETE FROM xaphuong WHERE (xaid = '" + id + "');";
            Statement statement = con.createStatement();
            statement.executeUpdate(str);
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public ArrayList<Report> getAllReport() {
        ArrayList<Report> list = new ArrayList<Report>();
        try {
            String sql = "SELECT * FROM report";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Report report = new Report();
                report.setID(resultSet.getInt("ID"));
                report.setUserReportID(resultSet.getInt("UserReportID"));
                report.setUserViolateID(resultSet.getInt("UserViolateID"));
                report.setContent(resultSet.getString("Content"));
                report.setTime(resultSet.getString("Time"));
                report.setStatus(resultSet.getBoolean("Status"));
                report.setFeedback(resultSet.getString("Feedback"));
                list.add(report);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get report by ID_report
    public Report getReportByID(int ID_report) {
        Report report = new Report();
        try {
            String sql = "SELECT * FROM report WHERE  ID = '" + ID_report + "' ;";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                report.setID(resultSet.getInt("ID"));
                report.setUserReportID(resultSet.getInt("UserReportID"));
                report.setUserViolateID(resultSet.getInt("UserViolateID"));
                report.setContent(resultSet.getString("Content"));
                report.setTime(resultSet.getString("Time"));
                report.setStatus(resultSet.getBoolean("Status"));
                report.setFeedback(resultSet.getString("Feedback"));
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return report;
    }

    //update tinh trang report
    public boolean updateReport(int ID, String feedback) {
        try {
            String sql = "UPDATE report set Status = '" + 1 + "' ,Feedback = '" + feedback + "' WHERE ID = '" + ID + "' ;";
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean UpdateUser(User user) {
        try {
            String sql = "UPDATE user set Name = '" + user.getName() +
                    "' ,Age = '" + user.getAge() +
                    "' ,Sex = '" + user.getSex() +
                    "' ,PhoneNumber = '" + user.getPhone_Number() +
                    "' ,Avatar = '" + user.getAvatar() +
                    "' ,Status = '" + user.getStatus() +
                    "' ,Address = '" + user.getAddress() +
                    "' WHERE ID = '" + user.getID() + "' ;";
            String sql1 = "UPDATE account set Permission = b'" + user.getPermission() +
                    "' WHERE UserName = '" + user.getAccountID() + "' ;";
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.executeUpdate(sql1);
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public boolean noiReport() {
        try {
            String str = "SELECT * from report WHERE  Status = '0';";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
                resultSet.close();
                statement.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
