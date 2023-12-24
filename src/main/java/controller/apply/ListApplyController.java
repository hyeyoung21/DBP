package controller.apply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Apply;
import model.service.ApplyManager;

public class ListApplyController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession(); 
        if (!UserSessionUtils.isLoginUser("admin", session)) {
            return "redirect:/main";
        }
        
        ApplyManager manager = ApplyManager.getInstance();
        List<Apply> postList = manager.findAllList();
        
        request.setAttribute("postList", postList);
        return "/apply/ApplyList.jsp";
    }
    
}
