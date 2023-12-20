package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;
import model.service.UserNotFoundException;
import model.Comment;
import model.Post;

public class ViewPostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
    	Post post = null;
		PostManager manager = PostManager.getInstance();
		int postId = Integer.parseInt(request.getParameter("id"));
		
		try {
            post = manager.getPost(postId);
            List<Comment> commentList = manager.getAllComments(postId);
            
            request.setAttribute("commentList", commentList);             
        } catch (Exception e) {             
            return "redirect:/post/PostList";
        }   
        
        request.setAttribute("post", post);            
        return "/post/PostView.jsp";  
    }
}
