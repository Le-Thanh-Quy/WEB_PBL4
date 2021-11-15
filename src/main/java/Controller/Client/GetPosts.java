package Controller.Client;

import Model.BO.AddressBO;
import Model.BO.PostBO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getPosts")
public class GetPosts extends HttpServlet {
    public GetPosts() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String userID = request.getParameter("userID");
        String json = null;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if ("null".equals(userID)) {
            json = new Gson().toJson(PostBO.getInstance().getPostList(Integer.parseInt(id)));
        } else {
            json = new Gson().toJson(PostBO.getInstance().getPostListWithUser(Integer.parseInt(id), Integer.parseInt(userID)));
        }

        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String search_Start = request.getParameter("search_Start");
        String search_End = request.getParameter("search_End");
        String Time = request.getParameter("Time");
        String Date = request.getParameter("Date");
        String json = null;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        json = new Gson().toJson(PostBO.getInstance().SearchPost(Integer.parseInt(id), search_Start, search_End, Time, Date));
        response.getWriter().write(json);
    }
}