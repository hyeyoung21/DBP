package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.post.*;
import controller.user.*;
import controller.apply.*;
import controller.mypage.*;
import controller.message.*;
import controller.report.*;


public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
        // 각 uri에 대응되는 controller 객체를 생성 및 저장
        // 기존 폼 입력 처리 개선을 위해 폼 jsp는 컨트롤러에서 redirect함.
        mappings.put("/main", new MainController());
      
        // 로그인 & 회원가입
        mappings.put("/user/loginForm", new LoginController());  
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/joinForm", new RegisterUserController());
        
        // 회원 관리 & 검색
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewUserController());
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/delete", new DeleteUserController());
        
        //마이페이지
        mappings.put("/mypage/mypage",new MyPageController());
        mappings.put("/mypage/sendApply",new ListSendApplyController());
        mappings.put("/mypage/recvApply",new ListRecvApplyController());
        mappings.put("/mypage/calendar",new CalendarController());
        mappings.put("/mypage/calendar/delete",new CalendarDeleteController());
        mappings.put("/mypage/myComment",new ListMyCommentController());
        mappings.put("/mypage/myPost",new ListMyPostController());
        
        // 작성글 관리
        mappings.put("/post/list", new ListPostController()); // 작성글 목록
        mappings.put("/post/search", new SearchPostController()); // 작성글 검색
        mappings.put("/post/view", new ViewPostController()); // 작성글 조회
        mappings.put("/post/add", new AddPostController()); // 작성글 등록
        mappings.put("/post/delete", new DeletePostController()); // 작성글 삭제
        mappings.put("/post/update", new UpdatePostController()); // 작성글 수정
        
        // 신청글 조회
        mappings.put("/apply/view", new ViewPostApplyController()); // 신청글 보기
        mappings.put("/apply/list", new ListApplyController()); // 신청글 목록
        mappings.put("/apply/add", new AddApplyController()); // 신청
        mappings.put("/apply/modify", new ModifyApplyController()); // 신청글 삭제
        
        //댓글 관리
        mappings.put("/comment/add", new AddCommentController()); // 신청글 보기
        mappings.put("/comment/delete", new DeleteCommentController()); // 신청글 보기
        
        mappings.put("/msg/list", new ListMessageController()); // 신청글 보기
        mappings.put("/msg/view", new ViewMessageController()); // 신청글 목록
        mappings.put("/msg/add", new AddMessageController()); // 신청
                
        //신고
        mappings.put("/report/report", new ReportController());
        mappings.put("/report/submit", new SubmitReportController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {  
        // 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}
