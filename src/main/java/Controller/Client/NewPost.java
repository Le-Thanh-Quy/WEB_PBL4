package Controller.Client;

import Model.BEAN.Post;
import Model.BO.PostBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/newPost")
public class NewPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String start_newPost = request.getParameter("start_newPost");
        String end_newPost = request.getParameter("end_newPost");
        String time_newPost = request.getParameter("time_newPost");
        String date_newPost = request.getParameter("date_newPost");
        String caption = request.getParameter("caption_newPost");
        String image = request.getParameter("img_newPost");


        Post post = new Post();
        post.setUserID(Integer.parseInt(userID));
        post.setStartAddress(start_newPost);
        post.setEndAddress(end_newPost);
        post.setTimeStart(time_newPost);
        post.setDate(date_newPost);
        post.setCaption(caption);
        post.setImage(image);

        if(PostBO.getInstance().AddNewPost(post)){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("Mess", "Đăng tải lịch trình không thành công!");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

    }
}
