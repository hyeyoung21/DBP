<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
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
        모임 장소:
        <select id="location-search">
          <option value="any-location" selected>모두</option>
          <option value="seoul">서울</option>
          <option value="gyeonggi">경기</option>
          <option value="sejong">세종</option>
          <option value="incheon">인천</option>
          <option value="chungbuk">충북</option>
          <option value="chungnam">충남</option>
          <option value="gangwon">강원</option>
          <option value="jeonnam">전남</option>
          <option value="jeonbul">전북</option>
          <option value="gwangju">광주</option>
          <option value="geongbuk">경북</option>
          <option value="geongnam">경남</option>
          <option value="jeju">제주</option>
          <option value="ulsam">울산</option>
          <option value="daegu">대구</option>
          <option value="daejun">대전</option>
        </select>
      </label>
    
      <label>
        카테고리:
        <select id="category-search">
          <option value="any-category" selected>모두</option>
          <option value="study">스터디</option>
          <option value="exercise">운동</option>
          <option value="plant">원예</option>
          <option value="handicraft">수공예</option>
          <option value="performance">공연</option>
          <option value="art">미술</option>
          <option value="game">게임</option>
        </select>
      </label>

      
      <label>
        성별:
        <select id="gender-search">
          <option value="male">남성</option>
          <option value="female">여성</option>
          <option value="any" selected>모두</option>
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
