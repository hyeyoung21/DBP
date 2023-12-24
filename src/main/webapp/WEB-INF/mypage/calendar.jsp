<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<Post> postList = (List<Post>)request.getAttribute("postList");
%>
<html>
<head>
  <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <!-- jquery CDN -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- fullcalendar CDN -->
  <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
  <!-- fullcalendar 언어 CDN -->
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
  <style>
    /* body 스타일 */
    body {
      margin-top: 40px;
      font-size: 14px;
      font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    }
    /* 드래그 박스의 스타일 */
    #external-events {
      position: fixed;
      left: 20px;
      top: 20px;
      width: 100px;
      padding: 0 10px;
      border: 1px solid #ccc;
      background: #eee;
      text-align: left;
    }
    #external-events h4 {
      font-size: 16px;
      margin-top: 0;
      padding-top: 1em;
    }
    #external-events .fc-event {
      margin: 3px 0;
      cursor: pointer; /* 수정: 드래그 기능 제거 */
    }
    #external-events p {
      margin: 1.5em 0;
      font-size: 11px;
      color: #666;
    }
    #external-events p input {
      margin: 0;
      vertical-align: middle;
    }
    #calendar-wrap {
      margin-left: 200px;
    }
    #calendar1 {
      max-width: 1100px;
      margin: 0 auto;
    }
  </style>
</head>
<body>
      <div id='calendar1'></div>
      
      <div id="eventModal" class="modal" style="display: none;">
    <div class="modal-content">
      <span class="close">&times;</span>
      <p><strong>일정명:</strong> <span id="eventTitle"></span></p>
      <p><strong>장소:</strong> <span id="eventLocation"></span></p>
      <p><strong>성별:</strong> <span id="eventGender"></span></p>
      <p><strong>나이:</strong> <span id="eventAge"></span></p>
      <!-- 여기에 원하는 일정 정보 추가 -->
      <button id="deleteButton">삭제</button>
    </div>
  <script>
  $(function(){
    var postList = [
      <c:forEach items="${postList}" var="post" varStatus="status">
        {
          id: '${post.id}',
          title: '${post.title}',
          location: '${post.location}',
          age: '${post.age}',
          gender: '${post.gender}',
          start: '${post.dateTime}', // 여기서 'dateTime'는 'Post' 객체의 날짜/시간 속성일 것입니다.
        }<c:if test="${!status.last}">,</c:if>
      </c:forEach>
    ];

    var calendarEl = $('#calendar1')[0];
    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right : ''
      },
      initialDate: '2023-12-01',
      locale: 'ko',
      editable: false,
      events: postList // postList를 events로 사용
    });
    
    calendar.on('eventClick', function(info) {

        $('#eventId').text(info.event.extendedProps.id);
        $('#eventTitle').text(info.event.title);
        $('#eventLocation').text(info.event.extendedProps.location);
        $('#eventAge').text(info.event.extendedProps.age);
        $('#eventGender').text(info.event.extendedProps.gender);
        
        $('#deleteButton').attr('data-postid', info.event.id);
        // 모달 표시
        $('#eventModal').css('display', 'block');
      });

      // 모달 닫기 버튼 클릭 시 모달 닫기
      $('.close').click(function() {
        $('#eventModal').css('display', 'none');
      });

      // 모달 영역 외 클릭 시 모달 닫기
      $(window).click(function(event) {
        if (event.target == $('#eventModal')[0]) {
          $('#eventModal').css('display', 'none');
        }
      });
      
      $('#deleteButton').click(function () {
          var postid = $(this).attr('data-postid');
          if (postid) {
            window.location.href = '<c:url value="/mypage/calendar/delete"/>' + '?postid=' + postid;
          }
        });
      
    calendar.render();
    
    
  });

  </script>
</body>
</html>