package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.post.*;
import controller.user.*;
import controller.apply.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        // 각 uri에 대응되는 controller 객체를 생성 및 저장
        // 기존 폼 입력 처리 개선을 위해 폼 jsp는 컨트롤러에서 redirect함.
        mappings.put("/main", new ForwardController("/main.jsp"));
      
        // 로그인 & 회원가입
        mappings.put("/user/loginForm", new LoginController());  
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/joinForm", new RegisterUserController());
        
        // 회원 관리 & 검색
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewUserController());
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/delete", new DeleteUserController());
        
        // 작성글 관리
        mappings.put("/post/list", new ListPostController()); // 작성글 목록
        mappings.put("/post/view", new ViewPostController()); // 작성글 조회
        mappings.put("/post/add", new AddPostController()); // 작성글 등록
        mappings.put("/post/delete", new DeletePostController()); // 작성글 삭제
        mappings.put("/post/update", new UpdatePostController()); // 작성글 수정
        
        // 신청글 조회
        mappings.put("/apply/view", new PostViewApplyController()); // 신청글 보기
        mappings.put("/apply/list", new ApplyListController()); // 신청글 목록
        mappings.put("/apply/add", new AddApplyController()); // 신청
        mappings.put("/apply/modify", new ModifyApplyController()); // 신청글 삭제
        
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {  
        // 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}