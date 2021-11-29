package Controller.Admin;

import Model.BEAN.User;
import Model.BO.AddressBO;
import Model.BO.AuthBO;
import Model.BO.UploadImage;
import Model.BO.UserForAdmin_BO;

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

@WebServlet(value = "/ViewUserForAdmin")
@MultipartConfig
public class ViewUserForAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("userID") != null) {
            User user = UserForAdmin_BO.getInstance().getUserbyID(request.getParameter("userID"));
            request.setAttribute("Permission", AuthBO.getInstance().checkSignUp(user.getAccountID()));
            request.setAttribute("User", user);
            request.setAttribute("Tinhs", AddressBO.getInstance().getTinh());
            request.setAttribute("Address", AddressBO.getInstance().getAddress(user.getAddress()));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/AccountDetail.jsp");
            requestDispatcher.forward(request, response);
            return;
        }

        request.setAttribute("listUser", UserForAdmin_BO.getInstance().GetListUserForAdminList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/list_Account.jsp");
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
        String permission = request.getParameter("permission");
        String submitRegister = request.getParameter("submitRegister");
        String userID = request.getParameter("userID");

        if (submitRegister.equals("Cập nhật")) {
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
                request.setAttribute("Permission", AuthBO.getInstance().checkSignUp(user.getAccountID()));
                request.setAttribute("User", user);
                request.setAttribute("Tinhs", AddressBO.getInstance().getTinh());
                request.setAttribute("Address", AddressBO.getInstance().getAddress(user.getAddress()));
                request.setAttribute("Mess", ints);
                RequestDispatcher rd = request.getRequestDispatcher("/view/admin/AccountDetail.jsp");
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
            user.setPhone_Number(phone);
            user.setAge(age);
            user.setSex(sex);
            user.setStatus(status.trim());
            user.setAccountID(user_name);
            user.setAddress(address);
            user.setPermission(Integer.parseInt(permission));
            user.setAvatar(avatar);

            UserForAdmin_BO.getInstance().UpdateUser(user);

            request.setAttribute("listUser", UserForAdmin_BO.getInstance().GetListUserForAdminList());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/list_Account.jsp");
            requestDispatcher.forward(request, response);

        } else {
            List<String> strings = new ArrayList<>();
            strings.add(userID);
            UserForAdmin_BO.getInstance().DelUser(strings);
            request.setAttribute("listUser", UserForAdmin_BO.getInstance().GetListUserForAdminList());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/list_Account.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}
