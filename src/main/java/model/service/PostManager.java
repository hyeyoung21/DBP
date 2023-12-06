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
    
    public int update(int post) throws SQLException, PostNotFoundException {
        // post의 모임 정보가 변경된 경우   
        return postDAO.updatePost(post);
    }   
    
    public int remove(String postId) throws SQLException, PostNotFoundException {
        
        // 유저가 참여한 모임 정보도 같이 삭제해야 함. 
        
        return postDAO.deletePost(postId);
    }
    
    public Post findPost(int postId)
        throws SQLException, PostNotFoundException {
        Post post = postDAO.p(postId);
  
        return post;
    }
    
    public List<Post> getAllPosts() throws SQLException {
            return postDAO.getAllPosts();
    }

    public List<Post> findPostList(int currentPage, int countPerPage)
        throws SQLException {
            return postDAO.findPostList(currentPage, countPerPage);
    }
    
    public boolean login(String postId, String password)
            throws SQLException, PostNotFoundException, PasswordMismatchException {
        Post post = findPost(postId);

        if (!post.matchPassword(password)) {
            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }
        return true;
    }
    
    public PostDAO getPostDAO() {
        return this.postDAO;
    }

}
