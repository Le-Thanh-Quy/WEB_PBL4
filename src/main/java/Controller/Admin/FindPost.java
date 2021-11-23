package Controller.Admin;

import Model.BO.Address_BO;
import Model.BO.PostBO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FindPost")
public class FindPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = null;
        String key = req.getParameter("searchBox");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        json = new Gson().toJson(PostBO.getInstance().getPostByFind(key));
        System.out.println(key+PostBO.getInstance().getPostByFind(key).size());
        resp.getWriter().write(json);
    }
}
