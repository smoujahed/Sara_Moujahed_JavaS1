package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentDaoJdbcTempImpl implements CommentDao{

    public static final String INSERT_COMMENT =
            "insert into comment (post_id, create_date, commenter_name, comment) values (?,?,?,?)";

    public static final String SELECT_COMMENT =
            "select * from comment where comment_id = ?";

    public static final String SELECT_ALL_COMMENTS =
            "select * from comment";

    public static final String SELECT_COMMENT_BY_POST =
            "select comment from comment where post_id = ?";

    public static final String UPDATE_COMMENT =
            "update comment set post_id = ?, create_date = ?, commenter_name = ?, comment = ? where comment_id = ?";

    public static final String DELETE_COMMENT =
            "delete from comment where comment_id = ?";
    public static final String DELETE_COMMENT_BY_POST =
            "delete from comment where post_id = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public CommentDaoJdbcTempImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    @Transactional
    public Comment createComment(Comment comment) {
        jdbcTemplate.update(
                INSERT_COMMENT,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment());
        comment.setCommentId(jdbcTemplate.queryForObject("select last_insert_id()", Integer.class));
        return comment;
    }

    @Override
    public Comment getComment(int id) {
        try{
            return jdbcTemplate.queryForObject(SELECT_COMMENT, this::mapRowToComment, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List<Comment> getAllComments() {
        return jdbcTemplate.query(SELECT_ALL_COMMENTS, this::mapRowToComment);
    }

    @Override
    public List<String> getCommentByPost(int id) {
         List<Comment> comments = jdbcTemplate.query(SELECT_COMMENT_BY_POST, this::mapRowToComment, id);
         List<String> strings = new ArrayList<>();
         comments.stream().forEach(comment -> strings.add(comment.getComment()));
         return strings;
    }

    @Override
    public void updateComment(Comment comment, int id) {
        jdbcTemplate.update(
                UPDATE_COMMENT,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment(),
                id);
    }

    @Override
    public void deleteComment(int id) {
        jdbcTemplate.update(DELETE_COMMENT, id);
    }

    @Override
    public void deleteCommentByPost(int id) {
        jdbcTemplate.update(DELETE_COMMENT_BY_POST, id);

    }


    private Comment mapRowToComment(ResultSet resultSet, int i) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(resultSet.getInt("comment_id"));
        comment.setPostId(resultSet.getInt("post_id"));
        comment.setCreateDate(resultSet.getDate("create_date").toLocalDate());
        comment.setCommenterName(resultSet.getString("commenter_name"));
        comment.setComment(resultSet.getString("comment"));
        return comment;
    }
}
