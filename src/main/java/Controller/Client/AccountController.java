package Controller.Client;

import Model.BEAN.Assess;
import Model.BEAN.Post;
import Model.BEAN.User;
import Model.BO.AuthBO;
import Model.BO.PostBO;
import Model.DAO.Connect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "account", value = "/account")
public class AccountController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String my_user_name = (String) request.getSession().getAttribute("user");
        String others_user_name = request.getParameter("others_user_name");

        User myAccount = AuthBO.getInstance().GetUser(my_user_name);
        User user = new User();
        if ("null".equals(others_user_name)) {
            user = myAccount;
        } else {
            user = AuthBO.getInstance().GetUser(others_user_name);
            request.setAttribute("rankAssess" ,AuthBO.getInstance().getInteract(String.valueOf(myAccount.getID()) , String.valueOf(user.getID())));
        }
        List<Post> postList = PostBO.getInstance().getPostListWithUser(-1, user.getID());

        Assess assess = AuthBO.getInstance().GetAssess(user.getAssessID());

        request.setAttribute("ListPost", postList);
        request.setAttribute("myAccount", myAccount);
        request.setAttribute("user", user);
        request.setAttribute("assess", assess);
        request.setAttribute("address", AuthBO.getInstance().GetAddress(user.getAddress()));

        RequestDispatcher rd = request.getRequestDispatcher("/view/account.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String myID = request.getParameter("myID");
        String theirID = request.getParameter("theirID");
        String rank = request.getParameter("rank");
        if(AuthBO.getInstance().Assess(rank , myID , theirID)){

            response.getWriter().write("true");

        }else{
            response.getWriter().write("false");
        }
    }
}
