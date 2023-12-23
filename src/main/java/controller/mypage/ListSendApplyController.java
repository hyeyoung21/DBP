package controller.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Apply;
import model.service.ApplyManager;

public class ListSendApplyController implements Controller {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ApplyManager manager = ApplyManager.getInstance();
        String userId = request.getParameter("userId");
        List<Apply> applyList = manager.findSendedApply(userId);
        
        request.setAttribute("applyList", applyList);
        return "/apply/sendedApply.jsp";
    }
}
