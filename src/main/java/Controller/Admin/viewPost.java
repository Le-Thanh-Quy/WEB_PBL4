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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("postSearch") != null){
            String key = request.getParameter("postSearch");
            if(key.trim().equals("")){
                doGet(request ,response);
            }else{
                request.setAttribute("listPost", PostBO.getInstance().getPostByFind(key));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/list_Post.jsp");
                requestDispatcher.forward(request, response);
            }
        }else{
            doGet(request,response);
        }

    }
}
