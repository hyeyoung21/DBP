package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.User;
import model.service.ExistingUserException;
import model.service.UserManager;

public class RegisterUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
      	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 등록 form 요청	
    		log.debug("joinForm Request");

    		List<User> findUserList = UserManager.getInstance().findUserList();	// 커뮤니티 리스트 검색
			request.setAttribute("findUserList", findUserList);	
		
			return "/user/joinForm.jsp";   // 검색한 커뮤니티 리스트를 registerForm으로 전송     	
	    }	
     // POST request (회원정보가 parameter로 전송됨)
      	User user = new User(
      		    request.getParameter("userId"),
      		    request.getParameter("name"),
      		    request.getParameter("gender"),
      		    Integer.parseInt(request.getParameter("age")),
      		    request.getParameter("email"),
      		    request.getParameter("password"),
      		    request.getParameter("location"),
      		    0
      		);

		
        log.debug("Create User : {}", user);

		try {
			UserManager manager = UserManager.getInstance();
			manager.create(user);
	        return "redirect:/user/list";	// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			return "/user/joinForm.jsp";
		}
    }
}
