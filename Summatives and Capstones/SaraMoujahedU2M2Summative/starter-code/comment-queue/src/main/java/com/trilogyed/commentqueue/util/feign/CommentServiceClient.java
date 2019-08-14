package com.trilogyed.commentqueue.util.feign;

import com.trilogyed.commentqueue.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Comment createComment(@RequestBody Comment comment);

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public Comment getComment(@PathVariable("id") int id);

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.PUT)
    public void updateComment(@RequestBody Comment comment, @PathVariable("id") int id);

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public List<Comment> getAllComments();

    @RequestMapping(value = "/comment/post/{id}", method = RequestMethod.GET)
    public List<String> getCommentsByPost(@PathVariable("id") int id);

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable("id") int id);

    @RequestMapping(value = "/comment//post/{id}", method = RequestMethod.DELETE)
    public void deleteCommentByPost(@PathVariable("id") int id);
}
