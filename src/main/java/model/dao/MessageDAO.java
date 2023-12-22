package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Message;
import model.Post;

public class MessageDAO {
    
    private JDBCUtil jdbcUtil;

    public MessageDAO() {
        jdbcUtil = new JDBCUtil();
    }

    public void add(Message msg) throws Exception {
        String sql = "insert into message values (message_seq.NEXTVAL, ?, ?, ?, SYSDATE)";
        Object[] param = new Object[] {msg.getSenderID(), msg.getRevID(), msg.getContent()};             
        jdbcUtil.setSqlAndParameters(sql, param);
                        
        try {               
            jdbcUtil.executeUpdate(); 
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {     
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }
        
    }
    
    public int delete(int applyId) throws SQLException {
        String sql = "DELETE FROM message WHERE MessageID=?";       
        jdbcUtil.setSqlAndParameters(sql, new Object[] {applyId});   // JDBCUtil에 delete문과 매개 변수 설정

        try {               
            int result = jdbcUtil.executeUpdate();  // delete 문 실행
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;
    }
    
    
    public List<String> findList(String userId) throws SQLException {
        String sql = "SELECT DISTINCT partner_id "
                + "FROM ("
                + " SELECT sender_id AS partner_id FROM message WHERE recv_id = ?"
                + " UNION"
                + " SELECT recv_id AS partner_id FROM message WHERE sender_id = ?) ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId, userId});

        try {
            ResultSet rs = jdbcUtil.executeQuery(); 
            List<String> userList = new ArrayList<String>();
            while (rs.next()) {
                userList.add(rs.getString("partner_id"));
            }
            return userList;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return null;
    }
    
    public List<Message> findMessageListByUser(String myId, String yourId) throws SQLException {
        String sql = "SELECT * FROM message WHERE (sender_id = ? AND recv_id = ?) OR (sender_id = ? AND recv_id = ?)"; 
        jdbcUtil.setSqlAndParameters(sql, new Object[] {myId, yourId, yourId, myId});

        try {
            ResultSet rs = jdbcUtil.executeQuery(); 
            List<Message> applyList = new ArrayList<Message>();
            while (rs.next()) {  
                Message apply = new Message(
                    rs.getInt("message_id"),
                    rs.getString("sender_id"),
                    rs.getString("recv_id"),
                    rs.getString("content"),
                    rs.getString("message_date")); 
                applyList.add(apply);
            }
            System.out.println(applyList);
            return applyList;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }
}
