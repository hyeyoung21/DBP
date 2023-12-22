package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Comment;
import model.service.CommentManager;
import model.service.PostManager;

public class AddCommentController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	CommentManager manager = CommentManager.getInstance();
        int postId = Integer.parseInt(request.getParameter("postId"));

        Comment comment = new Comment();
        comment.setUserID(request.getParameter("userId"));
        comment.setContent(request.getParameter("content"));
        comment.setPostID(postId);

        try {
            manager.createComment(comment);
            return "redirect:/post/view?id=" + postId;
            
        } catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("comment", comment);
            return "/post/list.jsp";
        }
    }
}
