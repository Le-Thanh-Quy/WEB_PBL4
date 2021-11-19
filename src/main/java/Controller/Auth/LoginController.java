//package Controller.Auth;
//
//import Model.BO.AuthBO;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet(name = "login", urlPatterns = {"/login"})
//public class LoginController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String user_txt = request.getParameter("user_txt");
//        String pass_txt = request.getParameter("pass_txt");
//        String checkNewPost = request.getParameter("checkNewPost");
//
//        int check = AuthBO.getInstance().checkLogin(user_txt, pass_txt);
//
//        if (check == 1) {
//            HttpSession session = request.getSession();
//            session.setAttribute("admin", user_txt);
//        } else if (check == 0) {
//            HttpSession session = request.getSession();
//            session.setAttribute("user", user_txt);
//            session.setAttribute("logged", true);
//            session.setAttribute("checkNewPost", checkNewPost);
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            rd.forward(request, response);
//        } else {
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            rd.forward(request, response);
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//}
