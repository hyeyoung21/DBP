package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Comment;
import model.Post;
import model.service.PostManager;

public class SearchPostController implements Controller  {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PostManager manager = PostManager.getInstance();
        String keyword = request.getParameter("keyword");
        List<Post> postList = manager.findPostList(keyword);
        
        request.setAttribute("postList", postList);             
        return "/post/PostList.jsp";
    }
}
