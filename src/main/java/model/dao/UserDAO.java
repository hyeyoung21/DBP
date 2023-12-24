package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Post;
import model.User;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */

public class UserDAO {
	private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int add(User user) throws SQLException {
		String sql = "INSERT INTO USER_INFO VALUES (?, ?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {user.getUserId(), user.getEmail(), 
						user.getGender(), user.getAge(), user.getLocation(),
						user.getPassword(), user.getName(), user.getReportCount()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}	
		
		
		
		return 0;			
	}

	/**
	 * 기존의 사용자 정보를 수정.
	 */
	public int update(User user) throws SQLException {
		String sql = "UPDATE USER_INFO "
					+ "SET USER_EMAIL=?, USER_GENDER=?, USER_AGE=?, USER_LOC=?, USER_PASSWORD=?, USER_NAME=?, REPORTS_COUNT=? "
					+ "WHERE USER_ID=?";
		Object[] param = new Object[] {user.getEmail(), 
				user.getGender(), user.getAge(), user.getLocation(), user.getPassword(), user.getName(), 
					user.getReportCount(),user.getUserId() };				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int delete(String userId) throws SQLException {
		
		String sql = "delete from user_info where user_id = ?";	
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 delete문과 매개 변수 설정
		
		try {	
			int result = jdbcUtil.executeUpdate();
			
			return result;
		} catch (Exception e) {
	        // SQLException이 발생했을 때의 예외 처리
			jdbcUtil.rollback();
	        e.printStackTrace(); // 혹은 로그를 출력하거나, 필요한 조치를 취합니다.
	    }
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 User 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public User findUser(String userId) throws SQLException {
        String sql = "SELECT USER_EMAIL, USER_GENDER, USER_AGE, USER_LOC, USER_PASSWORD, USER_NAME, REPORTS_COUNT "
        			+ "FROM USER_INFO WHERE USER_ID=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				User user = new User(		// User 객체를 생성하여 학생 정보를 저장
					userId,
					rs.getString("USER_NAME"),
					rs.getString("USER_GENDER"),
					rs.getInt("USER_AGE"),
					rs.getString("USER_EMAIL"),
					rs.getString("USER_PASSWORD"),
					rs.getString("USER_LOC"),
					rs.getInt("REPORTS_COUNT"));
				
				System.out.println(user);
				
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
	public List<User> findUserList() throws SQLException {
        String sql = "SELECT USER_ID, USER_EMAIL, USER_GENDER, USER_AGE, USER_LOC, USER_PASSWORD, USER_NAME, REPORTS_COUNT " 
        		   + "FROM USER_INFO ORDER BY USER_ID";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<User> userList = new ArrayList<User>();	// User들의 리스트 생성
			while (rs.next()) {
				User user = new User(			// User 객체를 생성하여 현재 행의 정보를 저장
					rs.getString("USER_ID"),
					rs.getString("USER_NAME"),
					rs.getString("USER_GENDER"),
					rs.getInt("USER_AGE"),
					rs.getString("USER_EMAIL"),
					rs.getString("USER_PASSWORD"),
					rs.getString("USER_LOC"),
					rs.getInt("REPORTS_COUNT"));
				userList.add(user);				// List에 User 객체 저장
			}		
			return userList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
	 * 해당하는 사용자 정보만을 List에 저장하여 반환.
	 */
	public List<User> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT USER_ID, USER_EMAIL, USER_GENDER, USER_AGE, USER_LOC, USER_PASSWORD, USER_NAME, REPORTS_COUNT " 
					+ "FROM USER_INFO ORDER BY USER_ID";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<User> userList = new ArrayList<User>();	// User들의 리스트 생성
				do {
					User user = new User(			// User 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("USER_ID"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_GENDER"),
						rs.getInt("USER_AGE"),
						rs.getString("USER_LOC"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_NAME"),
						rs.getInt("REPORTS_COUNT"));
					userList.add(user);							// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 특정 커뮤니티에 속한 사용자들의 수를 count하여 반환
	 */
	public int getNumberOfUsersInCommunity(int communityId) {
		String sql = "SELECT COUNT(USER_ID) FROM USER_INFO "
     				+ "WHERE USER_ID = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {communityId});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			rs.next();										
			return rs.getInt(1);			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return 0;
	}
	
	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 !
	 */
	public boolean existingUser(String userId) throws SQLException {
		String sql = "SELECT count(*) FROM USER_INFO WHERE USER_ID=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
	
	public List<Post> searchForApplication(String userId) throws SQLException{
		String sql = "SELECT * FROM POST p JOIN APPLY a ON p.post_id = a.postid WHERE a.userid = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[]{userId});
    	
    	try { 
    		ResultSet rs = jdbcUtil.executeQuery();	
    		List<Post> list = new ArrayList<Post>();
    		
    		while (rs.next()) {
    			Post post = new Post();
    			post.setId(rs.getInt("post_ID"));
    	        post.setTitle(rs.getString("post_title"));
    	        post.setContent(rs.getString("post_content"));
    	        post.setLocation(rs.getString("post_loc"));
    	        post.setDateTime(rs.getString("post_date"));
    	        post.setGender(rs.getString("post_gender"));
    	        post.setAge(rs.getString("post_age"));
    	        post.setMaxParticipants(rs.getInt("post_participants"));
    	        post.setMeetingType(rs.getString("meetingType"));
    			
                list.add(post);
    		}
    		
		return list;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally { 
			jdbcUtil.close();
		} return null;

    }
}
