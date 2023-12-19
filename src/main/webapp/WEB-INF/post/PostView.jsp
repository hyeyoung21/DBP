<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
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

        #blog-content {
            width: 100%;
            height: 300px;
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 20px;
            font-size: 16px;
            color: #333;
        }

        .btn-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <script>
        function showInput() {
            var inputContainer = document.getElementById("inputContainer");
            inputContainer.style.display = "block";
        }
        function sendApply() {
            var msg = document.getElementsByClassName('ApplyMessage');
            msg.value = "";
            form.submit();

        }
    </script>

    <h2 id="blog-title">${post.title}</h2>

    <form id="blog-form">
        <div class="form-group">
            <strong>모집 인원:</strong>
            <span id="recruitment-num">${post.maxParticipants}명</span>
            <br>
            <strong>모집 성별:</strong>
            <span id="recruitment-gender">${post.gender}</span>
            <br>
            <strong>모집 나이:</strong>
            <span id="recruitment-age">${post.age}</span>
        </div>

        <div class="form-group">
            <strong>카테고리:</strong>
            <span id="category">${post.meetingType}</span>
            <br>
            <strong>모임 위치:</strong>
            <span id="location">${post.location}</span>
            <br>
            <strong>모임 날짜:</strong>
            <span id="date">${post.dateTime}</span>
        </div>

        <hr size="10px"/>

        <div id="blog-content">${post.content}</div>
    </form>

    <div class="btn-container">
        <button class="btn btn-primary" onclick="showInput()">신청하기</button>
        <button class="btn btn-info" onclick="sendMessage()">쪽지 보내기</button>

        <div id="inputContainer" style="display: none;">
            <form id="form" method="post" action="<c:url value='/apply/add' />">
			    <div class="form-group">
			        <label for="ApplyMessage">메세지를 입력하세요 :</label>
			        <div class="input-group">
	                   <input type="hidden" id="userId" name="userId" value="${userId}">
	                   <input type="hidden" id="postId" name="postId" value="${post.id}">
			           <input type="text" class="form-control" id="ApplyMessage" name="ApplyMessage">
			           <div class="input-group-append">
			               <button class="btn btn-success" onclick="sendApply()">신청</button>
			           </div>
			        </div>
			    </div>
			</form>
        </div>
    </div>

    <div id="comment-form" class="mt-5">
        <h3>댓글 작성</h3>
        <textarea class="form-control" id="comment-content" rows="4" required></textarea>

        <button class="btn btn-primary mt-3" onclick="addComment()">댓글 작성</button>

        <ul id="comment-list" class="list-group mt-3">
            <c:forEach var="comment" items="${commentList}">
                <li class="list-group-item">
                    <span class="comment-author">${comment.userID}</span>
                    <span class="comment-body">${comment.description}</span>
                </li>
            </c:forEach>
        </ul>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
