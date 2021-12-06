package Controller.Admin;

import Model.BEAN.XaPhuong;
import Model.BO.AddressBO;

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
        XaPhuong xaPhuong = AddressBO.getInstance().getCommuneByID(IDCommune);
        req.setAttribute("Commune", xaPhuong);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/UpdateCommune.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String xaid = req.getParameter("xaid");
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String maqh = req.getParameter("maqh");

        if ("".equals(name.trim()) || "".equals(type.trim()) || "".equals(maqh.trim()) || "".equals(xaid.trim())) {
            req.setAttribute("Mess", "Không được để trống các mục!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/notification.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        if (!AddressBO.getInstance().UpdateCommune(xaid, name, type, maqh)) {
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
