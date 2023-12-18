<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    @SuppressWarnings("unchecked") 
    List<Post> applyList = (List<Post>)request.getAttribute("applyList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Apply Title</title>
    <style>
        /* 기본적인 스타일 */
        li {
            list-style-type: disc; /* 리스트 마커 스타일 */
            margin: 8px 0; /* 위아래 여백 */
            padding: 8px; /* 내부 여백 */
            border: 1px solid #ddd; /* 테두리 스타일 */
            background-color: #f9f9f9; /* 배경색 */
            color: #333; 
        }

        li:hover {
            background-color: #f0f0f0; 
        }
        a {
            text-decoration: none;
            color: #333;
        }

        a:hover {
            color: #555; 
        }
    </style>
</head>
<body>
    <ul id="list">
        <c:forEach var="post" items="${applyList}">
            <li>
                <a href="<c:url value='/apply/view'>
                        <c:param name='id' value='${post.id}'/>
                    </c:url>">
                    ${post.id} : ${post.title}
                </a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
