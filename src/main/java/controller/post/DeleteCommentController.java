package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;

public class DeleteCommentController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        PostManager manager = PostManager.getInstance();
        int commentID = Integer.parseInt(request.getParameter("commentID"));
        
        manager.deleteComment(commentID);
        return "redirect:/post/list";
    }
}
