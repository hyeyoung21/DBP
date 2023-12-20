package controller.post;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Post;
import model.service.PostManager;

public class ListPostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PostManager manager = PostManager.getInstance();
        List<Post> postList = manager.getAllPosts();
        
        request.setAttribute("postList", postList);             
        return "/post/PostList.jsp";
    }
}