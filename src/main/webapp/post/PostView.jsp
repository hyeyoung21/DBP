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

    button {
      display: inline-block;
      padding: 5px 10px;
      font-size: 12px;
      font-weight: bold;
      text-align: center;
      text-decoration: none;
      cursor: pointer;
      border: 2px solid #333;
      border-radius: 5px;
      color: #333;
      background-color: #ffffff83;
    }

    #blog-content {
      display: inline-block;
      padding: 5px 10px;
      font-size: 12px;
      border: 2px solid #333;
      border-radius: 5px;
      color: #333;
      background-color: #ffffff83;
    }

  </style>
</head>
<body>

  <h2 id="blog-title">POST TITLE</h2>

  <form id="blog-form">
    <div class="form-group">
      <label for="recruitment-num">ëª¨ì§ ì¸ì:</label>
      <a id="recruitment-num">1</a>ëª
      <br>
      <label for="recruitment-gender">ëª¨ì§ ì±ë³:</label>
      <a id="recruitment-gender">ì¬ì±</a>
      <br>
      <label for="recruitment-age">ëª¨ì§ ëì´:</label>
      <a id="recruitment-age">20ë</a>
    </div>

    <div class="form-group">
      <label for="category">ì¹´íê³ ë¦¬:</label>
      <a id="category">ì¤í°ë</a>
      <br>
      <label for="location">ëª¨ì ìì¹:</label>
        <a id="location">ìì¸</a>
      </label>
      <br>
      <label for="date">ëª¨ì ë ì§:</label>
      <a id="date">2023-12-03</a>
    </div>
    
    <hr size="10px" />

    <div id="blog-content">Post content</div>
  </form>

  <div id="comment-form">
    <h3>ëê¸ ìì±</h3>
    <textarea id="comment-content" rows="4" required></textarea>

    <button onclick="addComment()">ëê¸ ìì±</button>
  </div>

  <div id="comment-list">
      <!-- ì¬ê¸°ì ì¶ê°ë ëê¸ì´ íìë©ëë¤. -->
  </div>
</body>
</html>
