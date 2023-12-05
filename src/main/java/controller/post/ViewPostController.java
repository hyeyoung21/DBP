package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.UserManager;
import model.Post;

public class ViewPostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
    	Post post = null;
		UserManager manager = UserManager.getInstance();
		int postId = Integer.parseInt(request.getParameter("commId"));
		
		
		request.setAttribute("post", post);				
		return "/post/PostView.jsp";	
    }
}
