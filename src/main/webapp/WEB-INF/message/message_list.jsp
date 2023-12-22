<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*, model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Apply Title</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        #list {
            list-style-type: none;
            padding: 0;
        }

        #list li {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
        }

        #list li a {
            text-decoration: none;
            color: #000;
        }

        #list li a:hover {
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>
    <div class="container">
        <ul id="list">
            <c:forEach var="user" items="${userList}">
                <li>
                    <a href="<c:url value='/msg/view'>
                            <c:param name='userId' value='${user}'/>
                        </c:url>">
                        ${user}와의 대화
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
