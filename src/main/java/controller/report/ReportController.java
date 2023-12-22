package controller.report;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Report;

public class ReportController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {	
            Report report = new Report();
            report.setReportType(request.getParameter("type"));
            report.setReportTitle(request.getParameter("postTitle"));
            report.setReportUserName(request.getParameter("userId"));
            report.setReportContenet(request.getParameter("content"));

            request.setAttribute("report", report);
            
            return "/report/report.jsp";
        } catch (Exception e) {
            return "redirect:/post/list"; 
        }
    }
}
