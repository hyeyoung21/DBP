package model.service;

import java.util.List;
import model.*;

// dao test하는 파일입니다 제출 시 삭제 요망!!!!!!!

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Comment comm = null;
	    PostManager pm = PostManager.getInstance();

	    //String userId, int postId, String description
        System.out.println(pm.getAllComments(1));

	}

}
