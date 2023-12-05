<!DOCTYPE html>
<html lang="en">
<head>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <title>ì±í ëª©ë¡</title>
  <style>
    /* ì¤íì¼ë§ */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }

    .container {
      max-width: 400px;
      margin: 20px auto;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      overflow: hidden;
    }

    .chat-list {
      border-right: 1px solid #ccc;
      height: calc(100vh - 80px); /* ìë¨ ì¶ê° ë²í¼ ê³ ë ¤í ëì´ */
      overflow-y: auto;
    }

    .conversation {
      padding: 20px;
      border-bottom: 1px solid #ccc;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    .conversation:hover {
      background-color: #f0f0f0;
    }

    .info {
      margin-left: 10px;
    }

    .name {
      font-weight: bold;
    }

    /* ì¶ê° ë²í¼ ì¤íì¼ */
    .add-button {
      background-color: #4caf50;
      color: #fff;
      border: none;
      padding: 15px 20px;
      font-size: 16px;
      cursor: pointer;
      width: 100%;
      box-sizing: border-box;
      text-align: left;
    }

    .add-button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="chat-list">
      <button class="add-button" onclick="redirectToMessage()">ì¶ê°</button>
      <div class="conversation" onclick="openChat('ì¬ë1')">
        <div class="info">
          <span class="name">ììì´</span>
          <span class="last-message">ê·¸ë ë¤ë©´ ê°ì´ ë§ë¼í ëì¤ëì?</span>
        </div>
      </div>
      <div class="conversation" onclick="openChat('ì¬ë2')">
        <div class="info">
          <span class="name">ì»´ìì´</span>
          <span class="last-message">ê°ì´ íë¡ì í¸ íì¤ëì?</span>
        </div>
      </div>
      <!-- íìí ë§í¼ ëíì°½ì ì¶ê°íì¸ì -->
    </div>
  </div>

  <script>
    function redirectToMessage() {
      window.location.href = 'message.html';
    }

    // ë¤ë¥¸ í¨ìë¤ì ê·¸ëë¡ ì ì§í©ëë¤.
    const chatList = {
      'ì¬ë1': ['ììë ì¬ì í ë§ë¼í ë¨¹ì ì¬ë ì°¾ê³  ê³ì ê°ì?', 'ê·¸ë ë¤ë©´ ê°ì´ ë§ë¼í ëì¤ëì?'],
      'ì¬ë2': ['ì¹ íë¡ì í¸ í  ì¬ë êµ¬í©ëë¤'],
      'ì¬ë3': ['ê°ì´ íë¡ì í¸ íì¤ëì?']
      // íìí ë§í¼ ëí ë´ì©ì ì¶ê°íì¸ì
    };

    function openChat(person) {
      // ì íí ëí ë´ì©ì ê°ì ¸ì íë©´ì íì
      const conversation = chatList[person] || [];
      conversation.forEach(message => {
        console.log(message);
      });
    }
  </script>
</body>
</html>
