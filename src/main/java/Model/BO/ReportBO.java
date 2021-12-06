package Model.BO;

import Model.BEAN.Report;
import Model.BEAN.User;
import Model.DAO.Connect;
import Model.DAO.ConnectAdmin;

import java.util.ArrayList;

public class ReportBO {


    public String Format(String date) {
        String[] strings = date.split("-");
        String result = "";
        result = strings[2] + "/" + strings[1] + "/" + strings[0];
        return result;
    }

    public String FormatDateTime(String date) {
        String[] strings = date.split(" ");
        String result = "";
        result = Format(strings[0]) + " lúc " + strings[1];
        return result;
    }

    public ArrayList<Report> getAllReport_BO(){
        ArrayList<Report> listReport = null;
        listReport = ConnectAdmin.getInstance().getAllReport();
        for (int i = 0; i < listReport.size(); i++){
            User userRP = Connect.getInstance().GetUser("-1", listReport.get(i).getUserReportID());
            listReport.get(i).setTime(FormatDateTime( listReport.get(i).getTime()));
            listReport.get(i).setUserReport(userRP);
            User userVio = Connect.getInstance().GetUser("-1", listReport.get(i).getUserViolateID());
            listReport.get(i).setUserViolate(userVio);
        }
        return listReport;
    }
    public Report getReportByID_BO(int ID_report){
        Report report = new Report();
        report = ConnectAdmin.getInstance().getReportByID(ID_report);
        report.setTime(FormatDateTime(report.getTime()));
        User userRP = Connect.getInstance().GetUser("-1", report.getUserReportID());
        report.setUserReport(userRP);
        User userVio = Connect.getInstance().GetUser("-1", report.getUserViolateID());
        report.setUserViolate(userVio);
        return report;
    }

    public boolean updateReport(int ID, String feedback){
        return  ConnectAdmin.getInstance().updateReport(ID, feedback);
    }

    public boolean noiReport() {
        return  ConnectAdmin.getInstance().noiReport();
    }
}
