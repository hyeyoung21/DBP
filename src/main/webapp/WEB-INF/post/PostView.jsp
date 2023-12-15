<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Post post = (Post)request.getAttribute("post");
%>
<!DOCTYPE html>
<html lang="kr">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="style.css">
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
	
	    button {
	      text-align: right;
	      margin-top: 20px;
	      background-color: #007bff;
	      display: inline-block;
	      padding: 10px 20px;
	      border-radius: 5px;
	      text-decoration: none;
	      color: #fff;
	      margin-left: 10px;
	    }
	    button a:hover {
	      opacity: 0.8;
	    }
	
	
	    #blog-content {
	      display: inline-block;
	      padding: 1px 10px;
	      font-size: 16px;
	      color: #333;
	      background-color: #f4f4f4;
	    }
	    
	    textarea {
	      width: 100%;
	      resize: none;
	    }
	</style>
</head>
<body>

	<h2 id="blog-title">${post.title}</h2>

	<form id="blog-form">
		<div class="form-group">
			<label for="recruitment-num">모집 인원:</label>
			<a id="recruitment-num">${post.maxParticipants}</a>명
			<br>
			<label for="recruitment-gender">모집 성별:</label>
			<a id="recruitment-gender">${post.gender}</a>
			<br>
			<label for="recruitment-age">모집 나이:</label>
			<a id="recruitment-age">${post.age}</a>
		</div>

		<div class="form-group">
			<label for="category">카테고리:</label>
			<a id="category">${post.meetingType}</a>
			<br>
			<label for="location">모임 위치:</label>
				<a id="location">${post.location}</a>
			</label>
			<br>
			<label for="date">모임 날짜:</label>
			<a id="date">${post.dateTime}</a>
		</div>
		
		<hr size="10px" />

		<div id="blog-content">${post.content}</div>
	</form>
	
	<div id="buttom-from">
	<button onclick="sendApply()">신청하기</button>
	<button onclick="sendMessage()">쪽지 보내기</button>
	</div>
	
	<div id="comment-form">
		<h3>댓글 작성</h3>
		<textarea id="comment-content" rows="4" required></textarea>

		<button onclick="addComment()">댓글 작성</button>
	</div>

	<div id="comment-list">
		<!-- 여기에 추가된 댓글이 표시됩니다. -->
	</div>
</body>
</html>
