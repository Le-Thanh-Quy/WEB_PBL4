package Controller.Client;

import Model.BO.ChatBO;
import Model.BO.CommentBO;
import Model.BO.PostBO;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comment")
public class CommentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postID = request.getParameter("postID");
        String myID = request.getParameter("myID");


        request.setAttribute("listComment", CommentBO.getInstance().getListComment(Integer.parseInt(postID)));
        request.setAttribute("myID", myID);
        request.setAttribute("postID", postID);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/comment.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");

        String json = null;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        json = new Gson().toJson(CommentBO.getInstance().getUserByID(Integer.parseInt(userID)));
        response.getWriter().write(json);
    }
}

