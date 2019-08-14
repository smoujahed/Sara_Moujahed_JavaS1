package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.util.payload.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class ServiceLayer {
    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.#";

    @Autowired
    private final RabbitTemplate rabbitTemplate;
    @Autowired
    private final PostServiceClient postServiceClient;
    @Autowired
    private final CommentServiceClient commentServiceClient;

    public ServiceLayer(RabbitTemplate rabbitTemplate, PostServiceClient postServiceClient, CommentServiceClient commentServiceClient) {
        this.rabbitTemplate = rabbitTemplate;
        this.postServiceClient = postServiceClient;
        this.commentServiceClient = commentServiceClient;
    }

    @Transactional
    public Post newPost(Post post){
        post.setComments(commentServiceClient.getCommentsByPost(post.getPostID()));
        return postServiceClient.createPost(post);
    }

    @Transactional
    public Post fetchPost(int id){
        Post post = postServiceClient.getPost(id);
        post.setComments(commentServiceClient.getCommentsByPost(post.getPostID()));
        return post;
    }

    public List<Post> fetchAllPost(){
        return postServiceClient.getAllPosts();
    }

    public List<Post> fetchPostByPoster(String poster){
        return postServiceClient.getPostsByPoster(poster);
    }

    public void updatePost(Post post, int id){
        post.setComments(commentServiceClient.getCommentsByPost(id));
        postServiceClient.updatePost(post, id);
    }

    public void removePost(int id){
        commentServiceClient.deleteCommentByPost(id);
        postServiceClient.deletePost(id);
    }

    @Transactional
    public Comment newComment(Comment comment){
        List<Comment> comments = commentServiceClient.getAllComments();
        comments.stream().forEach(c -> {
            Date date = Date.from(c.getCreateDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Payload payload = new Payload(c.getCommentId(), c.getPostId(), localDate, c.getCommenterName(), c.getComment());
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, payload);
        });
        return comment;
    }

    @Transactional
    public Comment fetchComment(int id){
        return commentServiceClient.getComment(id);
    }

    public List<String> fetchCommentsByPost(int id){
        return commentServiceClient.getCommentsByPost(id);
    }

    public List<Comment> fetchAllComments(){
        return commentServiceClient.getAllComments();
    }

    public void updateComment(Comment comment, int id){
        commentServiceClient.updateComment(comment, id);
    }

    public void removeComment(int id){
        commentServiceClient.deleteComment(id);
    }






}
