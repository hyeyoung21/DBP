<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	@SuppressWarnings("unchecked") 
	List<Post> postList = (List<Post>)request.getAttribute("postList");
%><!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
	<title>Post List</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			margin: 20px;
		}
	
		#search-form {
			margin-bottom: 20px;
		}
	
		#search-form input{
			width: 300px;
			padding: 5px;
			margin-right: 10px;
		}
	
		#location-search,
		#category-search,
		#gender-search {
			width: 150px;
			padding: 5px;
			margin-right: 10px;
		}
	
		#blog-list {
			list-style-type: none;
			padding: 5px;
			border: 1px solid #ccc;
		}
		
		li {
		padding: 10px;
		border-bottom: 1px solid #ccc;
		}

		li:last-child {
			border-bottom: none;
		}
		
		li a {
			text-decoration: none;
			color: inherit;
		}
		
		li:hover {
			background-color: #f9f9f9; 
		}
		#write-button {
			float: right;
			width: 20%
		}
	</style>
</head>
<body>
	<div id ="write-button">
		<a href="<c:url value='/post/add' />"> 포스트 등록하기</a>
	</div>
	<div id="search-options">
		<form id="search-form">
				<label for="search-input">Search:</label>
				<input type="text" id="search-input">
			</form>
		
			<label>
				모임 장소:
				<select id="location-search">
					<option value="any-location" selected>모두</option>
					<option value="서울">서울</option>
					<option value="경기">경기</option>
					<option value="세종">세종</option>
					<option value="인천">인천</option>
					<option value="충북">충북</option>
					<option value="충남">충남</option>
					<option value="강원">강원</option>
					<option value="전남">전남</option>
					<option value="전북">전북</option>
					<option value="광주">광주</option>
					<option value="경북">경북</option>
					<option value="경남">경남</option>
					<option value="제주">제주</option>
					<option value="울산">울산</option>
					<option value="대구">대구</option>
					<option value="대전">대전</option>
				</select>
			</label>
		
			<label>
				카테고리:
				<select id="category-search">
					<option value="any-category" selected>모두</option>
					<option value="study">스터디</option>
					<option value="exercise">운동</option>
					<option value="plant">원예</option>
					<option value="handicraft">수공예</option>
					<option value="performance">공연</option>
					<option value="art">미술</option>
					<option value="game">게임</option>
				</select>
			</label>

			
			<label>
				성별:
				<select id="gender-search">
					<option value="male">남성</option>
					<option value="female">여성</option>
					<option value="any" selected>모두</option>
				</select>
			</label>
	</div>

	<h2>Search Results</h2>
	<ul id="blog-list">
		<c:forEach var="post" items="${postList}">
		<li>
			<a href="<c:url value='/post/view'>
				<c:param name='id' value='${post.id}'/>
		 	</c:url>">
				<h3>${post.title}</h3>
				<p><strong>지역:</strong> ${post.location}</p>
				<p><strong>모집 인원:</strong> ${post.maxParticipants}명</p>
				<p><strong>모집 성별:</strong> ${post.gender}</p>
			</a>
		</li>
	</c:forEach>
	</ul>
</body>
</html>
