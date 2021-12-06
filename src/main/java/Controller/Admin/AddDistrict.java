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
        String type = req.getParameter("type");
        String matp = req.getParameter("IDProvince");

        if ("".equals(name.trim()) || "".equals(type.trim()) || "".equals(matp.trim())) {
            req.setAttribute("Mess", "Không được để trống các mục!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/notification.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        String maqh = AddressBO.getInstance().getIDDistrict();

        Huyen huyen = new Huyen(maqh, name, type, matp);
        if (!AddressBO.getInstance().addDistrict(huyen)) {
            req.setCharacterEncoding("UTF-8");
            req.setAttribute("Mess", "Thêm mới không thành công!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/notification.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("Mess", "Thêm mới thành công!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/notification.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("IDProvince", req.getParameter("IDProvince"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/AddDistrict.jsp");
        requestDispatcher.forward(req, resp);
    }
}
