<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	@SuppressWarnings("unchecked") 
	List<Apply> apply = (List<Apply>)request.getAttribute("apply");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
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

	
	<table>
		<tr>
			<th>사용자</th>
			<th>신청 상태</th>
			<th>메세지</th>
		</tr>
		<c:forEach var="apply" items="${apply}">
			<tr>
				<td>${apply.userID}</td>
				<td>${apply.status}</td>
				<td>${apply.description}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>