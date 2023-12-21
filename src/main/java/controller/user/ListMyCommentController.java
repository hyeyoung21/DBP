package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Comment;
import model.service.PostManager;

public class ListMyCommentController implements Controller  {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        PostManager manager = PostManager.getInstance();
        String userId = request.getParameter("userId");
        List<Comment> commentList = manager.findCommentListByUser(userId);
        
        request.setAttribute("commentList", commentList);             
        return "/user/MyComment.jsp";
    }
}
