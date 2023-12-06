package model.service;

import java.sql.SQLException;
import java.util.List;
import model.*;

// dao test하는 파일입니다 제출 시 삭제 요망!!!!!!!

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		UserManager userMan = UserManager.getInstance();
		
		List<User> users =  userMan.findUserList();
		
		users.forEach(user -> System.out.println(user));
	}

}
