package controller.post;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Post;
import model.service.PostManager;

/*작성글 등록 컨트롤러*/

public class UpdatePostController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
        int postId = Integer.parseInt(request.getParameter("postId"));
        if (request.getMethod().equals("GET")) {    
                    // GET request: 수정 form 요청 
                    PostManager manager = PostManager.getInstance();
                    Post post = manager.getPost(postId); // 수정하려는 사용자 정보 검색
                    request.setAttribute("post", post);
                    
                    return "/post/PostRegister.jsp";
        }
     
        System.out.println(request.getParameter("creator"));
        Post post = new Post(
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
        
        System.out.println(post);

        try {
            PostManager manager = PostManager.getInstance();
            manager.update(post, postId);
            return "redirect:/post/list"; 
            
        } catch (Exception e) { 
            request.setAttribute("registerFailed", true);
            request.setAttribute("exception", e);
            request.setAttribute("post", post);
            return "/post/list.jsp";
        }
    
    }
}
