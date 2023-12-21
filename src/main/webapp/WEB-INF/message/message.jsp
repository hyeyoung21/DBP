<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>1:1 채팅</title>
  <!-- 부트스트랩 CDN 추가 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form id="form" method="post" action="<c:url value='/msg/add' />" >
	<div class="container">
	  <div class="row">
	    <div class="col-md-6 offset-md-3">
	      <div class="card">
	        <div class="card-header">
	          1:1 채팅
	        </div>
	        <div class="card-body" id="chat-box">
	          <c:forEach var="message" items="${msgList}">
	            <p><strong>${message.senderID}:</strong> ${message.content}</p>
	            
	          </c:forEach>
	        </div>
	        <div class="card-footer">
	          <div class="input-group">
	            <input type="text" class="form-control" placeholder="메시지를 입력하세요" name="content">
	            <input type="hidden" name="recvId" value="${senderId}" >
	            <input type="hidden" name="sendId" value="${userId}">
	            <button class="btn btn-primary" onclick="sendMessage()">전송</button>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>
</form>

<!-- 부트스트랩 및 jQuery CDN 추가 -->
<script src="https://code.jquery.com/jquery-3.6.4.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script>
	function sendMessage() {
		form.submit()
	}
</script>

</body>
</html>
