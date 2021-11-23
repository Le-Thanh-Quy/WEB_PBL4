package Controller.Admin;

import Model.BO.UserForAdmin_BO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/DelUser")
public class DelUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String del = request.getParameter("del");
        if (del != null) {
            if(request.getParameterValues("cb")==null){
                request.setAttribute("listUser", UserForAdmin_BO.getInstance().GetListUserForAdminList());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/UIDelUser.jsp");
                requestDispatcher.forward(request, response);
                return;
            }
            List<String> listID = Arrays.asList(request.getParameterValues("cb"));
            for (String id : listID) {
                if(!UserForAdmin_BO.getInstance().DelUser(id)){
                    request.setAttribute("listUser", UserForAdmin_BO.getInstance().GetListUserForAdminList());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/UIDelUser.jsp");
                    requestDispatcher.forward(request, response);
                    return;
                }
            }
            request.setAttribute("listUser", UserForAdmin_BO.getInstance().GetListUserForAdminList());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/UIDelUser.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("listUser", UserForAdmin_BO.getInstance().GetListUserForAdminList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/UIDelUser.jsp");
        requestDispatcher.forward(request, response);
    }
}
