package Controller.Admin;


import Model.BEAN.User;
import Model.BO.UserForAdmin_BO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/FindUserForAdmin")
public class FindUserForAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = null;
        String key = request.getParameter("searchBox");
        String permission = request.getParameter("permission");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        List<User> list = new ArrayList<>();
        if(key!=null){
            list = UserForAdmin_BO.getInstance().FindUser(key , true);
        }
        if(!permission.equals("3")){
            list = UserForAdmin_BO.getInstance().FindUser(permission , false);
        }
        json = new Gson().toJson(list);
        response.getWriter().write(json);
    }
}
