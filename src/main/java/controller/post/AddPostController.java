package controller.post;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Post;
import model.service.PostManager;

/*작성글 등록 컨트롤러*/

public class AddPostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	PostManager manager = PostManager.getInstance();
    	
        if (request.getMethod().equals("GET")) {    
            return "/post/PostRegister.jsp"; 
        }   
     
        System.out.println(request.getParameter("creator"));
        Post post1 = new Post(
                request.getParameter("creator"),
                request.getParameter("title"),
                request.getParameter("content"),
                request.getParameter("location"),
                request.getParameter("dateTime"),
                request.getParameter("gender"),
                request.getParameter("age"),
                Integer.parseInt(request.getParameter("part")),
                request.getParameter("meetingType")
            );
       
        try {
            manager.add(post1);
            return "redirect:/post/list"; 
            
        } catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("post", post1);
            return "/post/list.jsp";
        }
    
    }
}