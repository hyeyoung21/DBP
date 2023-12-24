package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;
import model.service.PostManager;

public class MainController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PostManager manager = PostManager.getInstance();
        List<Post> postList = manager.getTop3Posts();
        
        request.setAttribute("postList", postList);             
        return "/main.jsp";
    }
    
}
