package Controller.Admin;

import Model.BEAN.Report;
import Model.BO.ReportBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "viewReport", value = "/viewReport")
public class viewReport extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReportBO RpBO = new ReportBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Report> listReport = null;
        listReport = RpBO.getAllReport_BO();
        request.setAttribute("listReport", listReport);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/list_Report.jsp");
        requestDispatcher.forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
