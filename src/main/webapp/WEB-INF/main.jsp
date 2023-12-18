<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>취미 매칭 프로그램</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #fff; /* 흰색 배경 */
            margin: 0;
            padding: 0;
            max-width: 1200px; /* 전체 화면 크기 고정 */
            margin: 0 auto; /* 가운데 정렬 */
        }

        header {
            background-color: #fff;
            color: black;
            padding: 10px;
            text-align: center; /* 중앙 정렬로 변경 */
        }

        nav {
            background-color: #c0eb75; /* 연한 연두색 */
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        section {
            padding: 20px;
        }

        h2 {
            color: #333;
            text-align: center; /* 중앙 정렬로 변경 */
        }

        .board-link {
            display: block;
            margin: 10px 0;
            padding: 10px;
            background-color: #f0f0f0; /* 옅은 회색 */
            color: #333;
            text-decoration: none;
            text-align: center;
            border-radius: 5px;
        }

        .recruitment-list {
            list-style: none;
            padding: 0;
            display: flex;
            flex-wrap: wrap;
            justify-content: flex-start; /* 왼쪽 정렬로 변경 */
        }

        .recruitment-item {
            background-color: #f0f0f0; /* 옅은 회색 */
            margin: 10px;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            flex: 0 0 calc(25% - 20px); /* 크기 고정 및 여백 조정 */
            min-width: 150px; /* 최소 너비 추가 */
        }

        .recruitment-item h3 {
            margin: 0;
        }

        .more-link {
            display: block;
            margin: 10px 0;
            padding: 10px;
            background-color: #3498db;
            color: #fff;
            text-decoration: none;
            text-align: center;
            border-radius: 5px;
            cursor: pointer;
        }

        .search-bar {
            margin-top: 10px;
            display: flex;
            justify-content: flex-end;
        }

        input[type="text"] {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            background-color: #3498db;
            color: #fff;
            padding: 8px 12px;
            border: none;
            border-radius: 5px;
            margin-left: 5px;
            cursor: pointer;
        }

        .user-links {
            text-align: right;
            margin: 10px;
        }

        .user-links a {
            margin-left: 10px;
            color: #333;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <header>
        <div class="user-links">
			<c:if test="${userId ne null}">
				<a href="<c:url value='/user/logout'/>">${userId}(로그아웃)</a>
			</c:if>
			<c:if test="${userId eq null}">
				<a href="<c:url value='/user/loginForm'/>">로그인</a>
			</c:if>
			
			
            <a href="<c:url value='/user/joinForm' />">회원가입</a>
        </div>
        <h2>취미 매칭 프로그램</h2>
        <div class="search-bar">
            <input type="text" placeholder="검색어를 입력하세요">
            <button type="button">검색</button>
        </div>
    </header>

    <nav>
        <a href="<c:url value='/user/mypage' />">마이페이지</a>
        <a href="<c:url value='/post/add' />">모집하기</a>
        <a href="<c:url value='/user/view' />">프로필</a>
    </nav>

    <section>
        <h2>인기 모집글</h2>
        <ul class="recruitment-list" id="popularRecruitments">
            <!-- 여기에 인기 모집글 보여주기 -->
            <li class="recruitment-item">
                <h3>모집글 제목 1</h3>
                <p>모집글 내용 1</p>
            </li>
            <li class="recruitment-item">
                <h3>모집글 제목 2</h3>
                <p>모집글 내용 2</p>
            </li>
            <!-- 기타 모집글들 -->
        </ul>
        <a href="<c:url value='/post/list' />" class="more-link">더보기 ...</a>
    </section>

    <section>
        <h2>지역 최신글</h2>
        <ul class="recruitment-list" id="localRecruitments">
            <!-- 여기에 지역 최신글 보여주기 -->
            <li class="recruitment-item">
                <h3>모집글 제목 3</h3>
                <p>모집글 내용 3</p>
            </li>
            <li class="recruitment-item">
                <h3>모집글 제목 4</h3>
                <p>모집글 내용 4</p>
            </li>
            <!-- 기타 모집글들 -->
        </ul>
        <a href="<c:url value='/post/list' />" class="more-link">더보기 ...</a>
    </section>
</body>
</html>
