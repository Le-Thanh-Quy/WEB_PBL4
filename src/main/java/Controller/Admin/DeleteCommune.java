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

@WebServlet("/DeleteCommune")
public class DeleteCommune extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterValues("cb")==null){
            req.setAttribute("listProv", AddressBO.getInstance().getAllProv());
            req.setAttribute("checkCommune" , req.getParameter("IDDistrict"));
            RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/UIUpdateAddress.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }
        List<String> listID = Arrays.asList(req.getParameterValues("cb"));
        for (String id:listID){
            if(!AddressBO.getInstance().DeleteCommune(id)){
                req.setAttribute("listProv", AddressBO.getInstance().getAllProv());
                req.setAttribute("checkCommune" , req.getParameter("IDDistrict"));
                RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/UIUpdateAddress.jsp");
                requestDispatcher.forward(req, resp);
                return;
            }
        }
        req.setAttribute("listProv", AddressBO.getInstance().getAllProv());
        req.setAttribute("checkCommune" , req.getParameter("IDDistrict"));
        RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/UIUpdateAddress.jsp");
        requestDispatcher.forward(req, resp);
    }
}
