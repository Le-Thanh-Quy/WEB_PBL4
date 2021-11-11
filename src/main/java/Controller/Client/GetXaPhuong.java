package Controller.Client;


import Model.BO.AddressBO;
import Model.DAO.Connect;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getXaPhuong")
public class GetXaPhuong extends HttpServlet {
    public GetXaPhuong() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String json = null;
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        json = new Gson().toJson( AddressBO.getInstance().getXa(id));
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
