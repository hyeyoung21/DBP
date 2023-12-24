package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import model.User;
import model.Post;
import model.Comment;

public class PostDAO {
    private JDBCUtil jdbcUtil;

    public PostDAO() {
        jdbcUtil = new JDBCUtil();
    }

    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM post ORDER BY post_ID DESC";
        return executeQueryAndMapPosts(sql, null);
    }
    
    public List<Post> getTop3Posts() {
        String sql = "SELECT * FROM post ORDER BY post_ID DESC OFFSET 0 ROWS FETCH FIRST 3 ROWS ONLY";
        return executeQueryAndMapPosts(sql, null);
    }
    
    public List<Post> getTop3PostsFromLoc(String loc) {
        String sql = "SELECT * FROM post WHERE post_loc = ? "
                + "ORDER BY post_ID DESC OFFSET 0 ROWS FETCH FIRST 3 ROWS ONLY";
        return executeQueryAndMapPosts(sql, new Object[] {loc});
    }
    
    public Post getPost(int postId) {
        String sql = "SELECT * FROM post WHERE post_id = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});   // JDBCUtil에 query문과 매개 변수 설정
    
        try {
            ResultSet resultSet = jdbcUtil.executeQuery();     // query 실행
            if (resultSet.next()) {   
                Post post = new Post();
                post.setCreator(resultSet.getString("user_id"));
                post.setId(resultSet.getInt("post_id"));
                post.setTitle(resultSet.getString("post_title"));
                post.setContent(resultSet.getString("post_content"));
                post.setLocation(resultSet.getString("post_loc"));
                post.setGender(resultSet.getString("post_gender"));
                post.setAge(resultSet.getString("post_age"));
                post.setMaxParticipants(resultSet.getInt("post_participants"));
                post.setMeetingType(resultSet.getString("meetingType"));
                post.setDateTime(resultSet.getString("Post_date"));
                return post;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return null;
    }
    

    public List<Post> searchPostsByTitle(String searchString) {
        String sql = "SELECT * FROM POST WHERE post_title LIKE ?";
        return executeQueryAndMapPosts(sql, new Object[]{"%" + searchString + "%"});
    }

    public void createPost(Post post) throws Exception {
        System.out.println(post);
        String formattedDateTime = post.getDateTime().replace("T", " ");
        post.setDateTime(formattedDateTime);
        String sql = "INSERT INTO POST (post_ID, user_id, post_title, post_content, post_gender, post_age, post_loc, post_participants, meetingType, post_date) "
                + "VALUES (post_id_sequence.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(?,'YYYY-MM-DD HH24:MI'))";
        executeUpdateWithPost(sql, post);
    }

    public void updatePost(Post post, int postId) throws Exception {
        String formattedDateTime = post.getDateTime().replace("T", " ");
        post.setDateTime(formattedDateTime);
        String sql = "UPDATE POST \n"
                + "SET user_id = ?, "
                + "    post_title = ?, "
                + "    post_content = ?, "
                + "    post_gender = ?, "
                + "    post_age = ?, "
                + "    post_loc = ?, "
                + "    post_participants = ?, "
                + "    meetingType = ?, "
                + "    post_date = TO_DATE(?,'YYYY-MM-DD HH24:MI') "
                + "WHERE post_ID = " + postId;
        executeUpdateWithPost(sql, post);
    }

    public void deletePost(int postId) throws Exception {
        String sql = "DELETE POST WHERE post_id = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{postId});
        try {
            jdbcUtil.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
    }

    private List<Post> executeQueryAndMapPosts(String sql, Object[] params) {
        List<Post> posts = new ArrayList<>();
        jdbcUtil.setSqlAndParameters(sql, params);

        try {
            ResultSet resultSet = jdbcUtil.executeQuery();

            while (resultSet.next()) {
                Post post = mapResultSetToPost(resultSet);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return posts;
    }
    
    public List<Comment> getAllComments(int postId) {
        String sql = "SELECT * FROM post_comment Where postid = ? ";
        List<Comment> comments = new ArrayList<>();
        jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});
        
		java.sql.Date sqlDate = null;
		
		// 문자열을 java.sql.Date로 변환
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");

		

        try {
            ResultSet resultSet = jdbcUtil.executeQuery();

            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setCommentID(resultSet.getInt("comment_id"));
                comment.setUserID(resultSet.getString("userid"));
                comment.setPostID(resultSet.getInt("postid"));
                comment.setContent(resultSet.getString("content"));

				String commentDateString = resultSet.getString("comment_date");
				java.sql.Date sqlDate1 = null;
				
				// 문자열을 java.sql.Date로 변환
				SimpleDateFormat dateFormat1 = new SimpleDateFormat("yy-MM-dd");
				try {
				    java.util.Date parsedDate = dateFormat1.parse(commentDateString);
				    sqlDate1 = new java.sql.Date(parsedDate.getTime());
				} catch (ParseException e) {
				    e.printStackTrace();
				}
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return comments;
    }
    
    public void createComment(Comment comment) throws Exception {
        String sql = "insert INTO post_comment VALUES (commentid_sequence.NEXTVAL, ?, ?, ?, SYSDATE)";
        jdbcUtil.setSqlAndParameters(sql,
                new Object[]{comment.getPostID(), comment.getUserID(), comment.getContent()});
        try {               
            jdbcUtil.executeUpdate();  // insert 문 실행
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }
    }
    
    public void deleteComment(int commentid) throws Exception {
        String sql = "delete post_comment where comment_id = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{commentid});
        try {               
            jdbcUtil.executeUpdate();  // insert 문 실행
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }
    }

    private void executeUpdateWithPost(String sql, Post post) throws Exception { 
//        System.out.println(post);
//        user_id, post_title, post_content, post_gender, post_age, post_loc, post_participants, meetingType, post_date
        jdbcUtil.setSqlAndParameters(sql,
                new Object[]{post.getCreator(), post.getTitle(), post.getContent(), 
                        post.getGender(), post.getAge(), post.getLocation(),
                        post.getMaxParticipants(), post.getMeetingType(), post.getDateTime()});
        
        try {               
            int result = jdbcUtil.executeUpdate();  // insert 문 실행
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }   
    }



    private Post mapResultSetToPost(ResultSet resultSet) throws SQLException {
        Post post = new Post();
        post.setId(resultSet.getInt("post_ID"));
        post.setTitle(resultSet.getString("post_title"));
        post.setContent(resultSet.getString("post_content"));
        post.setLocation(resultSet.getString("post_loc"));
        post.setDateTime(resultSet.getString("post_date"));
        post.setGender(resultSet.getString("post_gender"));
        post.setAge(resultSet.getString("post_age"));
        post.setMaxParticipants(resultSet.getInt("post_participants"));
        post.setMeetingType(resultSet.getString("meetingType"));
        return post;
    }

    public List<Post> findListByUser(String userId) throws SQLException {
        String sql = "SELECT * FROM post WHERE user_Id = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});  
        List<Post> posts = new ArrayList<>();

        try {
            ResultSet resultSet = jdbcUtil.executeQuery();
            
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getInt("post_ID"));
                post.setTitle(resultSet.getString("post_title"));
                post.setContent(resultSet.getString("post_content"));
                post.setLocation(resultSet.getString("post_loc"));
                post.setDateTime(resultSet.getString("post_date"));
                post.setGender(resultSet.getString("post_gender"));
                post.setAge(resultSet.getString("post_age"));
                post.setMaxParticipants(resultSet.getInt("post_participants"));
                post.setMeetingType(resultSet.getString("meetingType"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return posts;
    }
    
    public List<Post> findAppliedPostByUser(String userid){
    	String sql = "SELECT post_ID, post_title, post_content, post_gender, post_age, post_loc, post_participants, meetingType, post_date "
                + "FROM post "
                + "JOIN apply a ON post.post_id = a.postid "
                + "WHERE a.userid = ?";


    	jdbcUtil.setSqlAndParameters(sql, new Object[] {userid});  
        List<Post> posts = new ArrayList<>();

        try {
            ResultSet resultSet = jdbcUtil.executeQuery();
            
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getInt("post_ID"));
                post.setTitle(resultSet.getString("post_title"));
                post.setContent(resultSet.getString("post_content"));
                post.setLocation(resultSet.getString("post_loc"));
                post.setDateTime(resultSet.getString("post_date"));
                post.setGender(resultSet.getString("post_gender"));
                post.setAge(resultSet.getString("post_age"));
                post.setMaxParticipants(resultSet.getInt("post_participants"));
                post.setMeetingType(resultSet.getString("meetingType"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return posts;
    }

    public List<Comment> findCommentListByUser(String userid) {
        String sql = "SELECT * FROM post_comment Where userid = ? ";
        List<Comment> comments = new ArrayList<>();
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userid});

        try {
            ResultSet resultSet = jdbcUtil.executeQuery();

            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setCommentID(resultSet.getInt("comment_id"));
                comment.setUserID(resultSet.getString("userid"));
                comment.setPostID(resultSet.getInt("postid"));
                comment.setContent(resultSet.getString("content"));
                String commentDateString = resultSet.getString("comment_date");
				java.sql.Date sqlDate1 = null;
				
				// 문자열을 java.sql.Date로 변환
				SimpleDateFormat dateFormat1 = new SimpleDateFormat("yy-MM-dd");
				try {
				    java.util.Date parsedDate = dateFormat1.parse(commentDateString);
				    sqlDate1 = new java.sql.Date(parsedDate.getTime());
				} catch (ParseException e) {
				    e.printStackTrace();
				}
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return comments;
    }
    
    
}