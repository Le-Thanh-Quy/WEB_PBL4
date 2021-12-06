package Controller.Admin;

import Model.BEAN.Tinh;
import Model.BO.AddressBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateProvince")
public class UpdateProvince extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String IDProvince = req.getParameter("IDProvince");
        Tinh tinh = AddressBO.getInstance().getProvinceByID(IDProvince);
        req.setAttribute("Province", tinh);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/UpdateProvince.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String matp = req.getParameter("matp");
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String slug = req.getParameter("slug");

        if ("".equals(name.trim()) || "".equals(type.trim()) || "".equals(slug.trim()) || "".equals(matp.trim())) {
            req.setAttribute("Mess", "Không được để trống các mục!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/notification.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        if (!AddressBO.getInstance().UpdateProvince(matp, name, type, slug)) {
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
