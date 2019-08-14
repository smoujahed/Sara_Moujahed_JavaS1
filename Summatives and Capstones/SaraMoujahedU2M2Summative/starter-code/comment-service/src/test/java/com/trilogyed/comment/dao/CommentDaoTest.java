package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CommentDaoTest {

    @Autowired
    CommentDao dao;

    @Before
    public void setUp()throws Exception{
        List<Comment> comments = dao.getAllComments();
        comments.stream().forEach(comment -> dao.deleteComment(comment.getCommentId()));
    }

    @Test
    public void addGetDeleteComment(){
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 2, 3));
        comment.setCommenterName("Betty");
        comment.setComment("comment");
        comment = dao.createComment(comment);
        Comment fromDao = dao.getComment(comment.getCommentId());
        assertEquals(fromDao, comment);
        dao.deleteComment(comment.getCommentId());
        fromDao = dao.getComment(comment.getCommentId());
        assertNull(fromDao);
    }

    @Test
    public void getAllComments(){
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 2, 3));
        comment.setCommenterName("Betty");
        comment.setComment("comment");

        comment = dao.createComment(comment);

        Comment comment1 = new Comment();
        comment1.setPostId(2);
        comment1.setCreateDate(LocalDate.of(2019, 2, 5));
        comment1.setCommenterName("Mary");
        comment1.setComment("comment1");

        comment1 = dao.createComment(comment1);

        List<Comment> comments = dao.getAllComments();

        assertEquals(2, comments.size());
    }

    @Test
    public void updateComment(){
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2019, 2, 3));
        comment.setCommenterName("Betty");
        comment.setComment("comment");
        comment = dao.createComment(comment);
        comment.setComment("comment 2");
        dao.updateComment(comment, comment.getCommentId());
        Comment fromDao = dao.getComment(comment.getCommentId());
        assertEquals(comment, fromDao);
    }

}
