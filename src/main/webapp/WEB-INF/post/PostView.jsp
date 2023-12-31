<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Report" %>
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
    <%@include file="/WEB-INF/navi.jsp" %>
    <script>
        function showInput() {
            var inputContainer = document.getElementById("inputContainer");
            inputContainer.style.display = "block";
        }
        function sendApply() {
        	if (<c:if test="${not empty isDuplicate and isDuplicate eq true}">true</c:if>) {
                alert("중복된 신청입니다.");
            } else{
            	var msg = document.getElementsByClassName('ApplyMessage');
                msg.value = "";
                apply-form.submit();
            }
            
        }
        function updatePost(commentID) {
        	update-form.submit();
        }
        function addComment() {
        	addComment-form.submit();
        }
        function reportPost() {
        	reportPost-form.submit();
        }
        function reportComment() {
            var form = document.getElementById("reportComment-form");
            form.action = "<c:url value='/report/report'/>";
            form.submit();
        } 
        function deletePost() {
        	alert("삭제 됐습니다");
        }

    </script>

    <h3 class="display-6 text-left">${post.title}</h3>
    <span class="text-muted">작성자: ${post.creator}</span>
	
	
	<hr size="10px"/>

    <form id="blog-form">
	    <div class="row">
	        <div class="col-md-6">
	            <div class="form-group">
	                <h6><strong>모집 인원:</strong></h6>
	                <span class="text-muted">${post.maxParticipants}명</span>
	            </div>
	
	            <div class="form-group">
	                <h6><strong>모집 성별:</strong></h6>
	                <span class="text-muted">${post.gender}</span>
	            </div>
	
	            <div class="form-group">
	                <h6><strong>모집 나이:</strong></h6>
	                <span class="text-muted">${post.age}</span>
	            </div>
	        </div>
	
	        <div class="col-md-6">
	            <div class="form-group">
	                <h6><strong>카테고리:</strong></h6>
	                <span class="text-muted">${post.meetingType}</span>
	            </div>
	
	            <div class="form-group">
	                <h6><strong>모임 위치:</strong></h6>
	                <span class="text-muted">${post.location}</span>
	            </div>
	
	            <div class="form-group">
	                <h6><strong>모임 날짜:</strong></h6>
	                <span class="text-muted">${post.dateTime}</span>
	            </div>
	        </div>
	    </div>

        <hr size="10px"/>

        <div id="blog-content">${post.content}</div>
    </form>

	    <input type="hidden" id="postId" name="postId" value="${post.id}">
	    <div class="btn-container">
			<c:if test="${userId ne post.creator }">
    			<button class="btn btn-primary" onclick="showInput()">신청하기</button>
    			<a class="btn btn-info" href="<c:url value='/msg/view'>
                            <c:param name='yourId' value='${post.creator}'/>
                            <c:param name='myId' value='${userId}'/>
                        </c:url>">
                        쪽지 보내기
                </a>
    			<form id='reportPost-form' method='post' action="<c:url value='/report/report'/>" style="display: inline;">
        			<input type="hidden" id="type" name="type" value="게시글">
        			<input type="hidden" id="postId" name="postTitle" value="${post.title}">
        			<input type="hidden" id="userId" name="userId" value="${post.creator}">
        			<input type="hidden" id="content" name="content" value="${post.content}">
        			<button class="btn btn-danger" onclick="reportPost()">신고하기</button>
    			</form>
			</c:if>
		    <c:if test="${userId eq post.creator }">
	    		<input type="hidden" id="userId" name="userId" value="${userId}">
               	<input type="hidden" id="postId" name="postId" value="${post.id}">
		    	<a class="btn btn-danger" href='<c:url value='/post/delete'>
		    		<c:param name="postId" value="${post.id}"/> </c:url>'> 삭제</a>
		    	<a class="btn btn-warning" href='<c:url value='/post/update'> 
			    	<c:param name="postId" value="${post.id}"/> </c:url>'> 수정</a>
		    </c:if>
	    </div>

    <div id="inputContainer" style="display: none;">
        <form id="apply-form" method="post" action="<c:url value='/apply/add' />">
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

<div class="mt-5">
    <form id="addComment-form" method="post" action="<c:url value='/comment/add' />">
        <h3>댓글 작성</h3>
        <textarea class="form-control" id="content" name="content" rows="4" required></textarea>
        <input type="hidden" id="userId" name="userId" value="${userId}">
        <input type="hidden" id="postId" name="postId" value="${post.id}">
        <button class="btn btn-primary mt-3" onclick="addComment()" name="action" value="add">댓글 작성</button>
    </form>

    <ul id="comment-list" class="list-group mt-3">
        <c:forEach var="comment" items="${commentList}">
            <li class="list-group-item">
                <div class="row">
                    <div class="col-md-2">
                        <span class="text-muted">${comment.userID}</span>
                    </div>
                    <div class="col-md-8">
                        <span class="text-muted">${comment.commentDate}</span>
                    </div>
                    <div class="col-md-2">
                        <c:if test="${userId ne comment.userID}">
                            <form id='reportComment-form-${comment.commentID}' method='post' action="<c:url value='/report/report'/>">
                                <input type="hidden" id="type" name="type" value="댓글">
                                <input type="hidden" id="postId" name="postTitle" value="${post.title}">
                                <input type="hidden" id="userId" name="userId" value="${comment.userID}">
                                <input type="hidden" id="content" name="content" value="${comment.content}">
                                <button class="btn btn-danger" onclick="reportComment()" name="action" value="reportComment">신고하기</button>
                            </form>
                        </c:if>
                        <c:if test="${userId eq comment.userID}">
                            <form id='deleteComment-form-${comment.commentID}' method='post' action="<c:url value='/comment/delete'/>">
                                <input type="hidden" name="commentID" value="${comment.commentID}">
                                <input type="hidden" name="postID" value="${comment.postID}">
                                <button class="btn btn-warning" onclick="deleteComment()">삭제</button>
                            </form>
                        </c:if>
                    </div>
                </div>
                <div class="mt-2">
                    <p>${comment.content}</p>
                </div>
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
