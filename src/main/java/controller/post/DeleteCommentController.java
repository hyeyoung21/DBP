package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;

public class DeleteCommentController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("delete");
        PostManager manager = PostManager.getInstance();
        int postId = Integer.parseInt(request.getParameter("postId"));
        
        int commentID = Integer.parseInt(request.getParameter("commentID"));
        manager.deleteComment(commentID);
        return "redirect:/post/view?id=" + postId;  
    }
}
