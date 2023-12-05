package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
    	// 기존 폼 입력 처리 개선을 위해 폼 jsp는 컨트롤러에서 redirect함.
        mappings.put("/", new ForwardController("main.jsp"));
      
        mappings.put("/user/login", new LoginController());  
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewUserController());
        
        // 회원 관리
        mappings.put("/user/add", new AddUserController());
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/delete", new DeleteUserController());
        
        // 작성글 관리
        mappings.put("/post/view", new PostViewontroller()); // 작성글 조회
        mappings.put("/post/add", new PostAddController()); // 작성글 등록
        mappings.put("/post/delete", new PostDeleteController()); // 작성글 삭제
        mappings.put("/post/update", new PostUpdateController()); // 작성글 수정
        
        // 신청글 조회
        mappings.put("/applyPost/view", new ApplyPostViewController()); // 신청글 등록
        mappings.put("/applyPost", new ApplyPostDeleteController()); // 신청글 삭제
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}