package Model.BO;

import Model.BEAN.Report;
import Model.BEAN.User;
import Model.DAO.Connect;
import Model.DAO.ConnectAdmin;

import java.util.ArrayList;

public class ReportBO {
    public ArrayList<Report> getAllReport_BO(){
        ArrayList<Report> listReport = null;
        listReport = ConnectAdmin.getInstance().getAllReport();
        for (int i = 0; i < listReport.size(); i++){
            User userRP = Connect.getInstance().GetUser("-1", listReport.get(i).getUserReportID());
            listReport.get(i).setUserReport(userRP);
            User userVio = Connect.getInstance().GetUser("-1", listReport.get(i).getUserViolateID());
            listReport.get(i).setUserViolate(userVio);
        }
        return listReport;
    }
    public Report getReportByID_BO(int ID_report){
        Report report = new Report();
        report = ConnectAdmin.getInstance().getReportByID(ID_report);
        User userRP = Connect.getInstance().GetUser("-1", report.getUserReportID());
        report.setUserReport(userRP);
        User userVio = Connect.getInstance().GetUser("-1", report.getUserViolateID());
        report.setUserViolate(userVio);
        return report;
    }

    public boolean updateReport(int ID, String feedback){
        return  ConnectAdmin.getInstance().updateReport(ID, feedback);
    }
}
