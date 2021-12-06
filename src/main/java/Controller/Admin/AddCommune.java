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

@WebServlet("/AddCommune")
public class AddCommune extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("IDDistrict", req.getParameter("IDDistrict"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/AddCommune.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String maqh = req.getParameter("IDDistrict");

        if ("".equals(name.trim()) || "".equals(type.trim()) || "".equals(maqh.trim())) {
            req.setAttribute("Mess", "Không được để trống các mục!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/notification.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }
        String maid = AddressBO.getInstance().getIDCommune();

        XaPhuong xaPhuong = new XaPhuong(maid, name, type, maqh);
        if (!AddressBO.getInstance().addCommune(xaPhuong)) {
            req.setAttribute("Mess", "Thêm mới không thành công!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/notification.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("Mess", "Thêm mới thành công!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/admin/notification.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
