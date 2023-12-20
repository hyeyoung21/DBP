package controller.apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ApplyManager;

public class ModifyApplyController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
        String action = request.getParameter("action");
        ApplyManager manager = ApplyManager.getInstance();
        
        int applyID = Integer.parseInt(request.getParameter("applyID"));
        if ("edit".equals(action)) {
            manager.update(applyID);
            return "redirect:/apply/list"; 
        } else  {
            manager.delete(applyID);
            return "redirect:/apply/list"; 
        }
         //redirect / forwarding
    }
}
