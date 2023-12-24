<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Include Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #fff;
            margin: 0 auto;
            max-width: 1200px;
            padding: 0;
        }

        header {
            background-color: #3498db;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        header h2 {
            color: #fff;
        }

        nav {
            background-color: #3498db;
            color: #fff;
        }

        .navbar-brand,
        .navbar-nav .nav-link {
            color: #fff;
        }

        .navbar-nav .nav-link:hover {
            color: #333;
        }

        .user-links a {
            color: #fff; /* Set color to white */
        }

        .search-bar {
            margin-top: 10px;
            display: flex;
            justify-content: flex-end;
        }
        
		.main-link {
		    text-decoration: none;
		    color: #333;
		}
		
		.main-link:hover {
		    text-decoration: none; /* 호버 시에 밑줄 추가 */
		}
        input[type="text"] {
            padding: 8px;
            border: none; /* Remove border */
            border-radius: 5px;
        }

        button {
            background-color: #3498db;
            color: #fff;
            padding: 8px 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2a78b9; /* Darker blue on hover */
        }
    </style>
</head>
<body>
    <header>
        <div class="user-links">
            <c:choose>
                <c:when test="${userId ne null}">
                    <a href="<c:url value='/user/logout'/>">${userId}(로그아웃)</a>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value='/user/loginForm'/>">로그인</a>
                </c:otherwise>
            </c:choose>
            <c:choose>
			    <c:when test="${userId ne null}">
			        <c:choose>
			            <c:when test="${userId eq 'admin'}">
			                <!-- 'admin'일 때 보여줄 링크 또는 내용 -->
			                <a href="<c:url value='/user/list'/>">회원관리</a>
			            </c:when>
			        </c:choose>
			    </c:when>
			</c:choose>
            <a href="<c:url value='/user/joinForm' />">회원가입</a>
        </div>
        <a class="main-link" href="<c:url value='/main'/>">
		    <h1>Hobby Friends</h1>
		</a>
        <form id="form" method="post" action="<c:url value='/post/search' />" >
	      <div class="search-bar">
	          <input type="text" placeholder="검색어를 입력하세요" name="keyword">
	          <button type="button" onclick="search()">검색</button>
	      </div>
        </form>
    </header>

    <!-- Bootstrap Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="<c:url value='/main' />">홈</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/mypage/mypage' />">마이페이지</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/post/add' />">모집하기</a>
                </li>
            </ul>
        </div>
    </nav>

    <section>
        <!-- Content goes here -->
    </section>

    <!-- Include Bootstrap JS and Popper.js (required for Bootstrap JS) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
   	<script>
   		function search() {
   			form.submit();
   		}
	</script>
</body>
</html>
