package controller.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Post;
import model.service.PostManager;

public class ListMyPostController implements Controller  {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        PostManager manager = PostManager.getInstance();
        String userId = request.getParameter("userId");
        List<Post> postList = manager.findListByUser(userId);
        
        request.setAttribute("postList", postList);             
        return "/user/MyPost.jsp";
    }
}
