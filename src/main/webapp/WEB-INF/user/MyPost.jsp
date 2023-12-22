<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <title>Post List</title>
</head>
<body>

<c:choose>
    <c:when test="${empty postList}">
        <div class="alert alert-info" role="alert">
            작성한 글이 없습니다.
        </div>
    </c:when>
    <c:otherwise>
        <ul id="blog-list" class="list-group">
            <c:forEach var="post" items="${postList}">
                <li class="list-group-item">
                    <a href="<c:url value='/post/view'><c:param name='id' value='${post.id}'/></c:url>"
                       class="text-decoration-none text-dark">
                        <h3>${post.title}</h3>
                        <p class="btn btn-primary">${post.location}</p>
                        <p class="btn btn-success">${post.maxParticipants}명</p>
                        <p class="btn btn-danger">${post.gender}</p>
                        <p class="btn btn-warning">${post.meetingType}</p>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>

<!-- Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.2/js/bootstrap.min.js"></script>

</body>
</html>
