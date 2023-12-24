package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Apply;
import model.Post;
import model.dao.ApplyDAO;

public class ApplyManager {
    private static ApplyManager applyMan = new ApplyManager();
    private ApplyDAO applyDAO;
    
    ApplyManager() {
        try {
            applyDAO = new ApplyDAO();
            
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }
    
    public static ApplyManager getInstance() {
        return applyMan;
    }
    public void add(String userId, int postId, String description) throws Exception {
        applyDAO.add(userId, postId, description);
    }
    
    public int delete(int applyId) throws SQLException {
        return applyDAO.delete(applyId);
    }
    
    public int deleteById(String userId, int postId) throws SQLException {
        return applyDAO.deleteById(userId, postId);
    }
    
    public int update(int applyID) throws SQLException {
        return applyDAO.update(applyID);
    }
    
    public int checkForDuplicate(String userId, int postId) throws SQLException{
    	return applyDAO.checkForDuplicate(userId, postId);
    }
    
    public List<Apply> findAllList() throws SQLException {
        return applyDAO.findAllList();
    }
    
    public List<Apply> findListByPost(int postId) throws SQLException {
        return applyDAO.findListByPost(postId);
    }
    
    public List<Apply> findRecvApply(String userId) throws SQLException {
        return applyDAO.findRecvApply(userId);
    }
    
    public List<Apply> findSendedApply(String userId) throws SQLException {
        return applyDAO.findSendedApply(userId);
    }

}
