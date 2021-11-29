package Controller.Client;

import Model.BEAN.Assess;
import Model.BEAN.Post;
import Model.BEAN.User;
import Model.BO.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/updateAccount")
@MultipartConfig
public class UpdateAccountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserForAdmin_BO.getInstance().getUserbyID(request.getParameter("userID"));
        request.setAttribute("User", user);
        request.setAttribute("Tinhs", AddressBO.getInstance().getTinh());
        request.setAttribute("Address", AddressBO.getInstance().getAddress(user.getAddress()));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/update_account.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String user_name = request.getParameter("user_txt");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        String userID = request.getParameter("userID");

        if (request.getParameter("submitRegister") != null) {
            List<Integer> ints = new ArrayList<>();
            if (name.trim().equals("")) {
                ints.add(1);
            }
            if (phone.trim().equals("")) {
                ints.add(2);
            }
            if (address.equals("Xã/Phường")) {
                ints.add(3);
            }
            if (status.trim().equals("")) {
                ints.add(4);
            }
            if (ints.size() != 0) {
                User user = UserForAdmin_BO.getInstance().getUserbyID(userID);
                request.setAttribute("User", user);
                request.setAttribute("Tinhs", AddressBO.getInstance().getTinh());
                request.setAttribute("Address", AddressBO.getInstance().getAddress(user.getAddress()));
                request.setAttribute("Mess", ints);
                RequestDispatcher rd = request.getRequestDispatcher("view/update_account.jsp");
                rd.forward(request, response);
                return;
            }


            Part filePart = request.getPart("avatar");
            InputStream is = filePart.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            String avatar = "https://drive.google.com/uc?export=view&id=1sAFmlSiwY_fporn9AdbnhUp3KTe5tL24";
            try {

                String nameIMG = user_name;
                avatar = UploadImage.getInstance().UpLoadImage(buffer, "1JUy7im4fXDgBkY5cr9NzheZ3WxO_l87m", nameIMG);
            } catch (Exception e) {
                avatar = request.getParameter("avatarIMG");
            }
            User user = new User();
            user.setID(Integer.parseInt(userID));
            user.setName(name.trim());
            user.setPhone_Number(phone.trim());
            user.setAge(age);
            user.setSex(sex);
            user.setStatus(status.trim());
            user.setAddress(address);
            user.setAvatar(avatar);

            AuthBO.getInstance().UpdateUser(user);

            User user1 = UserForAdmin_BO.getInstance().getUserbyID(userID);
            request.setAttribute("User", user1);
            request.setAttribute("Tinhs", AddressBO.getInstance().getTinh());
            request.setAttribute("Address", AddressBO.getInstance().getAddress(user1.getAddress()));
            request.setAttribute("Mess", ints);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/update_account.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setCharacterEncoding("UTF-8");
            String userName = request.getParameter("user_name");
            String passWord = request.getParameter("pass_old");
            String newPassWord = request.getParameter("pass_new");
            if(AuthBO.getInstance().changePassWord(userName , passWord , newPassWord)){
                request.setAttribute("Mess", "Mật khẩu đã được thay đổi!");

                User myAccount = AuthBO.getInstance().GetUser(userName);
                List<Post> postList = PostBO.getInstance().getPostListWithUser(-1, myAccount.getID());
                Assess assess = AuthBO.getInstance().GetAssess(myAccount.getAssessID());
                request.setAttribute("ListPost", postList);
                request.setAttribute("myAccount", myAccount);
                request.setAttribute("user", myAccount);
                request.setAttribute("assess", assess);
                request.setAttribute("address", AuthBO.getInstance().GetAddress(myAccount.getAddress()));
                RequestDispatcher rd = request.getRequestDispatcher("/view/account.jsp");
                rd.forward(request, response);

            }else{

                request.setAttribute("Mess", "Thay đổi mật khẩu không thành công!");


                User myAccount = AuthBO.getInstance().GetUser(userName);
                List<Post> postList = PostBO.getInstance().getPostListWithUser(-1, myAccount.getID());
                Assess assess = AuthBO.getInstance().GetAssess(myAccount.getAssessID());
                request.setAttribute("ListPost", postList);
                request.setAttribute("myAccount", myAccount);
                request.setAttribute("user", myAccount);
                request.setAttribute("assess", assess);
                request.setAttribute("address", AuthBO.getInstance().GetAddress(myAccount.getAddress()));
                RequestDispatcher rd = request.getRequestDispatcher("/view/account.jsp");
                rd.forward(request, response);
            }

        }
    }
}
