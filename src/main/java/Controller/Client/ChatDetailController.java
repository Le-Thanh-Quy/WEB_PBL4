package Controller.Client;


import Model.BO.ChatBO;

import Model.BO.UploadImage;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/chatDetail")
@MultipartConfig
public class ChatDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String RoomID = request.getParameter("RoomID");
        String myID = request.getParameter("myID");

        request.setAttribute("myID", myID);
        request.setAttribute("RoomID", RoomID);

        if (RoomID.equals("Admin")) {
            request.setAttribute("admin", true);
            int roomIDAdmin = ChatBO.getInstance().getIDRoomChatAdmin(myID);
            if (roomIDAdmin != -1) {
                request.setAttribute("listMess", ChatBO.getInstance().getListMess(String.valueOf(roomIDAdmin)));
                request.setAttribute("chatRoom", ChatBO.getInstance().getChatRoomByID(String.valueOf(roomIDAdmin), myID));
            } else {
                request.setAttribute("myID", myID);
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/chat_detail.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("admin", false);
            request.setAttribute("listMess", ChatBO.getInstance().getListMess(RoomID));
            request.setAttribute("chatRoom", ChatBO.getInstance().getChatRoomByID(RoomID, myID));

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/chat_detail.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String RoomID = request.getParameter("RoomID");
        String myID = request.getParameter("myID");

        Part filePart = request.getPart("img");
        InputStream is = filePart.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        String id = "";
        try {
            String nameIMG = "my:"+myID+"_room"+RoomID;
            id = UploadImage.getInstance().UpLoadImage(buffer, "1YyanNlLgq2aLRTNnem7TjY3lpKqCKSt2", nameIMG);
        } catch (Exception e) {
            return;
        }

        request.setAttribute("imgID" , id);
        if (RoomID.equals("Admin")) {
            request.setAttribute("admin", true);
            int roomIDAdmin = ChatBO.getInstance().getIDRoomChatAdmin(myID);
            if (roomIDAdmin != -1) {
                request.setAttribute("listMess", ChatBO.getInstance().getListMess(String.valueOf(roomIDAdmin)));
                request.setAttribute("chatRoom", ChatBO.getInstance().getChatRoomByID(String.valueOf(roomIDAdmin), myID));
            } else {
                request.setAttribute("myID", myID);
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/chatImg.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("admin", false);
            request.setAttribute("listMess", ChatBO.getInstance().getListMess(RoomID));
            request.setAttribute("chatRoom", ChatBO.getInstance().getChatRoomByID(RoomID, myID));

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/chatImg.jsp");
            requestDispatcher.forward(request, response);

        }
    }
}
