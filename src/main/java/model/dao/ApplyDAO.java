package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import model.Post;
import model.Apply;

public class ApplyDAO {
    
    private JDBCUtil jdbcUtil;

    public ApplyDAO() {
        jdbcUtil = new JDBCUtil();
    }

    public void add(String userId, int postId, String description) throws Exception {
        String sql = "INSERT INTO APPLY (applyID, userid, postid, status, description) "
                + "VALUES (applyid_sequence.NEXTVAL, ?, ?, '신청중', ?)";
        Object[] param = new Object[] {userId, postId, description};             
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
        String sql = "DELETE FROM apply WHERE ApplyID=?";       
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
    
    public int deleteById(String userId, int postId) throws SQLException {
        String sql = "DELETE FROM apply WHERE userid=? and postid=?";       
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId, postId});   // JDBCUtil에 delete문과 매개 변수 설정

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
    
    public int update(int applyID) throws SQLException {
        String sql = "UPDATE APPLY "
                    + "SET status= '신청완료' "
                    + "WHERE applyId = ?";       
        jdbcUtil.setSqlAndParameters(sql, new Object[] {applyID}); 
            
        try {               
            int result = jdbcUtil.executeUpdate(); 
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
    
    public List<Post> findAllList() throws SQLException {
        String sql = "SELECT * "
                + " FROM post"
                + " WHERE post_id IN (SELECT DISTINCT postid FROM apply)";
        return findList(sql, null);
    }
    
    public List<Post> findListByPost(int postId) throws SQLException {
        String sql = "SELECT * "
                + "FROM post "
                + "WHERE post_id = ?";
        Object[] obj = new Object[] {postId};
        return findList(sql, obj);
    }
    
    
    public List<Post> findList(String sql, Object[] obj) throws SQLException {
        jdbcUtil.setSqlAndParameters(sql, obj);  

        try {
            ResultSet resultSet = jdbcUtil.executeQuery(); 
            List<Post> postList = new ArrayList<Post>();
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getInt("post_ID"));
                post.setTitle(resultSet.getString("post_title"));
                post.setContent(resultSet.getString("post_content"));
                post.setLocation(resultSet.getString("post_loc"));
                post.setDateTime(resultSet.getString("post_date"));
                post.setGender(resultSet.getString("post_gender"));
                post.setAge(resultSet.getString("post_age"));
                post.setMaxParticipants(resultSet.getInt("post_participants"));
                post.setMeetingType(resultSet.getString("meetingType"));
                postList.add(post);
            }
            return postList;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return null;
    }
    
    public List<Apply> findRecvApply(String userId) throws SQLException {
        String sql = "SELECT a.applyid, a.userId, a.status, a.description, p.post_title "
                + "FROM apply a "
                + "JOIN post p ON a.POSTID = p.post_id "
                + "WHERE p.user_Id = ?"; 
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});

        try {
            ResultSet rs = jdbcUtil.executeQuery(); 
            List<Apply> applyList = new ArrayList<Apply>();
            while (rs.next()) {  
                Apply apply = new Apply();
                apply.setApplyID(rs.getInt("applyid"));
                apply.setUserID(rs.getString("userId"));
                apply.setPostTitle(rs.getString("post_title"));
                apply.setDescription(rs.getString("description"));
                apply.setStatus(rs.getString("status"));
                applyList.add(apply);
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
    
    
    public List<Apply> findSendedApply(String userId) throws SQLException {
        String sql = "SELECT a.applyid, a.userId, a.status, a.description, p.post_title "
                + "FROM apply a "
                + "JOIN post p ON a.POSTID = p.post_id "
                + "WHERE a.userId = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});

        try {
            ResultSet rs = jdbcUtil.executeQuery(); 
            List<Apply> applyList = new ArrayList<Apply>();
            while (rs.next()) {  
                Apply apply = new Apply();
                apply.setApplyID(rs.getInt("applyid"));
                apply.setPostTitle(rs.getString("post_title"));
                apply.setDescription(rs.getString("description"));
                apply.setStatus(rs.getString("status"));
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
