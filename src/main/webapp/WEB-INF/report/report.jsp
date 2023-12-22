<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>신고 양식</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        .form-group {
            width: 50%;
            box-sizing: border-box;
            padding: 0 10px;
        }

        #report-form label,
        #report-form input,
        #report-form textarea {
            width: 100%;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        #report-content {
            width: 100%;
            height: 300px;
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 20px;
            font-size: 16px;
            color: #333;
        }

        .btn-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h3 class="display-6 text-left">신고 양식</h3>

    <form id="report-form" method="post" action="<c:url value='/post/list' />">
    	<div class="form-group">
        	<label for="reportedType">신고 대상 유형:</label>
        	<input type="text" class="form-control" id="reportedType" name="reportedType"
               value="${report.reportType}" readonly>
    	</div>

        <div class="form-group">
            <label for="reportedTitle">신고 대상 게시글 제목:</label>
            <input type="text" class="form-control" id="reportedTitle" name="reportedTitle"
                   value="${report.reportTitle}" readonly>
        </div>
        <div class="form-group">
            <label for="reportedUser">신고 대상 회원:</label>
            <input type="text" class="form-control" id="reportedUser" name="reportedUser"
                   value="${report.reportUserName}" readonly>
        </div>
        <div class="form-group">
            <label for="reportedContent">신고 대상 내용:</label>
            <textarea class="form-control" id="reportedContent" name="reportedContent" readonly>${report.reportContenet}</textarea>
        </div>

        <div class="form-group">
            <label for="reportReason">신고 사유:</label>
            <textarea class="form-control" id="reportReason" name="reportReason" rows="4" required></textarea>
        </div>
    </form>
	<form action="<c:url value='/report/submit' />" method="post">
   		<input type="hidden" name="reportUserName" value="${report.reportUserName}" />
   		<button type="submit" class="btn btn-danger">신고하기</button>
	</form>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
