package Controller;


import Model.BEAN.Assess;
import Model.BO.AddressBO;
import Model.BO.AuthBO;
import Model.BO.PostBO;
import Model.DAO.Connect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "trangchu", urlPatterns = {"/trangchu"})
public class HomeController extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session =  request.getSession();
        String Mess = (String) session.getAttribute("Mess");
        session.removeAttribute("Mess");
        boolean login = false;
        String user = "";
        if(session.getAttribute("logged") != null){
            login = (boolean) session.getAttribute("logged");
            user = session.getAttribute("user").toString();
        }

        if(login){
            request.setAttribute("user" , user);
            request.setAttribute("logged" , true);
        }else{
            request.setAttribute("Mess" , Mess);
            request.setAttribute("user" , "Đăng Nhập|Đăng Ký");
            request.setAttribute("logged" , false);
        }
        request.setAttribute("ListPost" , PostBO.getInstance().getAllPost());
        request.setAttribute("Tinhs" , AddressBO.getInstance().getTinh());
        RequestDispatcher rd = request.getRequestDispatcher("/view/home.jsp");
        rd.forward(request, response);
    }
}
