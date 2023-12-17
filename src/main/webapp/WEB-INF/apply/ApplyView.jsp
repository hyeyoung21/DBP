<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	@SuppressWarnings("unchecked") 
	List<Apply> applyList = (List<Apply>)request.getAttribute("applyList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>ApplyList</title>
	<script>
		function modify() {
			form.submit();
		}
	</script>
	<style>
		body {
			display: flex;
			align-items: center;
			justify-content: center;
			height: 100vh;
			margin: 0;
		}

		table {
			border-collapse: collapse;
			width: 50%;
		}

		th, td {
			border: 1px solid #ddd;
			padding: 8px;
			text-align: left;
		}
		th {
			background-color: #f2f2f2;
		}
	</style>
</head>
<body>	
	<form id="form" action="<c:url value='/apply/modify' />" method="post">
		<table>
			<tr>
				<th>사용자</th>
				<th>신청 상태</th>
				<th>메세지</th>
				<th>수정</th>
			</tr>
			<c:forEach var="apply" items="${applyList}">
				<tr>
					<td>${apply.userID}</td>
					<td>${apply.status}</td>
					<td>${apply.description}</td>
					<td>
						<input type="hidden" name="applyID" value="${apply.getStringID()}">
						<button type="submit" onclick="modify()" name="action" value="edit">수정</button> &nbsp;
				        <button type="submit" onclick="modify()" name="action" value="delete">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<c:url value='list' />"> 목록 </a>
	</form>
</body>
</html>