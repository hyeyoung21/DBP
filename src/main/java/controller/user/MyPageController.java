package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.UserManager;
import model.User;


public class MyPageController implements Controller {

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
			UserManager manager = UserManager.getInstance();
			User user = manager.findUser(userId);
			
			request.setAttribute("user", user);
			return "/user/MyPage.jsp";
		}catch(Exception e) {
			return "redirect:/main";
		}
	}

}
