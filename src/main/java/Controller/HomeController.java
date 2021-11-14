package Controller;

import Model.BEAN.User;
import Model.BO.AddressBO;
import Model.BO.AuthBO;
import Model.BO.PostBO;

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
        if(!"null".equals(Mess)){
            request.setAttribute("Mess" , Mess);
        }
        String checkNewPost = "";
        checkNewPost = (String) session.getAttribute("checkNewPost");


        if("oke".equals(checkNewPost)){
            request.setAttribute("checkNewPost" , "block");
        }
        else {
            request.setAttribute("checkNewPost" , "none");
        }

        session.removeAttribute("checkNewPost");

        boolean login = false;
        String user_name = "";
        if(session.getAttribute("logged") != null){
            login = (boolean) session.getAttribute("logged");
            user_name = session.getAttribute("user").toString();
        }

        if(login){
            User user = new AuthBO().GetUser(user_name);
            request.setAttribute("user" , user_name);
            request.setAttribute("logged" , true);
            request.setAttribute("user_info" , user);

        }else{
            request.setAttribute("Mess" , Mess);
            request.setAttribute("user" , "Đăng Nhập|Đăng Ký");
            request.setAttribute("logged" , false);
        }
        request.setAttribute("ListPost" , PostBO.getInstance().getPostList(-1));
        request.setAttribute("Tinhs" , AddressBO.getInstance().getTinh());
        RequestDispatcher rd = request.getRequestDispatcher("/view/home.jsp");
        rd.forward(request, response);
    }

}
