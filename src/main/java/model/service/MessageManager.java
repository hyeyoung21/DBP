package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Apply;
import model.Post;
import model.dao.MessageDAO;
import model.Message;

public class MessageManager {
    private static MessageManager messageMan = new MessageManager();
    private MessageDAO messageDAO;
    
    private MessageManager() {
        try {
            messageDAO = new MessageDAO();
            
        } catch (Exception e) {
            e.printStackTrace();
        }           
    }
    
    public static MessageManager getInstance() {
        return messageMan;
    }
    public void add(Message msg) throws Exception {
        messageDAO.add(msg);
    }
    
    public int delete(int messageID) throws SQLException {
        return messageDAO.delete(messageID);
    }
    
    public List<String> findList(String userId) throws SQLException {
        return messageDAO.findList(userId);
    }
    
    public List<Message> findMessageListByUser(String userID) throws SQLException {
        return messageDAO.findMessageListByUser(userID);
    }
}