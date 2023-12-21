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
</head>
<body>
    <form id="deleteComment-form" method="post" action="<c:url value='/comment/delete' />" >
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
		               <c:if test="${userId eq comment.userID}">
		                <div class="col-md-2">
		                    <a href="<c:url value='/comment/delete'>
								  		<c:param name='commentID' value='${comment.commentID}'/>
						 			 </c:url>">삭제
						 	</a>
		                </div>
		               </c:if>
		           </div>
		           <div class="mt-2">
		               <p>${comment.content}</p>
		           </div>
		       </li>
		   </c:forEach>
		</ul>
	</form>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
