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
    <div class="container">
        <h1>모집 정보</h1>
        <form id="blog-form" method="post" action="<c:url value='/post/add' />" >
            <div class="form-group">
                <input type="hidden" id="creator" name="creator" value="${userId}" />
                <label for="part">모집 인원:</label>
                <input type="number" id="part" name="part" class="form-control" required>

                <label for="gender">모집 성별:</label>
                <select id="gender" name="gender" class="form-control" required>
                    <option value="male">남성</option>
                    <option value="female">여성</option>
                    <option value="any">모두</option>
                </select>

                <label for="age">모집 나이:</label>
                <input type="text" id="age" name="age" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="meetingType">카테고리:</label>
                <select id="meetingType" name="meetingType" class="form-control" required>
                    <option value="study">스터디</option>
                    <option value="exercise">운동</option>
                    <option value="plant">원예</option>
                    <option value="handicraft">수공예</option>
                    <option value="performance">공연</option>
                    <option value="art">미술</option>
                    <option value="game">게임</option>
                </select>

                <label for="location">모임 위치:</label>
                <select id="location" name="location" class="form-control">
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

                <label for="dateTime">모임 날짜:</label>
                <input type="date" id="dateTime" name="dateTime" class="form-control" required>
            </div>
            
            <hr />

            <input type="text" id="title" name="title" class="form-control" placeholder="제목을 입력하세요" required>
            <textarea id="content" name="content" class="form-control" placeholder="내용을 입력하세요" required></textarea>

            <button type="submit" class="btn btn-primary mt-3" onclick="postCreate()">등록하기</button>
        </form>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
