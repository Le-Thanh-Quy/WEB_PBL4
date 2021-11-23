package Controller.Admin;

import Model.BEAN.Huyen;
import Model.BEAN.XaPhuong;
import Model.BO.Address_BO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateCommune")
public class UpdateCommune extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String IDCommune = req.getParameter("IDCommune");
        XaPhuong xaPhuong = Address_BO.getInstance().getCommuneByID(IDCommune);
        req.setAttribute("Commune", xaPhuong);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/UpdateCommune.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String xaid=req.getParameter("xaid");
        String name=req.getParameter("name");
        String type=req.getParameter("type");
        String maqh=req.getParameter("maqh");

        if(!Address_BO.getInstance().UpdateCommune(xaid, name, type, maqh)){
            return;
        }

        req.setAttribute("ListCommune", Address_BO.getInstance().getAllCommune(maqh));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/ShowCommune.jsp");
        requestDispatcher.forward(req, resp);
    }
}
