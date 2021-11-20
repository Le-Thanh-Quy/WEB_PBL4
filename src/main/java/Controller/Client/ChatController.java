package Controller.Client;

import Model.BEAN.Chat;
import Model.BO.ChatBO;
import Model.BO.PostBO;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/chat")
public class ChatController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int my_userID;
        int their_userID = -1;
        if (request.getAttribute("myID") == null) {
            my_userID = Integer.parseInt(request.getParameter("myID"));
            if (request.getParameter("theirID") != null) {
                their_userID = Integer.parseInt(request.getParameter("theirID"));
            }

        } else {
            my_userID = (int) request.getAttribute("myID");
            if (request.getAttribute("theirID") != null) {
                their_userID = Integer.parseInt((String) request.getAttribute("theirID"));
            }
        }
        if (their_userID != -1) {
            int RoomID = ChatBO.getInstance().CreateRoomChat(my_userID, their_userID);
            if (RoomID != -1) {
                request.setAttribute("RoomID", RoomID);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("Mess", "Tạo tin nhắn không thành công!");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
                return;
            }

        }

        request.setAttribute("myID", my_userID);
        request.setAttribute("ListChatRoom", ChatBO.getInstance().getListChatRoom(my_userID + ""));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/chat.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String myID = request.getParameter("myID");
        if (request.getParameter("searchContent") != null) {
            String searchContent = request.getParameter("searchContent");

            String json = null;
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            json = new Gson().toJson(ChatBO.getInstance().getListChatRoomWithName(myID, searchContent));
            response.getWriter().write(json);
        }else{
            String json = null;
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            json = new Gson().toJson(ChatBO.getInstance().getListChatRoom(myID));
            response.getWriter().write(json);
        }

    }
}
