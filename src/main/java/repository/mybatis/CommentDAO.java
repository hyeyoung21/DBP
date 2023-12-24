package repository.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Comment;
import repository.mybatis.mapper.CommentMapper;

public class CommentDAO {
    private SqlSessionFactory sqlSessionFactory;

    public CommentDAO() {
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int insertComment(Comment comment) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int result = sqlSession.getMapper(CommentMapper.class).insertComment(comment);
            if (result > 0) {
                sqlSession.commit();
            }
            return result;
        }
    }

    public int deleteComment(long commentNo) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int result = sqlSession.getMapper(CommentMapper.class).deleteComment(commentNo);
            System.out.println("delete result : " + result + "commentNo :" + commentNo);
            if (result > 0) {
                sqlSession.commit();
            }
            return result;
        }
    }

    public List<Comment> getAllComments(long postNo) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.getMapper(CommentMapper.class).getAllComments(postNo);
        }
    }
}
