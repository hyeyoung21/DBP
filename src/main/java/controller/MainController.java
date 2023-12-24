package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.user.UserSessionUtils;
import model.Post;
import model.User;
import model.service.PostManager;
import model.service.UserManager;

public class MainController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String userId = UserSessionUtils.getLoginUserId(session);
        UserManager um = UserManager.getInstance();
        User user = um.findUser(userId);
        String loc = user.getLocation();
        
        PostManager pm = PostManager.getInstance();
        List<Post> recentList = pm.getTop3Posts();
        List<Post> locList = pm.getTop3PostsFromLoc(loc);
        
        request.setAttribute("recentList", recentList);
        request.setAttribute("locList", locList);
        return "/main.jsp";
    }
    
}
