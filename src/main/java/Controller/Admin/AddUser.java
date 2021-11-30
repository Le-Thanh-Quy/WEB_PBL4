package Controller.Admin;

import Model.BO.AddressBO;
import Model.BO.UploadImage;
import Model.BO.UserForAdmin_BO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddUser")
@MultipartConfig
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("Tinhs", AddressBO.getInstance().getTinh());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/AddUser.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String Name = (String) request.getParameter("Name");
        String Age = (String) request.getParameter("Age");
        String Sex = (String) request.getParameter("Sex");
        String PhoneNumber = (String) request.getParameter("PhoneNumber");
        String Address = (String) request.getParameter("Address");
        String Status = (String) request.getParameter("Status");
        String UserName = (String) request.getParameter("UserName");
        String PassWord = (String) request.getParameter("PassWord");
        String Permission = (String) request.getParameter("Permission");

        List<Integer> ints = new ArrayList<>();
        if (Name.trim().equals("")) {
            ints.add(1);
        }
        if(PhoneNumber.trim().equals("")){
            ints.add(2);
        } if(Address.equals("Xã/Phường")){
            ints.add(3);
        } if(Status.trim().equals("")) {
            ints.add(4);
        }
        if(Status.trim().equals("")) {
            ints.add(4);
        }
        if(UserName.trim().equals("")) {
            ints.add(5);
        }
        if(PassWord.trim().equals("")) {
            ints.add(6);
        }
        if(ints.size() != 0){
            request.setAttribute("Tinhs", AddressBO.getInstance().getTinh());
            request.setAttribute("Mess", ints);
            RequestDispatcher rd = request.getRequestDispatcher("/view/admin/AddUser.jsp");
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
        String Avatar = "https://drive.google.com/uc?export=view&id=1sAFmlSiwY_fporn9AdbnhUp3KTe5tL24";
        try {

            String nameIMG = UserName;
            Avatar = UploadImage.getInstance().UpLoadImage(buffer, "1JUy7im4fXDgBkY5cr9NzheZ3WxO_l87m", nameIMG);
        } catch (Exception e) {
            Avatar = request.getParameter("avatarIMG");
        }

        int IDAssess = UserForAdmin_BO.getInstance().GetIDAssess();
        int IDUser = UserForAdmin_BO.getInstance().getIDUser();

        if(UserForAdmin_BO.getInstance().AddAssess(IDAssess)){
            if(UserForAdmin_BO.getInstance().AddAccount(UserName, PassWord, Permission)){
                if (UserForAdmin_BO.getInstance().AddUser(IDUser, Name, Age, Sex, PhoneNumber, Address, Avatar, Status, IDAssess, UserName)){
                    request.setAttribute("listUser", UserForAdmin_BO.getInstance().GetListUserForAdminList());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/list_Account.jsp");
                    requestDispatcher.forward(request, response);
                    return;
                }
            }
        }
        request.setAttribute("Mess", "Tạo tài khoản không thành công!");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/admin/notification.jsp");
        requestDispatcher.forward(request, response);


    }
}
