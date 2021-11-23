package Controller.Admin;

import Model.BEAN.Huyen;
import Model.BEAN.Tinh;
import Model.BO.Address_BO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateDistrict")
public class UpdateDistrict extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String IDDistrict = req.getParameter("IDDistrict");
        Huyen huyen = Address_BO.getInstance().getDistrictByID(IDDistrict);
        req.setAttribute("District", huyen);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/UpdateDistrict.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String maqh=req.getParameter("maqh");
        String name=req.getParameter("name");
        String type=req.getParameter("type");
        String matp=req.getParameter("matp");

        if(!Address_BO.getInstance().UpdateDistrict(maqh, name, type, matp)){
            return;
        }

        req.setAttribute("ListDistrict", Address_BO.getInstance().getAllDistrict(matp));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/ShowDistrict.jsp");
        requestDispatcher.forward(req, resp);
    }
}
