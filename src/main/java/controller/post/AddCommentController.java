package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Comment;
import model.service.PostManager;

public class AddCommentController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Comment comment = new Comment();
        comment.setUserID(request.getParameter("userId"));
        comment.setContent(request.getParameter("content"));
        comment.setPostID(Integer.parseInt(request.getParameter("postId")));

        try {
            PostManager manager = PostManager.getInstance();
            manager.createComment(comment);;
            return "redirect:/post/list"; 
            
        } catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("comment", comment);
            return "/post/list.jsp";
        }
    
    }
}
