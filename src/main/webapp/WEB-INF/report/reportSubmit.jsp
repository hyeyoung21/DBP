<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <script type="text/javascript">
        alert("신고되었습니다.");
        window.location.href = "<c:url value='/post/list' />";
    </script>
</body>
</html>
