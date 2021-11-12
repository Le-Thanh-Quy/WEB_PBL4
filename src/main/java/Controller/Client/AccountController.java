package Controller.Client;

import Model.BEAN.Assess;
import Model.BEAN.User;
import Model.BO.AuthBO;
import Model.DAO.Connect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "account", value = "/account")
public class AccountController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name = (String) request.getSession().getAttribute("user");
        User user = AuthBO.getInstance().GetUser(user_name);
        Assess assess = AuthBO.getInstance().GetAssess(user.getAssessID());
        request.setAttribute("user", user);
        request.setAttribute("assess", assess);
        request.setAttribute("address", AuthBO.getInstance().GetAddress(user.getAddress()));

        RequestDispatcher rd = request.getRequestDispatcher("/view/account.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
