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
            con = DriverManager.getConnection("jdbc:mysql://localhost/pbl4", "root", "1111");
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

                String str = "INSERT INTO user  VALUES ('" + GetIDUser() + "', '" + user.Name + "', '" + user.Age + "', '" + user.Sex + "' , '" + user.Phone_Number + "', '" + user.Address + "', '" + user.Avatar + "', '" + user.Status + "', '" + IDAssess + "', '" + user.AccountID + "');";
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
    public User GetUser(String user_name){
        User user = new User();
        try {
            String str = "SELECT * FROM user WHERE  AccountID = '" + user_name + "' ;";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
                user.ID = resultSet.getInt("ID");
                user.Name = resultSet.getString("Name");
                user.Age = resultSet.getString("Age");
                user.Sex = resultSet.getString("Sex");
                user.Phone_Number = resultSet.getString("Phone Number");
                user.Address = resultSet.getString("Address");
                user.Avatar = resultSet.getString("Avatar");
                user.Status = resultSet.getString("Status");
                user.AssessID = resultSet.getInt("AssessID");
                user.AccountID = resultSet.getString("AccountID");
            }
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public Assess GetAssess(int ID){
        Assess assess = new Assess();
        try {
            String str = "SELECT * FROM assess WHERE  ID = '" + ID + "' ;";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);
            if (resultSet.next()) {
                assess.ID = resultSet.getInt("ID");
                assess.Rate = resultSet.getInt("Rate");
                assess.Review = resultSet.getInt("Reviews");
            }
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return assess;
    }
    public String GetAddress(String idXa){
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


}
