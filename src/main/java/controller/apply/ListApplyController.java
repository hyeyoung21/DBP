package controller.apply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Post;
import model.service.ApplyManager;

public class ListApplyController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        ApplyManager manager = ApplyManager.getInstance();
        List<Post> postList = manager.findAllList();
        
        request.setAttribute("postList", postList);
        return "/apply/ApplyList.jsp";
    }
    
}
