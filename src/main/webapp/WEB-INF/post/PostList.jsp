<!DOCTYPE html>
<html lang="en">
<head>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="style.css">
  <title>Post List</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }

    #search-form {
      margin-bottom: 20px;
    }

    #search-form input{
      width: 300px;
      padding: 5px;
      margin-right: 10px;
    }

    #location-search,
    #category-search,
    #gender-search {
      width: 150px;
      padding: 5px;
      margin-right: 10px;
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

  <h1>Post List</h1>

  <div id="search-options">
    <form id="search-form">
        <label for="search-input">Search:</label>
        <input type="text" id="search-input">
      </form>
    
      <label>
        ëª¨ì ì¥ì:
        <select id="location-search">
          <option value="any-location" selected>ëª¨ë</option>
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
    
      <label>
        ì¹´íê³ ë¦¬:
        <select id="category-search">
          <option value="any-category" selected>ëª¨ë</option>
          <option value="study">ì¤í°ë</option>
          <option value="exercise">ì´ë</option>
          <option value="plant">ìì</option>
          <option value="handicraft">ìê³µì</option>
          <option value="performance">ê³µì°</option>
          <option value="art">ë¯¸ì </option>
          <option value="game">ê²ì</option>
        </select>
      </label>

      
      <label>
        ì±ë³:
        <select id="gender-search">
          <option value="male">ë¨ì±</option>
          <option value="female">ì¬ì±</option>
          <option value="any" selected>ëª¨ë</option>
        </select>
      </label>
    
  </div>

  <h2>Search Results</h2>
  <ul id="blog-list"></ul>

  <script>
    var blogPosts = [
      {
        title: 'Sample Post 1',
        content: 'This is the content of sample post 1. It may contain some information about a specific topic.',
        author: 'John Doe',
        date: '2023-01-01',
        recruitment: '5',
        category: 'Technology'
      },
      {
        title: 'Sample Post 2',
        content: 'This is the content of sample post 2. It may contain some information about a different topic.',
        author: 'Jane Doe',
        date: '2023-02-15',
        recruitment: '10',
        category: 'Travel'
      },
      // Add more blog posts as needed
    ];

    function displayBlogPosts(posts) {
      var blogList = document.getElementById('blog-list');
      blogList.innerHTML = '';

      posts.forEach(function(post) {
        var listItem = document.createElement('li');
        listItem.className = 'blog-item';
        listItem.innerHTML = `<h3>${post.title}</h3>
                              <p>${post.content}</p>
                              <p><strong>Author:</strong> ${post.author}</p>
                              <p><strong>Date:</strong> ${post.date}</p>
                              <p><strong>Recruitment:</strong> ${post.recruitment}</p>
                              <p><strong>Category:</strong> ${post.category}</p>`;
        blogList.appendChild(listItem);
      });
    }

    // Initial display of all blog posts on page load
    displayBlogPosts(blogPosts);
  </script>

</body>
</html>
