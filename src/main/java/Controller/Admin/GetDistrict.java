package Controller.Admin;

import Model.BO.AddressBO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetDistrict")
public class GetDistrict extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = null;
        String key = req.getParameter("IDProv");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        json = new Gson().toJson(AddressBO.getInstance().getAllDistrict(key));
        resp.getWriter().write(json);
    }
}
