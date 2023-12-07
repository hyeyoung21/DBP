<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>모집 정보</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }

    #blog-form {
      display: flex;
      flex-wrap: wrap;
    }

    .form-group {
      width: 50%;
      box-sizing: border-box;
      padding: 0 10px;
    }

    #blog-form label, #blog-form input, #blog-form select, #blog-form textarea {
      width: 100%;
      margin-bottom: 10px;
      box-sizing: border-box;
    }

    #blog-content {
      width: 100%;
      height: 300px; /* 세로 길이 조절 */
    }

    #blog-form button {
      width: 100%;
    }

    #blog-list {
      list-style-type: none;
      padding: 0;
    }

    .blog-item {
      border: 1px solid #ccc;
      padding: 10px;
      margin-bottom: 10px;
    }

  </style>
  
   <script>
	function postCreate() {
		blog-form.submit();
		var message = confirm("등록이 완료되었습니다.");
	}
</script>
</head>

<body>

  <h1>모집 정보</h1>

  <form id="blog-form" method="post" action="<c:url value='/post/add' />" >
    <div class="form-group">
      <label for="part">모집 인원:</label>
      <input type="number" id="part" required>

      <label for="gender">모집 성별:</label>
      <select id="gender" required>
        <option value="male">남성</option>
        <option value="female">여성</option>
        <option value="any">모두</option>
      </select>

      <label for="age">모집 나이:</label>
      <input type="text" id="age" required>
    </div>

    <div class="form-group">
      <label for="meetingType">카테고리:</label>
      <select id="meetingType" required>
        <option value="study">스터디</option>
        <option value="exercise">운동</option>
        <option value="plant">원예</option>
        <option value="handicraft">수공예</option>
        <option value="performance">공연</option>
        <option value="art">미술</option>
        <option value="game">게임</option>
      </select>

      <label>
        모임 위치:
        <select id="location">
          <option value="서울">서울</option>
          <option value="경기">경기</option>
          <option value="세종">세종</option>
          <option value="인천">인천</option>
          <option value="충북">충북</option>
          <option value="충남">충남</option>
          <option value="강원">강원</option>
          <option value="전남">전남</option>
          <option value="jeonbul">전북</option>
          <option value="gwangju">광주</option>
          <option value="geongbuk">경북</option>
          <option value="geongnam">경남</option>
          <option value="jeju">제주</option>
          <option value="ulsam">울산</option>
          <option value="daegu">대구</option>
          <option value="daejun">대전</option>
        </select>
      </label>

      <label for="dateTime">모임 날짜:</label>
      <input type="date" id="dateTime" required>
    </div>
    
    <hr size="10px" />

    <input type="text" id="title" placeholder="제목을 입력하세요" required>
    <textarea id="content" placeholder="내용을 입력하세요" required></textarea>

    <button type="submit" onclick="postCreate()">등록하기</button>
  </form>
</body>
</html>
