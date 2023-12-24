<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	User user = (User)request.getAttribute("user");
%>
<head>
  <meta charset="UTF-8">
  <title>User Details</title>
  <style>
    /* CSS 스타일링 */
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }
    .container {
      width: 80%;
      margin: 0 auto;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      padding: 20px;
    }
    h1 {
      text-align: center;
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }
    th, td {
      padding: 12px;
      text-align: left;
      border-bottom: 1px solid #ccc;
    }
    th {
      background-color: #f2f2f2;
    }
    .button-container {
      text-align: right;
      margin-top: 20px;
    }
    .button-container a {
      display: inline-block;
      padding: 10px 20px;
      border-radius: 5px;
      text-decoration: none;
      color: #fff;
      margin-left: 10px;
    }
    .button-container a.delete {
      background-color: #dc3545;
    }
    .button-container a.edit {
      background-color: #007bff;
    }
    .button-container a:hover {
      opacity: 0.8;
    }
  </style>
</head>
<body>

<div class="container">
  <h1>사용자 세부정보</h1>
  <table>
    <tr>
      <th>아이디</th>
      <td>${user.userId}</td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td>${user.password}</td>
    </tr>
    <tr>
      <th>이름</th>
      <td>${user.name}</td>
    </tr>
    <tr>
      <th>나이</th>
      <td>${user.age}</td>
    </tr>
    <tr>
      <th>성별</th>
      <td>${user.gender}</td>
    </tr>
    <tr>
      <th>email</th>
      <td>${user.email}</td>
    </tr>
    <tr>
      <th>거주 지역</th>
      <td>${user.location}</td>
    </tr>
    <tr>
      <th>신고 횟수</th>
      <td>${user.reportCount}</td>
    </tr>
    
    <!-- 추가적인 사용자 정보는 위와 같이 추가할 수 있습니다 -->
  </table>
  
  <div class="button-container">
  	<a href="<c:url value='/user/update'>
					   <c:param name='userId' value='${user.userId}'/>
			 		 </c:url>" class="edit">수정</a>
	 <a href="<c:url value='/user/delete'>
					   <c:param name='userId' value='${user.userId}'/>
			 		 </c:url>" class="delete">삭제</a>
	<%-- <a href="<c:url value='/user/delete'>
					   <c:param name='userId' value='${user.userId}'/>
			 		 </c:url>" class="delete">삭제</a> --%>
  </div>
</div>

</body>
</html>
