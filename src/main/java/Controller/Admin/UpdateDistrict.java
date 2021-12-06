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

@WebServlet("/UpdateDistrict")
public class UpdateDistrict extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String IDDistrict = req.getParameter("IDDistrict");
        Huyen huyen = AddressBO.getInstance().getDistrictByID(IDDistrict);
        req.setAttribute("District", huyen);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/UpdateDistrict.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String maqh = req.getParameter("maqh");
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String matp = req.getParameter("matp");

        if ("".equals(name.trim()) || "".equals(type.trim()) || "".equals(maqh.trim()) || "".equals(matp.trim())) {
            req.setAttribute("Mess", "Không được để trống các mục!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/notification.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        if (!AddressBO.getInstance().UpdateDistrict(maqh, name, type, matp)) {
            req.setAttribute("Mess", "Cập nhật không thành công!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/notification.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("Mess", "Cập nhật thành công!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/notification.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
