<!DOCTYPE html>
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <title>회원가입 폼</title>
    <style>
        body {
            background-color: #ffffff;
            font-family: Arial, sans-serif;
            margin: 0;
        }

        form {
            background-color: #f0f0f0;
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333333;
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333333;
        }

        input, select {
            width: calc(100% - 16px);
            padding: 8px;
            margin-bottom: 12px;
            box-sizing: border-box;
        }

        input[type="submit"], input[type="button"] {
            background-color: #007bff;
            color: #ffffff;
            cursor: pointer;
            border: none;
            border-radius: 4px;
            padding: 8px;
            font-size: 12px;
        }

        input[type="submit"]:hover, input[type="button"]:hover {
            background-color: #0056b3;
        }

        .duplicate-check {
            display: flex;
            align-items: center;
        }

        .duplicate-check input {
            margin-bottom: 0;
        }

        .duplicate-check label {
            margin-bottom: 0;
            margin-right: 8px;
        }
    </style>
    <script>
        function validateForm() {
            // 클라이언트 측 유효성 검사 로직 추가
            return true;
        }
    </script>
</head>
<body>
    <h2>회원가입</h2>
    <form action="joinProcess.jsp" method="post" onsubmit="return validateForm()">
        <label for="userId">아이디:</label>
        <input type="text" id="userId" name="userId" required>
        <button type="button" onclick="checkDuplicate()">중복확인</button><br>

        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required><br>
        
        <label for="confirmPassword">비밀번호 확인:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required><br>

        <label for="email">이메일:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="phone">전화번호:</label>
        <input type="tel" id="phone" name="phone"><br>

        <label for="gender">성별:</label>
        <select id="gender" name="gender">
            <option value="male">남성</option>
            <option value="female">여성</option>
        </select><br>

        <label for="birthdate">생년월일 (YYYYMMDD):</label>
        <input type="text" id="birthdate" name="birthdate" placeholder="YYYYMMDD" pattern="\d{8}" required>

        <input type="submit" value="가입하기">
    </form>

    <script>
        function checkDuplicate() {
            // 아이디 중복 확인
            alert("중복 확인을 수행합니다.");
        }
    </script>
</body>
</html>
