<!DOCTYPE html>
<html lang="en">
<head>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <title>사용자 목록</title>
  <style>
    ul {
      list-style: none;
      padding: 0;
    }
    li {
      margin-bottom: 5px;
      cursor: pointer;
      color: blue;
    }
  </style>
</head>
<body>

<h2>사용자 목록</h2>

<ul id="user-list">
  <li data-id="1">사용자 1</li>
  <li data-id="2">사용자 2</li>
  <li data-id="3">사용자 3</li>
  <!-- 여기에 더 많은 사용자 추가 가능 -->
</ul>

<div id="user-details">
  <!-- 사용자 정보가 여기에 나타남 -->
</div>

<script>
  const userList = document.getElementById("user-list");
  const userDetails = document.getElementById("user-details");

  userList.addEventListener("click", (event) => {
    if (event.target.tagName === "LI") {
      const userId = event.target.getAttribute("data-id");
      // 여기에서는 각 사용자를 클릭했을 때 사용자 정보를 보여주는 함수를 호출하면 됩니다.
      showUserDetails(userId);
    }
  });

  function showUserDetails(userId) {
    // 여기에서는 각 사용자 정보를 가져오는 과정이 있어야 합니다.
    // 예를 들어, 각 사용자에 대한 정보를 가진 객체를 가져온다고 가정하고 정보를 출력합니다.
    const users = {
      1: { name: "사용자 1", email: "user1@example.com", age: 25 },
      2: { name: "사용자 2", email: "user2@example.com", age: 30 },
      3: { name: "사용자 3", email: "user3@example.com", age: 28 }
      // 사용자 정보에 대한 더 많은 데이터 추가 가능
    };

    const user = users[userId];
    if (user) {
      userDetails.innerHTML = `
        <h2>${user.name}</h2>
        <p>Email: ${user.email}</p>
        <p>나이: ${user.age}</p>
        <!-- 사용자 정보에 대한 다른 세부사항 추가 가능 -->
      `;
    } else {
      userDetails.innerHTML = "<p>사용자를 찾을 수 없습니다.</p>";
    }
  }
</script>

</body>
</html>