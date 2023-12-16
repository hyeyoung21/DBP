package model.dao;

import java.sql.SQLException;

import model.User;

public class ApplyDAO {
    
    private JDBCUtil jdbcUtil;

    public ApplyDAO() {
        jdbcUtil = new JDBCUtil();
    }

    public void add(String userId, int postId) throws Exception {
        String sql = "INSERT INTO POST (applyID, userid, postid, status) "
                + "VALUES (applyid_sequence, ?, ?, '신청중')";
        Object[] param = new Object[] {userId, postId};             
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
    
    public int delete(String applyId) throws SQLException {
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
    
    public int update(User user) throws SQLException {
        String sql = "UPDATE APPY "
                    + "SET status= '신청완료' ";       
        jdbcUtil.setSqlAndParameters(sql, new Object[] {}); 
            
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

}
