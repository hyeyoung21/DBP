<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html; charset=utf-8" %>
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
    <%@include file="/WEB-INF/navi.jsp" %>

	<section>
	    <h2>최신글</h2>
	    <ul class="recruitment-list" id="localRecruitments">
	  	  <c:forEach var="post" items="${postList}" >
		 	   <li class="recruitment-item">
		        	<h3>${post.title}</h3>
                    <p>${fn:substring(post.content, 0, 15)}...</p>
		        </li>
	        </c:forEach>
	    </ul>
	    <a href="<c:url value='/post/list' />" class="more-link">더보기 ...</a>
	</section>
</body>
</html>
