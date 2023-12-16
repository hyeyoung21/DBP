package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import model.User;
import model.Post;

public class PostDAO {
    private JDBCUtil jdbcUtil;

    public PostDAO() {
        jdbcUtil = new JDBCUtil();
    }

    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM post";
        return executeQueryAndMapPosts(sql, null);
    }
    
    public Post getPost(int postId) {
        String sql = "SELECT * FROM post WHERE post_id = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});   // JDBCUtil에 query문과 매개 변수 설정
    
        try {
            ResultSet resultSet = jdbcUtil.executeQuery();     // query 실행
            if (resultSet.next()) {   
                Post post = new Post();
                post.setCreator(resultSet.getString("user_id"));                post.setId(resultSet.getInt("post_id"));
                post.setTitle(resultSet.getString("post_title"));
                post.setContent(resultSet.getString("post_content"));
                post.setLocation(resultSet.getString("post_loc"));
                post.setGender(resultSet.getString("post_gender"));
                post.setAge(resultSet.getString("post_age"));
                post.setMaxParticipants(resultSet.getInt("post_participants"));
                post.setMeetingType(resultSet.getString("meetingType"));
                post.setDateTime(resultSet.getString("Post_date"));
//                User creator = getUserById(creatorId);
//                post.setCreator(creator);
                
                System.out.println(post);
                
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
        String sql = "SELECT * FROM POST WHERE title LIKE ?";
        return executeQueryAndMapPosts(sql, new Object[]{"%" + searchString + "%"});
    }

    public void createPost(Post post) throws Exception {
        String sql = "INSERT INTO POST (post_ID, user_id, post_title, post_content, post_gender, post_age, post_loc, post_participants, meetingType, post_date) "
                + "VALUES (post_id_sequence.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        executeUpdateWithPost(sql, post);
    }

    public void updatePost(Post post) throws Exception {
        String sql = "UPDATE POST SET title = ?, description = ?, location = ?, dateTime = ?, gender = ?, ageRange = ?, maxParticipants = ?, creator_id = ?, participants = ?, meetingType = ? WHERE id = ?";
        executeUpdateWithPost(sql, post);
    }

    public void deletePost(int postId) throws Exception {
        String sql = "DELETE FROM POST WHERE id = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{postId});
        executeUpdate();
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

    private void executeUpdateWithPost(String sql, Post post) throws Exception { 
        System.out.println(post);
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


    private void executeUpdate() throws Exception {
        try {
            jdbcUtil.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
    }

    private Post mapResultSetToPost(ResultSet resultSet) throws SQLException {
        Post post = new Post();
        post.setId(resultSet.getInt("post_ID"));
        post.setTitle(resultSet.getString("post_title"));
        post.setContent(resultSet.getString("post_content"));
        post.setLocation(resultSet.getString("post_loc"));
        post.setDateTime(resultSet.getString("dateTime"));
        post.setGender(resultSet.getString("post_gender"));
        post.setAge(resultSet.getString("post_age"));
        post.setMaxParticipants(resultSet.getInt("post_participants"));
        post.setMeetingType(resultSet.getString("post_participants"));

//        String creatorId = resultSet.getString("creator_id");
//        User creator = getUserById(creatorId);
//        post.setCreator(creator);

//        String participantsString = resultSet.getString("participants");
//        List<User> participantsList = new ArrayList<>();
//        if (participantsString != null && !participantsString.isEmpty()) {
//            String[] participantsArray = participantsString.split(",");
//            for (String participantId : participantsArray) {
//                int userId = Integer.parseInt(participantId.trim());
//                User participant = getUserById(userId);
//                participantsList.add(participant);
//            }
//        }
//        post.setParticipants(participantsList);

//        post.setMeetingType(resultSet.getString("meetingType"));

        return post;
    }

    private User getUserById(String userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{userId});

        try {
            ResultSet resultSet = jdbcUtil.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //DB결과 User객체로
    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getString("user_id"));
        user.setName(resultSet.getString("user_name"));
        user.setGender(resultSet.getString("user_gender"));
        user.setAge(resultSet.getInt("user_age"));
        user.setEmail(resultSet.getString("user_email"));
        user.setPassword(resultSet.getString("user_password"));
        user.setLocation(resultSet.getString("user_loc"));
        
        return user;
    }
}