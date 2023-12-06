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
    	Post post = new Post();
    	PostManager manager = PostManager.getInstance();
    	
    	//id 입력 안받고, 시퀀스도 해놓지 않아서 주석처리함
//    	int id = 0;  // 기본값 또는 매개변수가 제공되지 않은 경우를 처리합니다.
//		try {
//		    id = Integer.parseInt(request.getParameter("id"));  // 게시글의 고유 식별자를 정수로 변환하여 설정합니다.
//		} catch (NumberFormatException e) {
//		    // 예외 처리 또는 기본값 제공
//		}

		String title = request.getParameter("blog-title");  
		String description = request.getParameter("blog-content");  // 게시글 설명
		String location = request.getParameter("location");  // 게시글 위치
		String gender = request.getParameter("recruitment-gender");  // 성별 정보
		String ageRange = request.getParameter("recruitment-age");  // 나이 범위
		String maxParticipantsStr = request.getParameter("recruitment-num");  // 최대 참여자 수
		// String creatorID = request.getParameter("creator");  // 게시글 작성자 이름


		int maxParticipants = 0;  // 기본값 또는 매개변수가 제공되지 않은 경우를 처리
		try {
		    maxParticipants = Integer.parseInt(maxParticipantsStr);
		} catch (NumberFormatException e) {
		    // 예외 처리 또는 기본값 제공
		}
		// 새로운 게시글(Post) 객체를 생성하고 속성들을 설정합니다.
		//post.setId(id);  // 게시글의 고유 식별자를 설정합니다.
		post.setTitle(title);
		post.setDescription(description);
		post.setLocation(location);
		post.setGender(gender);
		post.setAgeRange(ageRange);
		post.setMaxParticipants(maxParticipants);
		//post.setCreatorID(creatorID);
    	
		try {
			manager.create(post);
		}catch(Exception e) {
			return "redirect:/post/PostList";
		}
        request.setAttribute("post", post);            
        return "/post/PostView.jsp";  
    }
}