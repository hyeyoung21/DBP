package model.service;

import java.sql.SQLException;
import java.util.List;
import model.Post;
import model.Comment;
import model.dao.PostDAO;

public class PostManager {

    private static PostManager postMan = new PostManager();
    private PostDAO postDAO;
    
    private PostManager() {
        try {
            postDAO = new PostDAO();
            
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }
    
    public static PostManager getInstance() {
        return postMan;
    }
    
    public void update(Post post, int postId) throws SQLException {
        // post의 모임 정보가 변경된 경우   
        try {
            postDAO.updatePost(post, postId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }   
    
    public void add(Post post) throws SQLException {
        try {
            postDAO.createPost(post);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void remove(int postId) throws SQLException {
        try {
            postDAO.deletePost(postId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public Post getPost(int postId) throws SQLException {
        Post post = postDAO.getPost(postId);
  
        return post;
    }
    
    public List<Post> getAllPosts() throws SQLException {
            return postDAO.getAllPosts();
    }
    
    public List<Comment> getAllComments(int postId) throws SQLException {
        return postDAO.getAllComments(postId);
    }
    
    public void createComment(Comment comment) throws SQLException {
        try {
            postDAO.createComment(comment);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void deleteComment(int commentID) throws SQLException {
        try {
            postDAO.deleteComment(commentID);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Post> findPostList(String searchString)
        throws SQLException {
            return postDAO.searchPostsByTitle(searchString);
    }
    
    
    public PostDAO getPostDAO() {
        return this.postDAO;
    }
    
    public List<Post> findListByUser(String userid) throws SQLException {
        return postDAO.findListByUser(userid);
    }
    
    public List<Comment> findCommentListByUser(String userid) throws SQLException {
        return postDAO.findCommentListByUser(userid);
    }

}