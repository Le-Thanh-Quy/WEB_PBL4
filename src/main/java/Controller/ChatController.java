package Controller;

import BEAN.Chat;
import BEAN.Messenger;
import BO.ChatBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Controller")
public class ChatController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int userID1 = (int)req.getAttribute("userID1");
//        int userID2 = (int)req.getAttribute("userID2");
        int checkChatRoom = ChatBO.getInstance().checkChatRoom(2, 1);

        List<Messenger> messengerList = new ArrayList<>();

        if(checkChatRoom!=-1){
            messengerList = ChatBO.getInstance().ShowMessenger(checkChatRoom);
        }
        req.setAttribute("listMess", messengerList);
//        req.setAttribute("userID1", userID1);
//        req.setAttribute("userID2", userID2);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("UIChat.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
