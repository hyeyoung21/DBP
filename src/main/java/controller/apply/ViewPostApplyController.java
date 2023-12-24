package controller.apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import controller.Controller;
import model.Post;
import model.service.ApplyManager;

public class PostViewApplyController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
        List<Post> applyList = null;
        ApplyManager manager = ApplyManager.getInstance();

        int postId = Integer.parseInt(request.getParameter("id"));
        
        applyList = manager.findListByPost(postId);
        request.setAttribute("applyList", applyList);
        return "/apply/ApplyView.jsp";
        
    }
}
