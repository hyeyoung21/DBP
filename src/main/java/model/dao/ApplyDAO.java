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
    
    public List<Post> findList() throws SQLException {
        String sql = "SELECT post_Title, post_id"
                + " FROM post"
                + " WHERE post_id IN (SELECT DISTINCT postid FROM apply)";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {});  

        try {
            ResultSet rs = jdbcUtil.executeQuery(); 
            List<Post> postList = new ArrayList<Post>();
            while (rs.next()) {
                Post post = new Post();
                String postTitle = rs.getString("post_Title");
                int postId = Integer.parseInt(rs.getString("post_id"));
                post.setTitle(postTitle);
                post.setId(postId);
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
    
    public List<Apply> findApplyListByPost(int postId) throws SQLException {
        String sql = "SELECT applyid, userId, status, description "
                    + "FROM apply "
                    + "WHERE POSTID=? "; 
        jdbcUtil.setSqlAndParameters(sql, new Object[] {postId});

        try {
            ResultSet rs = jdbcUtil.executeQuery(); 
            List<Apply> applyList = new ArrayList<Apply>();
            while (rs.next()) {  
                Apply apply = new Apply(
                    rs.getInt("applyid"),
                    postId,
                    rs.getString("userid"),
                    rs.getString("status"),
                    rs.getString("description")); 
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
