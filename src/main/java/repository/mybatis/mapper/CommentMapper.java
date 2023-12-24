package repository.mybatis.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

import model.Comment;

public interface CommentMapper {
	@Select("SELECT COMMENT_ID as COMMENTID, POSTID, USERID, CONTENT, COMMENT_DATE FROM post_comment WHERE POSTID = #{postNo}")
	List<Comment> getAllComments(long postNo);
	
	@Insert("INSERT INTO POST_COMMENT (COMMENT_ID, POSTID, USERID, CONTENT, COMMENT_DATE) " +
            "VALUES (commentid_sequence.NEXTVAL, #{postID}, #{userID}, #{content}, SYSDATE)")
	int insertComment(Comment comment);   
	
	@Delete("DELETE POST_COMMENT WHERE COMMENT_ID = #{commentNo}")
	int deleteComment(long commentNo);
	
}
