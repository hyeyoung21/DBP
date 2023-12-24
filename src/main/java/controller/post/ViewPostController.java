package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.ApplyManager;
import model.service.CommentManager;
import model.service.PostManager;
import model.service.UserNotFoundException;
import model.Comment;
import model.Post;

public class ViewPostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
    	Post post = null;
		PostManager manager = PostManager.getInstance();
		CommentManager commengManager = CommentManager.getInstance();
		ApplyManager applyManager = ApplyManager.getInstance();
		
		int postId = Integer.parseInt(request.getParameter("id"));
		
		try {
			// 중복 여부
			HttpSession session = request.getSession();
			String userId = UserSessionUtils.getLoginUserId(session);
			
			int isDuplicate = applyManager.checkForDuplicate(userId, postId);
            if (isDuplicate == 1) 
                request.setAttribute("isDuplicate", true);
            else
            	request.setAttribute("isDuplicate", false);
			
            post = manager.getPost(postId);
            List<Comment> commentList = commengManager.getAllComments(postId);
            
            for (Comment comment : commentList) {
                System.out.println(comment); // 댓글 정보를 출력
            }
            
            request.setAttribute("commentList", commentList);             
        } catch (Exception e) {
            return "redirect:/post/PostList";
        }   
        
        request.setAttribute("post", post);
        return "/post/PostView.jsp";
    }
}
