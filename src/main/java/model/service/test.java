package model.service;

import java.text.SimpleDateFormat;
import java.util.List;
import model.*;

// dao test하는 파일입니다 제출 시 삭제 요망!!!!!!!

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 String dateString = "2023-12-22"; // 예시로 날짜 문자열을 설정

	        // SimpleDateFormat을 사용하여 문자열을 java.sql.Date로 변환
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date parsedDate;
	        parsedDate = sdf.parse(dateString);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		Comment comm = null;
		System.out.println("d");
		CommentManager manager = CommentManager.getInstance();
		
		Comment comment = new Comment();
        comment.setUserID("1234");
        comment.setContent("1234");
        comment.setPostID(1);
        comment.setCommentDate(sqlDate);
        comment.setCommentID(2);
        
        manager.createComment(comment);


	}

}
