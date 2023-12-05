<!DOCTYPE html>
<html lang="en">
<head>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <title>MyPage</title>
  <style>
    /* ì¤íì¼ë§ */
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
      <button class="button">ë´ê° ì´ ê¸ ë³´ê¸°</button>
      <button class="button">ë´ê° ì´ ëê¸ ë³´ê¸°</button>
      <button class="button">ëì ê°ì¸ì ë³´ íì¸íê¸°</button>
      <button class="button calendar-button">ìºë¦°ë</button>
      <button class="button">ìª½ì§í¨</button>
    </div>
  </div>
</body>
</html>
