<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <title>User Information Update</title>
</head>
<body>
    <form id="userForm" method="post" action="updateUserInfoServlet"> <!-- updateUserInfoServlet은 실제로 정보를 업데이트하는 서블릿 경로일 수 있습니다 -->
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required><br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select><br><br>

        <input type="submit" value="Update">
    </form>
</body>
</html>
