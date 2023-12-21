<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	User user = (User)request.getAttribute("user");
%>
<html>
<head>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
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
  <div id='wrap'>
    <!-- 드래그 박스 -->
    <div id='external-events'>
      <h4>일정</h4>
      <div id='external-events-list'>
        <!-- 수정: 고정된 일정 목록 -->
        <div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event' data-id='1'>Event 1</div>
        <div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event' data-id='2'>Event 2</div>
        <div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event' data-id='3'>Event 3</div>
        <!-- 원하는 만큼 일정 추가 가능 -->
      </div>
    </div>
    <!-- calendar 태그 -->
    <div id='calendar-wrap'>
      <div id='calendar1'></div>
    </div>
  </div>
  <script>
    $(function(){
      // calendar element 취득
      var calendarEl = $('#calendar1')[0];
      // full-calendar 생성하기
      var calendar = new FullCalendar.Calendar(calendarEl, {
        // 해더에 표시할 툴바
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
        },
        initialDate: '2021-07-15', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
        locale: 'ko', // 한국어 설정
        editable: false, // 수정 불가능하게 변경
        eventClick: function(info) { // 일정을 클릭했을 때
          alert('일정 ID: ' + info.event.extendedProps.id + '\n일정명: ' + info.event.title);
          // 원하는 동작(예: 상세 일정 보기)을 추가할 수 있습니다.
        },
        events: [ // 수정: 고정된 일정 데이터
          { id: '1', title: 'Event 1', start: '2021-07-15' },
          { id: '2', title: 'Event 2', start: '2021-07-16' },
          { id: '3', title: 'Event 3', start: '2021-07-17' }
          // 실제 데이터로 대체 가능
        ]
      });
      // 캘린더 랜더링
      calendar.render();
    });
  </script>
</body>
</html>
