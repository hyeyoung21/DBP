package controller.apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ApplyManager;

public class AddApplyController implements Controller{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            ApplyManager manager = ApplyManager.getInstance();
            
            String userId = request.getParameter("userId");
            int postId = Integer.parseInt(request.getParameter("postId"));
            String description = request.getParameter("ApplyMessage");
          
            manager.add(userId, postId, description);
            return "redirect:/post/view?id=" + postId;
            
        } catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            return "/post/list.jsp";
        }
    
    }
}
