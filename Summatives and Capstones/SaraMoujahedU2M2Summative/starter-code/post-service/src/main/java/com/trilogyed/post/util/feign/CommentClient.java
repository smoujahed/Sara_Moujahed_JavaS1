package com.trilogyed.post.util.feign;

import com.trilogyed.post.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(name = "comment-service")
public interface CommentClient {
    @RequestMapping(value = "/comment/post/{id}", method = RequestMethod.GET)
    public List<String> getCommentsByPost(@PathVariable("id") int id);
}