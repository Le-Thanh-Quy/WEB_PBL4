//package Controller.Auth;
//
//import Model.BO.AuthBO;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/checkLogin")
//public class CheckLogin extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        int check = 0;
//        if(password.equals("")){
//            check = AuthBO.getInstance().checkSignUp(username);
//        }else{
//            check = AuthBO.getInstance().checkLogin(username , password);
//        }
//
//        String result = "" + check;
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(result);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request , response);
//    }
//}
