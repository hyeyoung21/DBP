<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>MyPage</title>
  <style>
    /* 스타일링 */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }

    .container {
      max-width: 600px;
      margin: 20px auto;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      overflow: hidden;
      padding: 20px;
    }

    .button-container {
      display: flex;
      flex-direction: column;
      gap: 15px;
    }

    .button {
      background-color: #4caf50;
      color: #fff;
      border: none;
      padding: 15px;
      font-size: 18px;
      cursor: pointer;
      border-radius: 8px;
      transition: background-color 0.3s;
    }

    .button:hover {
      background-color: #45a049;
    }

    .calendar-button {
      background-color: #3498db;
    }

    .calendar-button:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>MyPage</h2>
    <div class="button-container">
      <button class="button">내가 쓴 글 보기</button>
      <button class="button">내가 쓴 댓글 보기</button>
      <button class="button">나의 개인정보 확인하기</button>
      <button class="button calendar-button">캘린더</button>
      <button class="button">쪽지함</button>
    </div>
  </div>
</body>
</html>
