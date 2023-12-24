package model.service;

import java.text.SimpleDateFormat;
import java.util.List;
import model.*;

// dao test하는 파일입니다 제출 시 삭제 요망!!!!!!!

public class test {

	public static void main(String[] args) throws Exception {
		PostManager m = PostManager.getInstance();
		
		List<Post> list = (List<Post>)m.findAppliedPostByUser("user1");
		
		for (Post post : list) {
		    System.out.println("ID: " + post.getId());
		    System.out.println("Title: " + post.getTitle());
		    System.out.println("Location: " + post.getLocation());
		    System.out.println("DateTime: " + post.getDateTime());
		    // 기타 필요한 정보들을 가져와 출력하는 방식으로 추가 가능
		}
	}
}
