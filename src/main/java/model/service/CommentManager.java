package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Comment;
import repository.mybatis.CommentDAO;

public class CommentManager {
	private static CommentManager commentManager = new CommentManager();
	private CommentDAO commentDAO;
	
	private CommentManager() {
        try {
        	commentDAO = new CommentDAO();

        } catch (Exception e) {
        	System.err.println("Error initializing DAOs:");
            e.printStackTrace();
        }           
    }
	
	public static CommentManager getInstance() {
        return commentManager;
    }
	
	public void createComment(Comment comment) throws SQLException {
        try {
        	commentDAO.insertComment(comment);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void updateComment(Comment comment) throws SQLException {
        try {
        	commentDAO.updateComment(comment);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void deleteComment(long commentNo) throws SQLException {
        try {
        	commentDAO.deleteComment(commentNo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public List<Comment> getAllComments(long postNo) throws SQLException {
        try {
        	return commentDAO.getAllComments(postNo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return null;
    }
}
