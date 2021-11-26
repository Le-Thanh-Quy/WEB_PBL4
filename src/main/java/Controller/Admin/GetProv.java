package Controller.Admin;

import Model.BO.AddressBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getProv")
public class GetProv extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listProv", AddressBO.getInstance().getAllProv());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/UIUpdateAddress.jsp");
        requestDispatcher.forward(request, response);

    }
}
