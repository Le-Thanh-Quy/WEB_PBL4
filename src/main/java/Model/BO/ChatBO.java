package Model.BO;

import Model.BEAN.Chat;
import Model.BEAN.ChatRoom;
import Model.BEAN.User;
import Model.DAO.Connect;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatBO {
    private static ChatBO instance;

    public static ChatBO getInstance() {
        if (instance == null) {
            instance = new ChatBO();
        }
        return instance;
    }

    private ChatBO() {
    }

    public List<ChatRoom> getListChatRoom(String IDUser) {
        List<ChatRoom> chatRoomList = Connect.getInstance().getListChatRoom(IDUser);
        User myUser = Connect.getInstance().GetUser("-1", Integer.parseInt(IDUser));
        for (ChatRoom i : chatRoomList) {
            if (String.valueOf(i.getUserID1()).equals(IDUser)) {
                i.setMyUser(myUser);
                i.setMyStatus(i.isStatusU1());
                i.setTheirUser(Connect.getInstance().GetUser("-1", i.getUserID2()));
            } else {
                i.setMyStatus(i.isStatusU2());
                i.setTheirUser(Connect.getInstance().GetUser("-1", i.getUserID1()));
                i.setMyUser(myUser);
            }
        }
        return chatRoomList;
    }

    public List<ChatRoom> getListChatRoomWithName(String myID, String searchContent) {
        if(searchContent.trim().equals("")){
            return getListChatRoom(myID);
        }
        List<ChatRoom> chatRoomList = new ArrayList<ChatRoom>();
        for (ChatRoom i : getListChatRoom(myID)) {
            if(i.getTheirUser().getName().toLowerCase().contains(searchContent.toLowerCase())){
                chatRoomList.add(i);
            }
        }
        return  chatRoomList;
    }

    public ChatRoom getChatRoomByID(String ID, String myID) {
        ChatRoom chatRoom = Connect.getInstance().getChatRoomByID(ID);
        User myUser = Connect.getInstance().GetUser("-1", Integer.parseInt(myID));
        if (String.valueOf(chatRoom.getUserID1()).equals(myID)) {
            chatRoom.setMyUser(myUser);
            chatRoom.setMyStatus(chatRoom.isStatusU1());
            chatRoom.setTheirUser(Connect.getInstance().GetUser("-1", chatRoom.getUserID2()));
        } else {
            chatRoom.setMyStatus(chatRoom.isStatusU2());
            chatRoom.setTheirUser(Connect.getInstance().GetUser("-1", chatRoom.getUserID1()));
            chatRoom.setMyUser(myUser);
        }

        return chatRoom;
    }

    public String GetDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public int addChat(Chat chat) {
        int ID = Connect.getInstance().getChatID();
        if (ID == -1) {
            return -1;
        }
        chat.setID(ID);
        if (Connect.getInstance().addChat(chat)) {
            return ID;
        } else {
            return -1;
        }
    }

    public String FormatTime(String time) {
        String dateTime;
        String[] strings1 = time.split(" ");
        String[] stringDate = strings1[0].split("-");
        String[] stringTime = strings1[1].split(":");
        dateTime = stringDate[2] + "-" + stringDate[1] + "-" + stringDate[0] + " lúc " + stringTime[0] + ":" + stringTime[1];
        return dateTime;
    }

    public List<Chat> getListMess(String roomID) {
        List<Chat> chatList = Connect.getInstance().getListChat(roomID);
        for (Chat i : chatList) {
            String time = FormatTime(i.getTime());
            i.setTime(time);
        }
        return chatList;
    }
    public int getIDRoomChatAdmin(String myID) {
        return Connect.getInstance().checkRoomChatExist(Integer.parseInt(myID) , 0);
    }

    public int CreateRoomChat(int my_userID, int their_userID) {
        int IDRoom = Connect.getInstance().checkRoomChatExist(my_userID, their_userID);
        if (IDRoom != -1) {
            return IDRoom;
        }
        int ID = Connect.getInstance().getRoomChatID();
        if (ID == -1) {
            return -1;
        }
        if (Connect.getInstance().addRoomChat(ID, my_userID, their_userID)) {
            Chat chat = new Chat();
            chat.setChatRoomID(ID);
            chat.setMessenger("Xin chào!");
            chat.setUserID(my_userID);
            chat.setTime(getInstance().GetDateTime());
            if (addChat(chat) != -1) {
                sendStatus(String.valueOf(ID) ,String.valueOf(my_userID));
                return ID;
            } else {
                return -1;
            }
        } else {
            return -1;
        }

    }
    public int CreateRoomChatAdmin(int my_userID,  String mess) {
        int IDRoom = Connect.getInstance().checkRoomChatExist(my_userID, 0);
        if (IDRoom != -1) {
            return IDRoom;
        }
        int ID = Connect.getInstance().getRoomChatID();
        if (ID == -1) {
            return -1;
        }
        if (Connect.getInstance().addRoomChat(ID, my_userID, 0)) {
            Chat chat = new Chat();
            chat.setChatRoomID(ID);
            chat.setMessenger(mess);
            chat.setUserID(my_userID);
            chat.setTime(getInstance().GetDateTime());
            if (addChat(chat) != -1) {
                sendStatus(String.valueOf(ID) ,String.valueOf(my_userID));
                return ID;
            } else {
                return -1;
            }
        } else {
            return -1;
        }

    }


    public boolean sendStatus(String id, String idUser) {
        ChatRoom chatRoom = getChatRoomByID(id , idUser);
        if(String.valueOf(chatRoom.getUserID1()).equals(idUser)){
            chatRoom.setStatusU2(false);
            chatRoom.setStatusU1(true);
        }else{
            chatRoom.setStatusU2(true);
            chatRoom.setStatusU1(false);
        }
        return Connect.getInstance().sendStatus(chatRoom);
    }
}
