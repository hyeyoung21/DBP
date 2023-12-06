package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;
import model.Post;

public class ViewPostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
    	Post post = null;
		PostManager manager = PostManager.getInstance();
		int postId = Integer.parseInt(request.getParameter("postId"));
		
		try {
            post = manager.findPost(postId);    // 사용자 정보 검색
        } catch (Exception e) {             
            return "redirect:/user/list";
        }   		
		
		request.setAttribute("post", post);				
		return "/post/PostView.jsp";	
    }
}
