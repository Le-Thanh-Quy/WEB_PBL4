package Controller.Client;

import Model.BEAN.Request;
import Model.BO.PostBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/request")
public class RequestController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String content = request.getParameter("content");
        String senderID = request.getParameter("senderID");
        String receiverID = request.getParameter("receiverID");
        String postID = request.getParameter("postID");

        Request requestPost = new Request();
        requestPost.setPostID(Integer.parseInt(postID));
        requestPost.setSenderID(Integer.parseInt(senderID));
        requestPost.setContent(content);
        requestPost.setReceiverID(Integer.parseInt(receiverID));
        requestPost.setStatus(0);

        if(PostBO.getInstance().newRequest(requestPost)){
            HttpSession session = request.getSession();
            session.setAttribute("Mess", "Yêu cầu đã được gửi và đang chờ phản hồi!");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("Mess", "Gửi yêu cầu không thành công!");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
