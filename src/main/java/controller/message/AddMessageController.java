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
            String you = request.getParameter("yourId");
            String me = request.getParameter("myId");
            msg.setRevID(request.getParameter("yourId"));
            msg.setSenderID(request.getParameter("myId"));
            msg.setContent(request.getParameter("content"));
            manager.add(msg);
            return "redirect:/msg/view?yourId=" + you + "&myId=" + me;
            
        } catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            return "/message/message_list.jsp";
        }
    
    }
}
