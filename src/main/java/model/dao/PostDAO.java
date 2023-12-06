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
        String sql = "SELECT * FROM posts";
        return executeQueryAndMapPosts(sql, null);
    }
    
    public List<Post> findPost(int postId) {
        String sql = "SELECT * FROM posts WHERE postid = ?";
        return executeQueryAndMapPosts(sql, new Object[]{postId});
    }

    public List<Post> searchPostsByTitle(String searchString) {
        String sql = "SELECT * FROM posts WHERE title LIKE ?";
        return executeQueryAndMapPosts(sql, new Object[]{"%" + searchString + "%"});
    }

    public void createPost(Post post) throws Exception {
        String sql = "INSERT INTO posts (title, description, location, dateTime, gender, ageRange, maxParticipants, creator_id, participants, meetingType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        executeUpdateWithPost(sql, post);
    }

    public void updatePost(Post post) throws Exception {
        String sql = "UPDATE posts SET title = ?, description = ?, location = ?, dateTime = ?, gender = ?, ageRange = ?, maxParticipants = ?, creator_id = ?, participants = ?, meetingType = ? WHERE id = ?";
        executeUpdateWithPost(sql, post);
    }

    public void deletePost(int postId) throws Exception {
        String sql = "DELETE FROM posts WHERE id = ?";
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
        List<String> participantIdsAsString = new ArrayList<>();
        for (User participant : post.getParticipants()) {
            participantIdsAsString.add(String.valueOf(participant.getUserId()));
        }

        jdbcUtil.setSqlAndParameters(sql,
                new Object[]{post.getTitle(), post.getDescription(), post.getLocation(),
                        post.getDateTime(), post.getGender(), post.getAgeRange(),
                        post.getMaxParticipants(), post.getCreator().getUserId(),
                        String.join(",", participantIdsAsString), post.getMeetingType()});

        executeUpdate();
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
        post.setId(resultSet.getInt("id"));
        post.setTitle(resultSet.getString("title"));
        post.setDescription(resultSet.getString("description"));
        post.setLocation(resultSet.getString("location"));
        post.setDateTime(resultSet.getString("dateTime"));
        post.setGender(resultSet.getString("gender"));
        post.setAgeRange(resultSet.getString("ageRange"));
        post.setMaxParticipants(resultSet.getInt("maxParticipants"));

        int creatorId = resultSet.getInt("creator_id");
        User creator = getUserById(creatorId);
        post.setCreator(creator);

        String participantsString = resultSet.getString("participants");
        List<User> participantsList = new ArrayList<>();
        if (participantsString != null && !participantsString.isEmpty()) {
            String[] participantsArray = participantsString.split(",");
            for (String participantId : participantsArray) {
                int userId = Integer.parseInt(participantId.trim());
                User participant = getUserById(userId);
                participantsList.add(participant);
            }
        }
        post.setParticipants(participantsList);

        post.setMeetingType(resultSet.getString("meetingType"));

        return post;
    }

    private User getUserById(int userId) {
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
