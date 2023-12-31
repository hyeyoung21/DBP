package controller.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.User;
import model.Apply;
import model.Post;
import model.service.ApplyManager;
import model.service.PostManager;
import model.service.UserManager;

public class CalendarController  implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		if(!UserSessionUtils.hasLogined(session)) {
			request.setAttribute("popupmsg", "로그인 후 이용해주세요.");
			return "redirect:/user/loginForm";
		}
		try {
			String userId = UserSessionUtils.getLoginUserId(session);
			PostManager m = PostManager.getInstance();
			List<Post> list = (List<Post>)m.findAppliedPostByUser("user1");
			
			request.setAttribute("postList", list);
			
			return "/mypage/calendar.jsp";
		}	catch(Exception e) {
			return "redirect:/main";
		}
	}

}
