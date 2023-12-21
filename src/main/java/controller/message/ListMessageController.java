package controller.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.MessageManager;

public class ListMessageController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        String userId = request.getParameter("userId");
        MessageManager manager = MessageManager.getInstance();
        List<String> userList = manager.findList(userId);
        
        request.setAttribute("userList", userList);
        return "/message/message_list.jsp";
    }
    
}
