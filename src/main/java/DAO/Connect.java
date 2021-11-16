package DAO;

import BEAN.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Connect {
    private static Connect instance;

    public static Connect getInstance() {
        if (instance == null) {
            instance = new Connect();
        }
        return instance;
    }

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/admin", "root", "mysql");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public int getMaxIDChatRoom(){
        try {
            String sql = "SELECT MAX(chatroomID) from chatroom;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            int id=0;
            if(resultSet.next()){
                id = resultSet.getInt("MAX(chatroomID)");
            }
            statement.close();
            resultSet.close();
            return id+1;
        }catch (Exception e){
            return -1;
        }
    }

    public int getMaxIDChat(){
        try {
            String sql = "SELECT MAX(chatID) from chat;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            int id=0;
            if(resultSet.next()){
                id = resultSet.getInt("MAX(chatID)");
            }
            statement.close();
            resultSet.close();
            return id+1;
        }catch (Exception e){
            return -1;
        }
    }

    public boolean addChatRoom(int userID1, int userID2){
        try {
            String sql = "INSERT INTO chatroom VALUES ('"+ getMaxIDChatRoom() +"', '"+userID1+"', '"+userID2+"');";
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public  boolean addChat( int ChatRoomID, int userID, String messenger, String time){
        try {
            String sql = "INSERT INTO chat VALUES ('"+ getMaxIDChat() +"', '"+ ChatRoomID+"', '"+userID+"', '"+messenger+"', '"+time+"');";
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Messenger> ShowMessenger(int ChatRoomID){
        List<Messenger> list = new ArrayList<>();
        try {

            String sql = "SELECT chat.UserID, chat.Messenger, chat.Time " +
                    "FROM chat " +
                    "INNER JOIN chatroom ON chat.ChatroomID = chatroom.ChatroomID WHERE chat.ChatroomID="+ChatRoomID+";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            Messenger messenger;
            while (resultSet.next()){
                messenger = new Messenger(resultSet.getInt("UserID"),
                        resultSet.getString("Messenger"),
                        resultSet.getString("Time"));
                list.add(messenger);
            }
            statement.close();
            resultSet.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }
    }

    public int checkChatRoom(int userID1, int userID2){
        try {
            int ChatRoomID=-1;
            String sql = "SELECT * FROM admin.chatroom where userID1="+userID1+" and userID2="+userID2+";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                ChatRoomID = resultSet.getInt("chatroomID");
                statement.close();
                resultSet.close();
                return ChatRoomID;
            }

            String sql1 = "SELECT * FROM admin.chatroom where userID1="+userID2+" and userID2="+userID1+";";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql1);
            if(resultSet.next()){
                ChatRoomID = resultSet.getInt("chatroomID");
                statement.close();
                resultSet.close();
                return ChatRoomID;
            }
            return ChatRoomID;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
