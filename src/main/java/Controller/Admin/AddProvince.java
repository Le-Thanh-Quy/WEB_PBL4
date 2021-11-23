package Controller.Admin;

import Model.BEAN.Tinh;
import Model.BO.Address_BO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddProvince")
public class AddProvince extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("IDProvince",Address_BO.getInstance().getIDProvince());
        RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/AddProvince.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String type=req.getParameter("type");
        String slug=req.getParameter("slug");

        String matp = Address_BO.getInstance().getIDProvince();

        Tinh tinh = new Tinh(matp, name, type, slug);
        if(!Address_BO.getInstance().addProvince(tinh)){
            req.setAttribute("IDProvince",Address_BO.getInstance().getIDProvince());
            RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/AddProvince.jsp");
            requestDispatcher.forward(req, resp);
        }else{
            req.setAttribute("listProv", Address_BO.getInstance().getAllProv());
            RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/UIUpdateAddress.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}