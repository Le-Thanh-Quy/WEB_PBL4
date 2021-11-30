package Controller.Admin;

import Model.BO.PostBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postDetail")
public class PostDetail extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postID = request.getParameter("postID");
        if(PostBO.getInstance().DeletePost(postID)){
            RequestDispatcher requestDispatcherss = request.getRequestDispatcher("ViewPost");
            requestDispatcherss.forward(request, response);
        }else{
            request.setAttribute("Mess", "Xóa không thành công!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/notification.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("postID");
        request.setAttribute("Post" , PostBO.getInstance().getPost(Integer.parseInt(id)));
        RequestDispatcher requestDispatcherss = request.getRequestDispatcher("/view/admin/postDetail.jsp");
        requestDispatcherss.forward(request, response);
    }
}
