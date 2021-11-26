package Controller.Admin;

import Model.BO.PostBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/ViewPost")
public class viewPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listPost", PostBO.getInstance().getAllPost());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/list_Post.jsp");
        requestDispatcher.forward(request, response);
    }
}
