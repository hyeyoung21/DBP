<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	User user = (User)request.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Information Update</title>
    <style>
        /* 공통 CSS */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        select,
        input[type="number"] {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="button"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }

        input[type="button"]:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
    </style>
    <script>
		function userModify() {
			form.submit();
		}
		
		function userList(targetUri) {
			form.action = targetUri;
			form.submit();
		}
</script>
</head>
<body>
    <form id="form" method="post" action="<c:url value='/user/update' />"> <!-- updateUserInfoServlet은 실제로 정보를 업데이트하는 서블릿 경로일 수 있습니다 -->
        <label for="userId">아이디</label>
        <input type="text" id="userId" name="userId" value="${user.userId}" required><br><br>

        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" value="${user.password}" required><br><br>

        <label for="name">이름</label>
        <input type="text" id="name" name="name" value="${user.name}" required><br><br>

        <label for="email">이메일</label>
        <input type="email" id="email" name="email" value="${user.email}" required><br><br>

        <label for="location">거주 지역</label>
        <input type="text" id="location" name="location" value="${user.location}" required><br><br>

        <label for="age">나이</label>
        <input type="number" id="age" name="age" value="${user.age}" required><br><br>
		
		<label for="gender">성별</label>
		<select id="gender" name="gender" required>
		    <option value="Male" ${user.gender eq 'Male' ? 'selected' : ''}>Male</option>
		    <option value="Female" ${user.gender eq 'Female' ? 'selected' : ''}>Female</option>
		</select><br>
		
		<label for="age">신고 횟수</label>
        <input type="number" id="reportCount" name="reportCount" value="${user.reportCount}" required><br><br>

        <table style="width: 100%">
		  <tr>
			<td align="left">
			<input type="button" value="수정" onClick="userModify()"> &nbsp;
			<input type="button" value="목록" onClick="userList('<c:url value='/user/list' />')">
			</td>
		  </tr>
	    </table>
    </form>
</body>
</html>
