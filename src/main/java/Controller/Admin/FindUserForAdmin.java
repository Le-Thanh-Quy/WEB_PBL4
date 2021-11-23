package Controller.Admin;

import Model.BEAN.UserForAdmin;
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
        String key = (String) request.getParameter("searchBox");
        String phan_quyen = (String) request.getParameter("phan_quyen");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        List<UserForAdmin> list = new ArrayList<>();
        if(key!=null){
            list = UserForAdmin_BO.getInstance().FindUser(key);
        }
        if(!phan_quyen.equals("3")){
            list = UserForAdmin_BO.getInstance().FindUser(phan_quyen);
        }
        json = new Gson().toJson(list);
        response.getWriter().write(json);
    }
}
