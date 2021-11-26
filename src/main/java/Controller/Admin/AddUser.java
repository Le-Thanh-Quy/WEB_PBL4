package Controller.Admin;

import Model.BO.UserForAdmin_BO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/AddUser.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Name = (String) req.getParameter("Name");
        String Age = (String) req.getParameter("Age");
        String Sex = (String) req.getParameter("Sex");
        String PhoneNumber = (String) req.getParameter("PhoneNumber");
        String Address = (String) req.getParameter("Address");
        String Status = (String) req.getParameter("Status");
        String UserName = (String) req.getParameter("UserName");
        String PassWord = (String) req.getParameter("PassWord");
        String Permission = (String) req.getParameter("Permission");
        String Avatar = "https://drive.google.com/uc?export=view&id=1sAFmlSiwY_fporn9AdbnhUp3KTe5tL24";

        int IDAssess = UserForAdmin_BO.getInstance().GetIDAssess();
        int IDUser = UserForAdmin_BO.getInstance().getIDUser();

        if(UserForAdmin_BO.getInstance().AddAssess(IDAssess)==true){
            if(UserForAdmin_BO.getInstance().AddAccount(UserName, PassWord, Permission)==true){
                if (UserForAdmin_BO.getInstance().AddUser(IDUser, Name, Age, Sex, PhoneNumber, Address, Avatar, Status, IDAssess, UserName)==true){
                    req.setAttribute("listUser", UserForAdmin_BO.getInstance().GetListUserForAdminList());
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/admin/list_Account.jsp");
                    requestDispatcher.forward(req, resp);
                }
            }
        }
    }
}
