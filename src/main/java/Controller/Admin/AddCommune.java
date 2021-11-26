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
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String type=req.getParameter("type");
        String maqh=req.getParameter("IDDistrict");

        String maid = AddressBO.getInstance().getIDCommune();

        XaPhuong xaPhuong = new XaPhuong(maid, name, type, maqh);
        if(!AddressBO.getInstance().addCommune(xaPhuong)){
            req.setCharacterEncoding("UTF-8");
            req.setAttribute("IDDistrict", maqh);
            RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/AddCommune.jsp");
            requestDispatcher.forward(req, resp);
        }else{
            req.setAttribute("ListCommune", AddressBO.getInstance().getAllCommune(maqh));
            System.out.println(AddressBO.getInstance().getAllCommune(maqh).size());
            RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/ShowCommune.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
