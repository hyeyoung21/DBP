<!DOCTYPE html>
<html lang="en">
<head>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="style.css">
  <title>ëª¨ì§ ì ë³´</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }

    #blog-form {
      display: flex;
      flex-wrap: wrap;
    }

    .form-group {
      width: 50%;
      box-sizing: border-box;
      padding: 0 10px;
    }

    #blog-form label, #blog-form input, #blog-form select, #blog-form textarea {
      width: 100%;
      margin-bottom: 10px;
      box-sizing: border-box;
    }

    #blog-content {
      width: 100%;
      height: 300px; /* ì¸ë¡ ê¸¸ì´ ì¡°ì  */
    }

    #blog-form button {
      width: 100%;
    }

    #blog-list {
      list-style-type: none;
      padding: 0;
    }

    .blog-item {
      border: 1px solid #ccc;
      padding: 10px;
      margin-bottom: 10px;
    }

  </style>
</head>
<body>

  <h1>ëª¨ì§ ì ë³´</h1>

  <form id="blog-form">
    <div class="form-group">
      <label for="recruitment-num">ëª¨ì§ ì¸ì:</label>
      <input type="number" id="recruitment-num" required>

      <label for="recruitment-gender">ëª¨ì§ ì±ë³:</label>
      <select id="recruitment-gender" required>
        <option value="male">ë¨ì±</option>
        <option value="female">ì¬ì±</option>
        <option value="any">ëª¨ë</option>
      </select>

      <label for="recruitment-age">ëª¨ì§ ëì´:</label>
      <input type="text" id="recruitment-age" required>
    </div>

    <div class="form-group">
      <label for="category">ì¹´íê³ ë¦¬:</label>
      <select id="category" required>
        <option value="study">ì¤í°ë</option>
        <option value="exercise">ì´ë</option>
        <option value="plant">ìì</option>
        <option value="handicraft">ìê³µì</option>
        <option value="performance">ê³µì°</option>
        <option value="art">ë¯¸ì </option>
        <option value="game">ê²ì</option>
      </select>

      <label>
        ëª¨ì ìì¹:
        <select id="location" onchange="searchBlog()">
          <option value="seoul">ìì¸</option>
          <option value="gyeonggi">ê²½ê¸°</option>
          <option value="sejong">ì¸ì¢</option>
          <option value="incheon">ì¸ì²</option>
          <option value="chungbuk">ì¶©ë¶</option>
          <option value="chungnam">ì¶©ë¨</option>
          <option value="gangwon">ê°ì</option>
          <option value="jeonnam">ì ë¨</option>
          <option value="jeonbul">ì ë¶</option>
          <option value="gwangju">ê´ì£¼</option>
          <option value="geongbuk">ê²½ë¶</option>
          <option value="geongnam">ê²½ë¨</option>
          <option value="jeju">ì ì£¼</option>
          <option value="ulsam">ì¸ì°</option>
          <option value="daegu">ëêµ¬</option>
          <option value="daejun">ëì </option>
        </select>
      </label>

      <label for="date">ëª¨ì ë ì§:</label>
      <input type="date" id="date" required>
    </div>
    
    <hr size="10px" />

    <input type="text" id="blog-title" placeholder="ì ëª©ì ìë ¥íì¸ì" required>
    <textarea id="blog-content" placeholder="ë´ì©ì ìë ¥íì¸ì" required></textarea>

    <button type="button" onclick="addBlogPost()">ë±ë¡íê¸°</button>
  </form>
</body>
</html>
