package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.CommentManager;
import model.service.PostManager;

public class DeleteCommentController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	CommentManager manager = CommentManager.getInstance();
        int commentID = Integer.parseInt(request.getParameter("commentID"));
        int postId = Integer.parseInt(request.getParameter("postID"));
        
        try {
            manager.deleteComment(commentID);
            return "redirect:/post/view?id=" + postId;
            
        } catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            // request.setAttribute("comment", comment);
            return "/post/list.jsp";
        }
    }
}
