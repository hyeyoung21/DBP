<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	@SuppressWarnings("unchecked") 
	List<User> userList = (List<User>)request.getAttribute("userList");
	// String curUserId = (String)request.getAttribute("curUserId"); // 현재 아이디
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>User Information</title>
  <style>
    /* CSS 스타일링 */
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
    }
    table {
      width: 80%;
      margin: 20px auto;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      border-collapse: collapse;
    }
    th, td {
      padding: 12px;
      text-align: left;
      border-bottom: 1px solid #ccc;
    }
    th {
      background-color: #f2f2f2;
    }
    tr:hover {
      background-color: #f9f9f9;
    }
	a {
	    text-decoration: none; 
	    color: #0366d6;
	    transition: color 0.3s; 
	}
	
	a:hover {
    	color: #0645ad;
	}
  </style>
</head>
<body>

<table>
  <thead>
    <tr>
      <th>아이디</th>
      <th>이름</th>
      <th>나이</th>
      <th>성별</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
  
  	<c:forEach var="user" items="${userList}">
  	<tr>
	      <td>${user.userId}</td>
	      <td>${user.name}</td>
	      <td>${user.age}</td>
	      <td>${user.gender}</td>
	      <td>
		      <a href="<c:url value='/user/view'>
					   <c:param name='userId' value='${user.userId}'/>
			 		 </c:url>">수정
			  </a>
		  </td>
	    </tr>
	    
    </c:forEach> 
  </tbody>
</table>


</body>
</html>
