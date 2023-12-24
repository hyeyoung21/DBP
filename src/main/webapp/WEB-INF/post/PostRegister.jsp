<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모집 정보</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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

        #content {
            width: 100%;
            height: 300px;
            resize: none;
        }

        #blog-form button {
            width: 100%;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        hr {
            margin-top: 30px;
            margin-bottom: 30px;
            border: 0;
            border-top: 2px solid #ddd;
        }
    </style>

    <script>
        function postCreate() {
            blog-form.submit();
        }
    </script>
</head>

<body>
    <%@include file="/WEB-INF/navi.jsp" %>
    <div class="container">
        <h1>모집 정보</h1>
        <c:if test="${post.id == null}">    	
	        <form id="blog-form" method="post" action="<c:url value='/post/add' />" >
        </c:if>
        <c:if test="${post.id != null}">    	
	        <form id="blog-form" method="post" action="<c:url value='/post/update' />" >
        </c:if>
            <div class="form-group">
                <input type="hidden" id="creator" name="creator" value="${userId}" />
                <input type="hidden" id="postId" name="postId" value="${post.id}" />
                <label for="part">모집 인원:</label>
                <input type="number" id="part" name="part" class="form-control" value="${post.maxParticipants}" required>

                <label for="gender">모집 성별:</label>
                <select id="gender" name="gender" class="form-control" required>
                    <c:forEach var="option" items="${['male', 'female', 'any']}">
				        <option value="${option}" ${option eq user.gender ? 'selected' : ''}>${option}</option>
				    </c:forEach>
                </select>

                <label for="age">모집 나이:</label>
                <input type="text" id="age" name="age" class="form-control" value="${post.age}" required>
            </div>

            <div class="form-group">
                <label for="meetingType">카테고리:</label>
                <select id="meetingType" name="meetingType" class="form-control" required>
				    <c:forEach var="option" items="${['스터디', '운동', '원예', '수공예', '공연', '미술', '게임']}">
				        <option value="${option}" ${option eq post.meetingType ? 'selected' : ''}>${option}</option>
				    </c:forEach>
				</select>

                <label for="location">모임 위치:</label>
                <select id="location" name="location" class="form-control">
				    <c:forEach var="option" items="${['서울', '경기', '세종', '인천', '충북', '충남', '강원', '전남', '전북', '광주', '경북', '경남', '제주', '울산', '대구', '대전']}">
				        <option value="${option}" ${option eq post.location ? 'selected' : ''}>${option}</option>
				    </c:forEach>
				</select>

                <label for="dateTime">모임 날짜:</label>
                <input type="datetime-local" id="dateTime" name="dateTime" class="form-control" value="<c:out value='${post.dateTime}' />" required>
            </div>
            
            <hr />

            <input type="text" id="title" name="title" class="form-control" placeholder="제목을 입력하세요" value="${post.title}"required>
            <textarea id="content" name="content" class="form-control" placeholder="내용을 입력하세요" required>${post.content}</textarea>

            <button type="submit" class="btn btn-primary mt-3" onclick="postCreate()">등록하기</button>
        </form>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
