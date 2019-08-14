package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class CommentController {

    @Autowired
    CommentDao dao;

    public CommentController(CommentDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Comment createComment(@RequestBody Comment comment) {
        return dao.createComment(comment);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public Comment getComment(@PathVariable("id") int id) {
        return dao.getComment(id);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.PUT)
    public void updateComment(@RequestBody Comment comment, @PathVariable("id") int id) {
        dao.updateComment(comment, id);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public List<Comment> getAllComments() {
        return dao.getAllComments();
    }

    @RequestMapping(value = "/comment/post/{id}", method = RequestMethod.GET)
    public List<String> getCommentsByPost(@PathVariable("id") int id) {
        return dao.getCommentByPost(id);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable("id") int id) {
        dao.deleteComment(id);
    }

    @RequestMapping(value = "/comment/post/{id}", method = RequestMethod.DELETE)
    public void deleteCommentByPost(@PathVariable("id") int id) {
        dao.deleteCommentByPost(id);
    }
}
