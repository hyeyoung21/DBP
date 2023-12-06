package model.service;

import java.sql.SQLException;
import java.util.List;
import model.*;

// dao test하는 파일입니다 제출 시 삭제 요망!!!!!!!

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Post post = null;
	    PostManager pm = PostManager.getInstance();
		try {
//		    post_title, post_content, post_gender, post_age, post_loc, post_participants, meetingType
		    post = new Post(
                "title",
                "content",
                "서울",
                "23/12/07",
                "male",
                "15",
                5,
                "study"
            );
            pm.add(post);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (PostNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
