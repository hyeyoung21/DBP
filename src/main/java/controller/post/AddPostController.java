package controller.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.RegisterUserController;
import model.Post;
import model.service.PostManager;

/*작성글 등록 컨트롤러*/

public class AddPostController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	
        if (request.getMethod().equals("GET")) {    
            return "/post/PostRegister.jsp"; 
        }   
        
     // POST request (회원정보가 parameter로 전송됨) 
        Post post = new Post(
                request.getParameter("title"),
                request.getParameter("content"),
                request.getParameter("location"),
                request.getParameter("dateTime"),
                request.getParameter("gender"),
                request.getParameter("age"),
                Integer.parseInt(request.getParameter("part")),
                request.getParameter("meetingType")
            );
        
        System.out.println(post);

        try {
            PostManager manager = PostManager.getInstance();
            manager.add(post);
            return "redirect:/post/list"; 
            
        } catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("post", post);
            return "/post/list.jsp";
        }
    
    }
}
