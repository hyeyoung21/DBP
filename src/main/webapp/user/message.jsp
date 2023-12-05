<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>쪽지 대화창</title>
  <link rel="stylesheet" href="message.css">
</head>
<body>
  <div class="container">
    <div class="messages">
      <div class="message received">
        <span class="content">안녕하세요!</span>
      </div>
      <div class="message sent">
        <span class="content">안녕하세요! 반가워요!</span>
      </div>
      <!-- 여기에 더 많은 메시지를 추가할 수 있습니다. -->
    </div>
    <div class="input-box">
      <input id="messageInput" type="text" placeholder="메시지를 입력하세요...">
      <button onclick="sendMessage()">전송</button>
    </div>
  </div>

  <script>
    function sendMessage() {
      const messageInput = document.getElementById('messageInput');
      const messageContent = messageInput.value;

      if (messageContent.trim() !== '') {
        const messagesContainer = document.querySelector('.messages');
        const newMessage = document.createElement('div');
        newMessage.classList.add('message', 'sent');
        newMessage.innerHTML = `<span class="content">${messageContent}</span>`;
        messagesContainer.appendChild(newMessage);

        messageInput.value = ''; // 입력창 초기화
      }
    }
  </script>
</body>
</html>
