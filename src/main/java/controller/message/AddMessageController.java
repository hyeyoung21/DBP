package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Message;
import model.service.MessageManager;

public class AddMessageController implements Controller{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            MessageManager manager = MessageManager.getInstance();
            Message msg = new Message();
            String recv = request.getParameter("recvId");
            msg.setRevID(request.getParameter("recvId"));
            msg.setSenderID(request.getParameter("sendId"));
            msg.setContent(request.getParameter("content"));
            manager.add(msg);
            return "redirect:/msg/view?userId=" + recv;
            
        } catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            return "/message/message_list.jsp";
        }
    
    }
}
