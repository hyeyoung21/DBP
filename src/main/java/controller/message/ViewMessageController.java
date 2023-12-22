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

        String yourId = request.getParameter("yourId");
        String myId = request.getParameter("myId");
        
        List<Message> msgList = manager.findMessageListByUser(myId, yourId);
        request.setAttribute("msgList", msgList);
        request.setAttribute("myId", myId);
        request.setAttribute("yourId", yourId);
        
        return "/message/message.jsp";
        
    }
}
