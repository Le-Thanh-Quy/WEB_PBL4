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

@WebServlet(value = "/detailReport")
public class detailReport extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReportBO RpBO = new ReportBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Report report = new Report();
        int ID = Integer.parseInt(request.getParameter("IDRP"));
        report = RpBO.getReportByID_BO(ID);
        request.setAttribute("report", report);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/detailReport.jsp");
        requestDispatcher.forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
