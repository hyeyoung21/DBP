<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">
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
	
	   #search-options {
	       margin-bottom: 20px;
	   }
	   
	   #write-button {
	       float: right;
	       width: 20%;
	   }
	</style>
</head>
<body>
<%@include file="/WEB-INF/navi.jsp" %>

<!--  
<div id="search-options" class="mt-3">
    <form id="search-form" class="mb-3">
        <label for="search-input">Search:</label>
        <input type="text" id="search-input" class="form-control">
    </form>

    <div class="row gx-3">
        <div class="col-md-4">
            <label for="location-search">모임 장소:</label>
            <select id="location-search" class="form-select">
                <option value="any-location" selected>모두</option>
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
        </div>

        <div class="col-md-4">
            <label for="category-search">카테고리:</label>
            <select id="category-search" class="form-select">
                <option value="any-category" selected>모두</option>
                <option value="운동">운동</option>
				<option value="원예">원예</option>
				<option value="수공예">수공예</option>
				<option value="공연">공연</option>
				<option value="미술">미술</option>
				<option value="게임">게임</option>
            </select>
        </div>

        <div class="col-md-4">
            <label for="gender-search">성별:</label>
            <select id="gender-search" class="form-select">
                <option value="male">남성</option>
                <option value="female">여성</option>
				<option value="any" selected>모두</option>
            </select>
        </div>
    </div>
</div>
-->

<ul id="blog-list" class="list-group">
    <c:forEach var="post" items="${postList}">
        <li class="list-group-item">
            <a href="<c:url value='/post/view'><c:param name='id' value='${post.id}'/></c:url>"
               class="text-decoration-none text-dark">
                <h3>${post.title}</h3>
                <p class="btn btn-primary">${post.location}</p>
                <p class="btn btn-success">${post.maxParticipants}명</p>
                <p class="btn btn-danger">${post.gender}</p>
                <p class="btn btn-warning">${post.meetingType}</p>
            </a>
        </li>
    </c:forEach>
</ul>

<!-- Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.2/js/bootstrap.min.js"></script>

</body>
</html>
