package Controller.Client;

import Model.BEAN.User;
import Model.BO.AuthBO;
import Model.BO.CommentBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/report")
public class ReportController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String myID = request.getParameter("myID");
        String theirID = request.getParameter("theirID");

        request.setAttribute("theirUser" , CommentBO.getInstance().getUserByID(Integer.parseInt(theirID)));
        request.setAttribute("myID" , myID);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/report.jsp");
        requestDispatcher.forward(request , response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String content = request.getParameter("content");
        String myID = request.getParameter("myID");
        String theirID = request.getParameter("theirID");

        if(AuthBO.getInstance().addReport(myID , theirID , content)){
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print("<br><br><br><h2>Chúng tôi đã nhận được báo cáo của bạn, chúng tôi sẽ sớm phản hồi.</h2><h2>Cảm ơn bạn đã báo cáo!</h2>");
        }else{
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print("<br><br><br><h2>Báo cáo thất bại!</h2>");
        }
    }
}
