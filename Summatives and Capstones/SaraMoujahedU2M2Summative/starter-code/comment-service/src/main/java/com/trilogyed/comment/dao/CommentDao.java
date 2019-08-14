package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;

import java.util.List;

public interface CommentDao {

    Comment createComment(Comment comment);

    Comment getComment(int id);

    List<Comment> getAllComments();

    List<String> getCommentByPost(int id);

    void updateComment(Comment comment, int id);

    void deleteComment(int id);

    void deleteCommentByPost(int id);
}
