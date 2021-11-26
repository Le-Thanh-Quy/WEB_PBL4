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

@WebServlet(value = "/updateReport")
public class updateReport extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReportBO RpBO = new ReportBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int ID = Integer.parseInt(request.getParameter("ID"));
        String feedback = request.getParameter("feedback");
        RpBO.updateReport(ID, feedback);
        ArrayList<Report> listReport = null;
        listReport = RpBO.getAllReport_BO();
        request.setAttribute("listReport", listReport);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admin/list_Report.jsp");
        requestDispatcher.forward(request , response);
    }
}
