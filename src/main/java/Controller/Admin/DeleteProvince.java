package Controller.Admin;

import Model.BO.Address_BO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/DeleteProvince")
public class DeleteProvince extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterValues("cb")==null){
            req.setAttribute("listProv", Address_BO.getInstance().getAllProv());
            RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/UIUpdateAddress.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }
        List<String> lisID = Arrays.asList(req.getParameterValues("cb"));
        for(String id:lisID){
            if(!Address_BO.getInstance().DeleteProvince(id)){
                req.setAttribute("listProv", Address_BO.getInstance().getAllProv());
                RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/UIUpdateAddress.jsp");
                requestDispatcher.forward(req, resp);
                return;
            }
        }
        req.setAttribute("listProv", Address_BO.getInstance().getAllProv());
        RequestDispatcher requestDispatcher =  req.getRequestDispatcher("view/admin/UIUpdateAddress.jsp");
        requestDispatcher.forward(req, resp);
    }
}