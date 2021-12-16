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

//        if(1 == 1){
//            request.getSession().setAttribute("admin", "LeThanhQuy");
//            RequestDispatcher requestDispatcherss = request.getRequestDispatcher("admin_home");
//            requestDispatcherss.forward(request, response);
//            return;
//        }


        HttpSession session = request.getSession();
        String Mess = (String) session.getAttribute("Mess");
        session.removeAttribute("Mess");
        if (!"null".equals(Mess)) {
            request.setAttribute("Mess", Mess);
        }
        String checkTypeLogin = (String) session.getAttribute("checkTypeLogin");
        String checkMessLogin = (String) session.getAttribute("checkMessLogin");

        if ("newPost".equals(checkTypeLogin)) {
            request.setAttribute("checkNewPost", "block");
        } else {
            request.setAttribute("checkNewPost", "none");
        }


        session.removeAttribute("checkTypeLogin");

        boolean login = false;
        String user_name = "";
        if (session.getAttribute("logged") != null) {
            login = (boolean) session.getAttribute("logged");
            user_name = session.getAttribute("user").toString();
        }

        if ("chat".equals(checkTypeLogin)) {
            User user = new AuthBO().GetUser(user_name);
            if (!checkMessLogin.equals(String.valueOf(user.getID()))) {
                request.setAttribute("myID", user.getID());
                if (!checkMessLogin.equals("null")) {
                    request.setAttribute("theirID", checkMessLogin);
                }
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("chat");
                requestDispatcher.forward(request, response);
                return;
            } else {
                request.setAttribute("Mess", "Không thể tạo tin nhắn với chính mình!");
            }
        }

        if ("comment".equals(checkTypeLogin)) {
            request.setAttribute("postCommentID", checkMessLogin);
        }
        if ("report".equals(checkTypeLogin)) {
            User user = new AuthBO().GetUser(user_name);
            if (checkMessLogin.equals(String.valueOf(user.getID()))) {
                request.setAttribute("Mess", "Không thể báo cáo chính mình!");
            } else {
                String postID = (String)request.getSession().getAttribute("postID");
                request.setAttribute("reportID", checkMessLogin);
                request.setAttribute("postID" , postID);
            }
        }


        if (login) {
            User user = new AuthBO().GetUser(user_name);
            request.setAttribute("user", user_name);
            request.setAttribute("logged", true);
            request.setAttribute("user_info", user);

        } else {
            request.setAttribute("Mess", Mess);
            request.setAttribute("user", "Đăng Nhập|Đăng Ký");
            request.setAttribute("logged", false);
        }
        request.setAttribute("PostType", "Lịch trình mới nhất");
        request.setAttribute("ListPost", PostBO.getInstance().getPostList(-1));
        request.setAttribute("Tinhs", AddressBO.getInstance().getTinh());
        RequestDispatcher rd = request.getRequestDispatcher("/view/home.jsp");
        rd.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String search_Start = request.getParameter("search_Start");
        String search_End = request.getParameter("search_End");
        String Time = request.getParameter("Time");
        String Date = request.getParameter("Date");

        if ("".equals(search_Start) && "".equals(search_End) &&
                "Thời gian khởi hành".equals(Time) && "Ngày khởi hành".equals(Date)) {
            doGet(request, response);
        } else {
            HttpSession session = request.getSession();
            String Mess = (String) session.getAttribute("Mess");
            session.removeAttribute("Mess");
            if (!"null".equals(Mess)) {
                request.setAttribute("Mess", Mess);
            }
            String checkNewPost = "";
            checkNewPost = (String) session.getAttribute("checkNewPost");


            if ("oke".equals(checkNewPost)) {
                request.setAttribute("checkNewPost", "block");
            } else {
                request.setAttribute("checkNewPost", "none");
            }

            session.removeAttribute("checkNewPost");

            boolean login = false;
            String user_name = "";
            if (session.getAttribute("logged") != null) {
                login = (boolean) session.getAttribute("logged");
                user_name = session.getAttribute("user").toString();
            }

            if (login) {
                User user = new AuthBO().GetUser(user_name);
                request.setAttribute("user", user_name);
                request.setAttribute("logged", true);
                request.setAttribute("user_info", user);

            } else {
                request.setAttribute("Mess", Mess);
                request.setAttribute("user", "Đăng Nhập|Đăng Ký");
                request.setAttribute("logged", false);
            }
            request.setAttribute("search_Start", search_Start);
            request.setAttribute("search_End", search_End);
            request.setAttribute("Time", Time);
            request.setAttribute("Date", Date);

            request.setAttribute("PostType", "Kết quả tìm kiếm");
            request.setAttribute("ListPost", PostBO.getInstance().SearchPost(-1, search_Start, search_End, Time, Date));
            request.setAttribute("Tinhs", AddressBO.getInstance().getTinh());
            RequestDispatcher rd = request.getRequestDispatcher("/view/home.jsp");
            rd.forward(request, response);
        }

    }
}
