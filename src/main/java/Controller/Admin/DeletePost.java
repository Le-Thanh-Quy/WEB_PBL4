package Controller.Admin;

import Model.BO.PostBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeletePost")
public class DeletePost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String IDPost = req.getParameter("IDPost");
        System.out.println("asdasdasd");
        if(!PostBO.getInstance().DeletePost(IDPost)){
            req.setAttribute("listPost", PostBO.getInstance().getAllPost());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/list_Post.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }
        req.setAttribute("listPost", PostBO.getInstance().getAllPost());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/list_Post.jsp");
        requestDispatcher.forward(req, resp);
    }
}
