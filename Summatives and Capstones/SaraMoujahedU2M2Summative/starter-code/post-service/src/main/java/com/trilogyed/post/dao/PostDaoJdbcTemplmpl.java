package com.trilogyed.post.dao;

import com.trilogyed.post.model.Comment;
import com.trilogyed.post.model.Post;
import com.trilogyed.post.util.feign.CommentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDaoJdbcTemplmpl implements PostDao{

    public static final String INTERT_POST =
            "insert into post (post_date, poster_name, post) values (?,?,?)";

    public static final String SELECT_POST =
            "select * from post where post_id = ?";

    public static final String SELECT_ALL_POSTS =
            "select * from post";

    public static final String SELECT_POSTS_BY_POSTER =
            "select * from post where poster_name = ?";

    public static final String UPDATE_POST =
            "update post set post_date = ?, poster_name = ?, post = ? where post_id = ?";

    public static final String DELETE_POST =
            "delete from post where post_id = ?";

    JdbcTemplate jdbcTemplate;

    private final CommentClient client;

    @Autowired
    public PostDaoJdbcTemplmpl(JdbcTemplate jdbcTemplate, CommentClient client) {
        this.jdbcTemplate = jdbcTemplate;
        this.client = client;
    }


    @Override
    public Post createPost(Post post) {
        jdbcTemplate.update(
                INTERT_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost());
        post.setPostID(jdbcTemplate.queryForObject("select last_insert_id()", Integer.class));
//        post.setComments(getComments(post.getPostID()));
        return post;
    }

    @Override
    public Post getPost(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_POST, this::mapRowToPost, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Post> getAllPosts() {
        return jdbcTemplate.query(SELECT_ALL_POSTS, this::mapRowToPost);
    }


    @Override
    public List<Post> getPostsByPoster(String poster) {
        return jdbcTemplate.query(SELECT_POSTS_BY_POSTER, this::mapRowToPost, poster);
    }

    @Override
    public void updatePost(Post post, int id) {
        jdbcTemplate.update(
                UPDATE_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost(),
                post.getComments(),
                id);
    }

    @Override
    public void deletePost(int id) {
        jdbcTemplate.update(DELETE_POST, id);
    }

    private Post mapRowToPost(ResultSet resultSet, int i) throws SQLException {
        Post post = new Post();
        post.setPostID(resultSet.getInt("post_id"));
        post.setPostDate(resultSet.getDate("post_date").toLocalDate());
        post.setPosterName(resultSet.getString("poster_name"));
        post.setPost(resultSet.getString("post"));
        return post;
    }

//    private List<String> getComments(int id) {
//        return client.getCommentsByPost(id);
//    }

}
