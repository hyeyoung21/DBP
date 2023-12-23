# 호비프렌즈🎨📚🎮🎵🌿
### 지역 내 취미 매칭 프로그램
데이터베이스 프로그래밍 당근 먹는 부엉이 팀

### 목표
에브리타임과 같은 커뮤니티에 같이 밥을 먹거나, 학교 행사에 가거나, 혹은 문화 활동을 함께 할 사람을 찾기 위한 글이 자주 올라온다. 우리는 이렇듯 동행을 찾는 일에 수요가 많다는 걸 발견했고, 이를 더 직관적이고 유용하게 활용할 수 있도록 웹 페이지를 만들기로 했다.

### 핵심 기능
+ 구인 기능
  - 구인
  - 모임 신청
  - 모임 검색
  - 모임 마감
+ 쪽지
+ 회원 관리
  - 회원 가입 및 로그인
  - 회원 정보 수정
  - 회원 삭제
  - 마이페이지
  - 블랙리스트 회원

### 사용된 기술 및 라이브러리
+ FrontEnd
  - BootStrap
+ BackEnd
  - JDBC
  - myBatis (comment 기능만 구현)
+ DataBase
  - Oracle DataBase
  - erwin
+ library
  - JRE
  - Maven
 
### 프로젝트 구조
+ controller: MVC 아키텍처에서 컨트롤러
  - Apply: 모임 신청
  - Message: 쪽지 송수신
  - MyPage: 나의 작성글, 나의 댓글, 나의 모임 정보(캘린더) 및 내 정보를 보여주는 마이페이지
  - Post: 게시글 및 댓글
  - Report: 회원 신고
  - User : 회원 관리
+ DispatcherServlet, ForwardController, RequestMapping: 컨트롤러에서 요청을 처리하는 데 도움을 주는 클래스들
+ filter: HTTP 요청 및 응답을 필터링하는 데 사용되는 필터 클래스들
+ model: 애플리케이션에서 사용되는 데이터 모델 관련 클래스들
+ dao: 데이터베이스 액세스 객체(Data Access Object) 클래스들
+ service: 비즈니스 로직을 처리하는 서비스 클래스들
+ repository/mybatis: MyBatis를 사용하여 데이터베이스에 접근하기 위한 Mapper 클래스와 DAO 클래스(Only Comment)

  
