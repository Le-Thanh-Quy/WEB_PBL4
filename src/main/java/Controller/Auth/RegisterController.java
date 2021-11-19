//package Controller.Auth;
//
//
//import Model.BEAN.User;
//import Model.BO.AddressBO;
//import Model.BO.AuthBO;
//import Model.BO.UploadImage;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@WebServlet(name = "register", value = "/register")
//@MultipartConfig
//public class RegisterController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        String user_name = request.getParameter("user_txt_singup");
//        String pass = request.getParameter("pass_txt_signup");
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        String sex = request.getParameter("sex");
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");
//        String status = request.getParameter("status");
//        String submitRegister = request.getParameter("submitRegister");
//
//
//
//        if ("".equals(submitRegister)) {
//            Part filePart = request.getPart("avatar");
//            InputStream is = filePart.getInputStream();
//            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//
//            int nRead;
//            byte[] data = new byte[16384];
//
//            while ((nRead = is.read(data, 0, data.length)) != -1) {
//                buffer.write(data, 0, nRead);
//            }
//            String avatar = "https://drive.google.com/uc?export=view&id=1sAFmlSiwY_fporn9AdbnhUp3KTe5tL24";
//            try {
//
//                String nameIMG = user_name;
//                avatar = UploadImage.getInstance().UpLoadImage(buffer , "1JUy7im4fXDgBkY5cr9NzheZ3WxO_l87m" , nameIMG);
//            } catch (Exception e) {
//                avatar = "https://drive.google.com/uc?export=view&id=1sAFmlSiwY_fporn9AdbnhUp3KTe5tL24";
//            }
//
//            List<Integer> ints = new ArrayList<>();
//            if (name.trim().equals("")) {
//                ints.add(1);
//            }
//            if(phone.trim().equals("")){
//                ints.add(2);
//            } if(address.equals("Xã/Phường")){
//                ints.add(3);
//            } if(status.trim().equals("")) {
//                ints.add(4);
//            }
//            if(ints.size() != 0){
//                request.setAttribute("user_name", user_name);
//                request.setAttribute("pass", pass);
//                request.setAttribute("Tinhs", AddressBO.getInstance().getTinh());
//                request.setAttribute("Mess", ints);
//                RequestDispatcher rd = request.getRequestDispatcher("/view/register.jsp");
//                rd.forward(request, response);
//                return;
//            }
//            int check = AuthBO.getInstance().checkSignUp(user_name);
//            if (check == -1) {
//                if (AuthBO.getInstance().Register(user_name, pass)) {
//
//                    User user = new User(0, name, age, sex, phone, address, avatar, status, 0, user_name);
//                    if (AuthBO.getInstance().AddUser(user)) {
//                        HttpSession session = request.getSession();
//                        session.setAttribute("user", user_name);
//                        session.setAttribute("logged", true);
//                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                        rd.forward(request, response);
//                        return;
//                    } else {
//                        AuthBO.getInstance().DeleteAccount(user_name);
//                        HttpSession session = request.getSession();
//                        session.setAttribute("Mess", "Đăng ký tài khoản không thành công!");
//                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                        rd.forward(request, response);
//                        return;
//                    }
//                } else {
//                    HttpSession session = request.getSession();
//                    session.setAttribute("Mess", "Đăng ký tài khoản không thành công!");
//                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                    rd.forward(request, response);
//                    return;
//                }
//            } else {
//                HttpSession session = request.getSession();
//                session.setAttribute("Mess", "Đăng ký tài khoản không thành công!");
//                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//                rd.forward(request, response);
//                return;
//            }
//        } else {
//            request.setAttribute("user_name", user_name);
//            request.setAttribute("pass", pass);
//            request.setAttribute("Tinhs", AddressBO.getInstance().getTinh());
//            RequestDispatcher rd = request.getRequestDispatcher("/view/register.jsp");
//            rd.forward(request, response);
//            return;
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//}
