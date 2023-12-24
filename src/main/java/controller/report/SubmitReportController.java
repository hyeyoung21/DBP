package controller.report;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.User;
import model.service.UserManager;

public class ReportSubmitController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
	    	UserManager manager = UserManager.getInstance();
	    	User user = manager.findUser(request.getParameter("reportUserName"));
	    	
	    	user.setReportCount(user.getReportCount()+1);
	    	
	    	manager.update(user);
	    	
			return "/report/reportSubmit.jsp";
		}catch (Exception e){
			return "/post/list";
		}
	}

}
