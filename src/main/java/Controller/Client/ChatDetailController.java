package Controller.Client;

import Model.BEAN.ChatRoom;
import Model.BO.ChatBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chatDetail")
public class ChatDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String RoomID = request.getParameter("RoomID");
        String myID = request.getParameter("myID");

        if(RoomID.equals("Admin")){
            request.setAttribute("admin" , true);
            int roomIDAdmin = ChatBO.getInstance().getIDRoomChatAdmin(myID);
            if(roomIDAdmin != -1){
                request.setAttribute("listMess" , ChatBO.getInstance().getListMess(String.valueOf(roomIDAdmin)));
                request.setAttribute("chatRoom" , ChatBO.getInstance().getChatRoomByID(String.valueOf(roomIDAdmin), myID));
            }else{
                request.setAttribute("myID" , myID);
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/chat_detail.jsp");
            requestDispatcher.forward(request , response);
        }else{
            request.setAttribute("admin" , false);
            request.setAttribute("listMess" , ChatBO.getInstance().getListMess(RoomID));
            request.setAttribute("chatRoom" , ChatBO.getInstance().getChatRoomByID(RoomID , myID));

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/chat_detail.jsp");
            requestDispatcher.forward(request , response);
        }


    }
}
