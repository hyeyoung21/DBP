<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>채팅 목록</title>
  <style>
    /* 스타일링 */
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
      height: calc(100vh - 80px); /* 상단 추가 버튼 고려한 높이 */
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

    /* 추가 버튼 스타일 */
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
      <button class="add-button" onclick="redirectToMessage()">추가</button>
      <div class="conversation" onclick="openChat('사람1')">
        <div class="info">
          <span class="name">솜솜이</span>
          <span class="last-message">그렇다면 같이 마라탕 드실래요?</span>
        </div>
      </div>
      <div class="conversation" onclick="openChat('사람2')">
        <div class="info">
          <span class="name">컴솜이</span>
          <span class="last-message">같이 프로젝트 하실래요?</span>
        </div>
      </div>
      <!-- 필요한 만큼 대화창을 추가하세요 -->
    </div>
  </div>

  <script>
    function redirectToMessage() {
      window.location.href = 'message.html';
    }

    // 다른 함수들은 그대로 유지합니다.
    const chatList = {
      '사람1': ['솜솜님 여전히 마라탕 먹을 사람 찾고 계신가요?', '그렇다면 같이 마라탕 드실래요?'],
      '사람2': ['웹 프로젝트 할 사람 구합니다'],
      '사람3': ['같이 프로젝트 하실래요?']
      // 필요한 만큼 대화 내용을 추가하세요
    };

    function openChat(person) {
      // 선택한 대화 내용을 가져와 화면에 표시
      const conversation = chatList[person] || [];
      conversation.forEach(message => {
        console.log(message);
      });
    }
  </script>
</body>
</html>
