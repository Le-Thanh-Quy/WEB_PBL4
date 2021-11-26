package Controller.Admin;

import Model.BEAN.Huyen;
import Model.BO.AddressBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddDistrict")
public class AddDistrict extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String type=req.getParameter("type");
        String matp=req.getParameter("IDProvince");

        String maqh = AddressBO.getInstance().getIDDistrict();

        Huyen huyen = new Huyen(maqh, name, type, matp);
        if(!AddressBO.getInstance().addDistrict(huyen)){req.setCharacterEncoding("UTF-8");
            req.setAttribute("IDProvince", matp);
            RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/AddDistrict.jsp");
            requestDispatcher.forward(req, resp);
        }else{
            req.setAttribute("ListDistrict", AddressBO.getInstance().getAllDistrict(matp));
            RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/ShowDistrict.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("IDProvince", req.getParameter("IDProvince"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/AddDistrict.jsp");
        requestDispatcher.forward(req,resp);
    }
}
