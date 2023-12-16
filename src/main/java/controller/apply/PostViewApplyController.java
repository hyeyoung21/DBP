package controller.apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import controller.Controller;
import model.Apply;
import model.service.ApplyManager;

public class PostViewApplyController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
        List<Apply> apply = null;
        ApplyManager manager = ApplyManager.getInstance();

        int postId = Integer.parseInt(request.getParameter("id"));
        
        apply = manager.findApplyListByPost(postId);
        request.setAttribute("apply", apply);
        return "/apply/ApplyView.jsp";
        
    }
}
