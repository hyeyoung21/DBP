package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Post;
import model.dao.PostDAO;
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
    
    public void update(Post post) throws SQLException, PostNotFoundException {
        // post의 모임 정보가 변경된 경우   
        try {
            postDAO.updatePost(post);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }   
    
    public void remove(int postId) throws SQLException, PostNotFoundException {
        try {
            postDAO.deletePost(postId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public Post getPost(int postId) throws SQLException, PostNotFoundException {
        Post post = postDAO.getPost(postId);
  
        return post;
    }
    
    public List<Post> getAllPosts() throws SQLException {
            return postDAO.getAllPosts();
    }

    public List<Post> findPostList(String searchString)
        throws SQLException {
            return postDAO.searchPostsByTitle(searchString);
    }
    
    
    public PostDAO getPostDAO() {
        return this.postDAO;
    }

}