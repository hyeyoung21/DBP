<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% User user = (User) request.getAttribute("user"); %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>MyPage</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }

    .container {
      max-width: 600px;
      margin: 20px auto;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      overflow: hidden;
      padding: 20px;
    }

    .button-container {
      display: flex;
      flex-direction: column;
      gap: 15px;
    }

    .button {
      background-color: #4caf50;
      color: #fff;
      border: none;
      padding: 15px;
      font-size: 18px;
      cursor: pointer;
      border-radius: 8px;
      transition: background-color 0.3s;
      text-align: center;
      text-decoration: none;
      display: inline-block;
    }

    .button:hover {
      background-color: #45a049;
    }

    .calendar-button {
      background-color: #3498db;
    }

    .calendar-button:hover {
      background-color: #2980b9;
    }
    #userInfoContainer {
      display: none; /* 처음에는 숨겨져 있음 */
    }
  </style>
  <script>
    function loadUserInfo() {
      // 버튼 클릭 시 유저 정보를 보여주는 함수
      var userInfoContainer = document.getElementById("userInfoContainer");

      // 토글(Toggle) 효과: 보이면 숨기고, 숨겨져 있으면 보이게 함
      if (userInfoContainer.style.display === "none") {
        userInfoContainer.style.display = "block";
      } else {
        userInfoContainer.style.display = "none";
      }
    }
  </script>
</head>
<body>
  <div class="container">
    <h2>MyPage</h2>
    <div class="button-container">
      <a href="<c:url value='/mypage/myPost'>
				   <c:param name='userId' value='${userId}'/>
		 		</c:url>" class="button"> 내가 쓴 글 보기
	  </a>
      <a href="<c:url value='/mypage/myComment'>
				   <c:param name='userId' value='${userId}'/>
		 		</c:url>" class="button" > 내가 쓴 댓글 보기
      </a>
      <button class="button" onclick="loadUserInfo()">나의 개인정보 확인하기</button>
      <a href="<c:url value='/mypage/calendar' />" class="button calendar-button">캘린더</a>
      <a href="<c:url value='/' />" class="button">쪽지함</a>
    </div>

    <div id="userInfoContainer">
      <div id="userInfo">
        <h3>유저 정보</h3>
        <p><strong>ID:</strong> <%= user.getUserId() %></p>
        <p><strong>이름:</strong> <%= user.getName() %></p>
        <p><strong>성별:</strong> <%= user.getGender() %></p>
        <p><strong>나이:</strong> <%= user.getAge() %>세</p>
        <p><strong>이메일:</strong> <%= user.getEmail() %></p>
        <p><strong>지역:</strong> <%= user.getLocation() %></p>
        <p><strong>신고 횟수:</strong> <%= user.getReportCount() %>회</p>
      </div>
    </div>
  </div>
</body>
</html>
