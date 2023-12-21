package controller.report;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Report;
import model.service.UserManager;
import model.User;

public class ReportController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
        	
        	UserManager manager = UserManager.getInstance();
        	User user = manager.findUser(request.getParameter("userId"));
        	
        	user.setReportCount(user.getReportCount()+1);
        	
        	manager.update(user);
        	
            // Report 객체 생성
            Report report = new Report();
            report.setReportType(request.getParameter("type"));
            report.setReportTitle(request.getParameter("postTitle"));
            report.setReportUserName(request.getParameter("userId"));
            report.setReportContenet(request.getParameter("content"));

            request.setAttribute("report", report);
            
            // 기존 코드
            return "/report/report.jsp";
        } catch (Exception e) {
            // 실행 중 발생한 예외를 기록
            e.printStackTrace();
            throw e; // 예외를 전파하려면 다시 던집니다.
        }
    }
}
