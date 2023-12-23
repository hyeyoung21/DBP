package controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.PostManager;

/*작성글 삭제 컨트롤러*/

public class DeletePostController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
        PostManager manager = PostManager.getInstance();
        int postId = Integer.parseInt(request.getParameter("postId"));
        manager.remove(postId);
        return "redirect:/post/list"; 
    }

}
