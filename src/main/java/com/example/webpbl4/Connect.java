package com.example.webpbl4;

import Model.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connect {
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

    public String getNameTinh(String mtinh) {
        String matp = "";
        try {
            String str = "SELECT * FROM tinh WHERE matp = '" + mtinh + "';";
            statement = con.createStatement();
            resultSet = statement.executeQuery(str);

            while (resultSet.next()) {
                matp = resultSet.getString("matp");
            }
            resultSet.close();
            statement.close();
            return matp;
        } catch (Exception e) {
            return matp;
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
                Permission =  resultSet.getInt("Permission");
            }
            resultSet.close();
            statement.close();
            return Permission;

        } catch (Exception e) {
            return -1;
        }
    }
}
