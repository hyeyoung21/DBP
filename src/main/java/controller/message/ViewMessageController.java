package controller.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Message;
import model.service.MessageManager;

public class ViewMessageController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MessageManager manager = MessageManager.getInstance();

        String userId = request.getParameter("userId");
        
        List<Message> msgList = manager.findMessageListByUser(userId);
        request.setAttribute("msgList", msgList);
        request.setAttribute("senderId", userId);
        return "/message/message.jsp";
        
    }
}
