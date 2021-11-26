package Controller.Admin;

import Model.BO.AddressBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/DeleteDistrict")
public class DeleteDistrict extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterValues("cb")==null){
            req.setAttribute("ListDistrict", AddressBO.getInstance().getAllDistrict(req.getParameter("IDProvince")));
            RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/ShowDistrict.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        List<String> lisID = Arrays.asList(req.getParameterValues("cb"));
        for(String id:lisID){
            if(!AddressBO.getInstance().DeleteDistrict(id)){
                req.setAttribute("ListDistrict", AddressBO.getInstance().getAllDistrict(req.getParameter("IDProvince")));
                RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/ShowDistrict.jsp");
                requestDispatcher.forward(req, resp);
                return;
            }
        }
        req.setAttribute("ListDistrict", AddressBO.getInstance().getAllDistrict(req.getParameter("IDProvince")));
        RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/ShowDistrict.jsp");
        requestDispatcher.forward(req, resp);
    }
}
