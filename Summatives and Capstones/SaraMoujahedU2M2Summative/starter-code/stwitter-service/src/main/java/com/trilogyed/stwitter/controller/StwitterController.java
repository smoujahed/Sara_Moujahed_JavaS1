package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StwitterController {


    ServiceLayer service;

    @Autowired
    public StwitterController(ServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post) {
        return service.newPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) {
        return service.fetchPost(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts() {
        return service.fetchAllPost();
    }

    @RequestMapping(value = "/posts/poster/{poster}", method = RequestMethod.GET)
    public List<Post> getPostsByPoster(@PathVariable("poster") String poster) {
        return service.fetchPostByPoster(poster);
    }


    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {
        service.updatePost(post, id);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id) {
        service.removeComment(id);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Comment createComment(@RequestBody Comment comment) {
        return service.newComment(comment);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public Comment getComment(@PathVariable("id") int id) {
        return service.fetchComment(id);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.PUT)
    public void updateComment(@RequestBody Comment comment, @PathVariable("id") int id) {
        service.updateComment(comment, id);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public List<Comment> getAllComments() {
        return service.fetchAllComments();
    }

    @RequestMapping(value = "/comment/post/{id}", method = RequestMethod.GET)
    public List<String> getCommentsByPost(@PathVariable("id") int id) {
        return service.fetchCommentsByPost(id);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable("id") int id) {
        service.removeComment(id);
    }



}
