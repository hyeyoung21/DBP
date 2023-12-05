<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        /* Reset some default styles */
        body, h2, form {
            margin: 0;
            padding: 0;
        }

        body {
            background-color: #ffffff; /* White background */
            font-family: Arial, sans-serif; /* Choose a suitable font */
        }

        form {
            background-color: #f0f0f0; /* Light gray background for the form */
            max-width: 300px; /* Adjust the width of the form */
            margin: 50px auto; /* Center the form on the page */
            padding: 20px; /* Add some padding inside the form */
            border-radius: 8px; /* Add rounded corners to the form */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Add a subtle box shadow */
        }

        h2 {
            color: #333333; /* Dark gray text color for the heading */
            text-align: center;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #333333; /* Dark gray text color for labels */
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #007bff; /* Blue color for the submit button */
            color: #ffffff; /* White text color for the button */
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3; /* Darker blue color on hover */
        }

        .links {
            text-align: center;
            margin-top: 10px;
        }

        .links a {
            margin: 0 10px;
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>
<body>

    <form action="loginProcess.jsp" method="post">
        <h2>로그인</h2>
        <label for="username">ID</label>
        <input type="text" id="username" name="username" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <input type="submit" value="Login">
        <div class="links">
            <a href="join.jsp">회원가입</a>
            <a href="#">ID/PW 찾기</a>
        </div>
    </form>

</body>
</html>