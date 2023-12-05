<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <title>User Information</title>
</head>
<body>
    <h1>User Information</h1>

    <p><strong>User ID:</strong> <span id="userId">...</span></p>
    <p><strong>Password:</strong> <span id="password">...</span></p>
    <p><strong>Name:</strong> <span id="name">...</span></p>
    <p><strong>Email:</strong> <span id="email">...</span></p>
    <p><strong>Report Count:</strong> <span id="reportCount">...</span></p>
    <p><strong>Location:</strong> <span id="location">...</span></p>
    <p><strong>Age:</strong> <span id="age">...</span></p>
    <p><strong>Gender:</strong> <span id="gender">...</span></p>

    <!-- 수정 버튼 -->
    <button onclick="editUserInfo()">수정</button>

    <!-- 삭제 버튼 -->
    <button onclick="deleteUserInfo()">삭제</button>

    <script>
        function editUserInfo() {
            // 여기에 수정을 위한 작업을 추가할 수 있습니다.
            // 예를 들어, 각 정보를 수정 가능한 input 요소로 교체하거나,
            // 수정을 위한 폼을 보여줄 수 있습니다.
        }

        function deleteUserInfo() {
            // 여기에 삭제를 위한 작업을 추가할 수 있습니다.
            // 예를 들어, 삭제 확인 창을 띄우거나,
            // 삭제를 서버로 요청하는 기능을 추가할 수 있습니다.
        }
    </script>
</body>
</html>
