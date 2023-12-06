package model.service;

import java.sql.SQLException;
import java.util.List;
import model.*;

// dao test하는 파일입니다 제출 시 삭제 요망!!!!!!!

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		UserManager userMan = UserManager.getInstance();
		
		User user = new User(
//	            request.getParameter("userId"),
//	            request.getParameter("name"),
//	            request.getParameter("gender"),
//	            Integer.parseInt(request.getParameter("age")),
//	            request.getParameter("email"),
//	            request.getParameter("password"),
//	            request.getParameter("location"),
//	            Integer.parseInt(request.getParameter("reportCount"))
		        "user11", "권혜영", "female", 20, "test11@gmail.com", "password11", "서울", 1
	        );
		
		try {
            int users =  userMan.create(user);
            System.out.println(user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExistingUserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}

}
