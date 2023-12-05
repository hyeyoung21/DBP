package model.service;

import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws SQLException, UserNotFoundException {
		// TODO Auto-generated method stub
		UserManager userMan = UserManager.getInstance();
		System.out.println(userMan.findUser("user1"));
	}

}
