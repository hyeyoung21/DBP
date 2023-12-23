<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ApplyList</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>    
    <div class="container">
        <form id="form" action="<c:url value='/apply/modify' />" method="post">
            <table class="table table-bordered">
                <thead class="thead-light">
                    <tr>
                        <th>포스트</th>
                        <th>신청 상태</th>
                        <th>메세지</th>
                        <th>수정</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="apply" items="${applyList}">
                        <tr>
                            <td>${apply.postTitle}</td>
                            <td>${apply.status}</td>
                            <td>${apply.description}</td>
                            <td>
                                <input type="hidden" name="applyID" value="${apply.getStringID()}">
                                <button type="submit" class="btn btn-danger" name="action" value="delete">삭제</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="<c:url value='list' />" class="btn btn-secondary">목록</a>
        </form>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
