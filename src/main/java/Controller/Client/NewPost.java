package Controller.Client;

import Model.BEAN.Post;
import Model.BO.UploadImage;
import Model.BO.PostBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/newPost")
@MultipartConfig
public class NewPost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Part filePart = request.getPart("description_img");
        String userID = request.getParameter("userID");
        String start_newPost = request.getParameter("start_newPost");
        String end_newPost = request.getParameter("end_newPost");
        String time_newPost = request.getParameter("time_newPost");
        String date_newPost = request.getParameter("date_newPost");
        String caption = request.getParameter("caption_newPost");


        InputStream is = filePart.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        Post post = new Post();
        post.setUserID(Integer.parseInt(userID));
        post.setStartAddress(start_newPost);
        post.setEndAddress(end_newPost);
        post.setTimeStart(time_newPost);
        post.setDate(date_newPost);
        post.setCaption(caption);
        try {

            String nameIMG = userID + start_newPost + end_newPost + time_newPost + date_newPost;
            post.setImage(UploadImage.getInstance().UpLoadImage(buffer , "1R7tDcyA3VsrhC96aIe26BqZxPO_fq65w" , nameIMG));
        } catch (Exception e) {
            post.setImage("https://drive.google.com/uc?export=view&id=1D6_ppd3c4eTf20RRSFy51mPF6t6UAZh7");
        }


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
