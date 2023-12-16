package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Apply;
import model.Post;
import model.dao.ApplyDAO;

public class ApplyManager {
    private static ApplyManager applyMan = new ApplyManager();
    private ApplyDAO applyDAO;
    
    private ApplyManager() {
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
    
    public int delete(String applyId) throws SQLException {
        return applyDAO.delete(applyId);
    }
    
    public int update() throws SQLException {
        return applyDAO.update();
    }
    
    public List<Post> findList() throws SQLException {
        return applyDAO.findList();
    }
    
    public List<Apply> findApplyListByPost(int postId) throws SQLException {
        return applyDAO.findApplyListByPost(postId);
    }
}
