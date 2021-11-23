package Controller.Admin;

import Model.BO.UserForAdmin_BO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ViewUserForAdmin")
public class ViewUserForAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", UserForAdmin_BO.getInstance().GetListUserForAdminList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/list_Account.jsp");
        requestDispatcher.forward(request, response);
    }

}
