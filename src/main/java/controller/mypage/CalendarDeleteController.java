package controller.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Post;
import model.service.ApplyManager;
import model.service.UserManager;

public class CalendarDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userId = UserSessionUtils.getLoginUserId(session);
		
		if(!UserSessionUtils.hasLogined(session)) {
			request.setAttribute("popupmsg", "로그인 후 이용해주세요.");
			return "redirect:/user/loginForm";
		}
		try {
			int postId = Integer.parseInt(request.getParameter("postid"));
			
			ApplyManager applyManager = ApplyManager.getInstance();
			applyManager.deleteById(userId, postId);
			
			return "redirect:/mypage/calendar";
		}	catch(Exception e) {
			return "redirect:/main";
		}
	}
}
