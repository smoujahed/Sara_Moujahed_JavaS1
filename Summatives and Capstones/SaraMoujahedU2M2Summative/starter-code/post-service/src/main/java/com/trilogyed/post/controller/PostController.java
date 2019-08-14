package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import com.trilogyed.post.util.feign.CommentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class PostController {

    @Autowired
    PostDao postDao;

    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post) {
        return postDao.createPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) {
        return postDao.getPost(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }

    @RequestMapping(value = "/posts/poster/{poster}", method = RequestMethod.GET)
    public List<Post> getPostsByPoster(@PathVariable("poster") String poster) {
        return postDao.getPostsByPoster(poster);
    }


    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, @PathVariable int id) {
        postDao.updatePost(post, id);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id) {
        postDao.deletePost(id);
    }

}
