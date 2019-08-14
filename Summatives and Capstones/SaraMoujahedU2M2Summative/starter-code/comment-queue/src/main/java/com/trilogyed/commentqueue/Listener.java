package com.trilogyed.commentqueue;

import com.trilogyed.commentqueue.model.Comment;
import com.trilogyed.commentqueue.util.feign.CommentServiceClient;
import com.trilogyed.commentqueue.util.payload.Payload;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Date;

@Service
@Component
public class Listener {
    @Autowired
    private final CommentServiceClient client;

    public Listener(CommentServiceClient client) {
        this.client = client;
    }

    @RabbitListener(queues = CommentQueueApplication.QUEUE_NAME)
    public void receiveMessage(Payload payload){
        Comment comment = new Comment();
        comment.setCommentId(payload.getCommentId());
        comment.setPostId(payload.getPostId());
        comment.setCreateDate(payload.getCreateDate());
        comment.setCommenterName(payload.getCommenterName());
        comment.setComment(payload.getComment());
        if (payload.getCommentId() == 0){
            System.out.println("Creating comment...");
            client.createComment(comment);
        } else {
            System.out.println("Updating comment of id " + comment.getCommentId() + "...");
            client.updateComment(comment, comment.getCommentId());
        }
    }

}
