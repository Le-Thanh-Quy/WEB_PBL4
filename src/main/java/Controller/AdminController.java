package Controller;

import Model.BO.AuthBO;
import Model.BO.UserForAdmin_BO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/admin_home")
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if("true".equals(request.getParameter("logout"))){
            HttpSession session = request.getSession();
            session.removeAttribute("admin");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }else{
            request.setAttribute("user_name" , request.getSession().getAttribute("admin"));
            request.setAttribute("user_info" , UserForAdmin_BO.getInstance().getUser());
            RequestDispatcher rd = request.getRequestDispatcher("view/admin/admin_home.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
