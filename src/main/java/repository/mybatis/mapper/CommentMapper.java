package repository.mybatis.mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

import model.Comment;

public interface CommentMapper {
	@Select("SELECT * FROM post_comment WHERE POSTID = #{postNo}")
	List<Comment> getAllComments(long postNo);
	
	@Insert("INSERT INTO POST_COMMENT (COMMENT_ID, POSTID, USERID, CONTENT, COMMENT_DATE) " +
            "VALUES (commentid_sequence.NEXTVAL, #{postID}, #{userID}, #{content}, SYSDATE)")
	int insertComment(Comment comment);   
	
	@Delete("delete post_comment where comment_id = #{commentNo}")
	int deleteComment(long commentNo);
	
	@Update("UPDATE post_comment SET content = #{content} WHERE comment_id = #{commentID}")
	int updateComment(Comment comment);
}
