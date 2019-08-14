package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PostDaoTest {

    @Autowired
    PostDao dao;

    @Before
    public void setUp(){
        List<Post> posts = dao.getAllPosts();
        posts.stream().forEach(post -> dao.deletePost(post.getPostID()));
    }

    @Test
    public void addGetDeletePost(){
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 4, 5));
        post.setPosterName("Jane");
        post.setPost("Post");
        post = dao.createPost(post);
        Post fromDao = dao.getPost(post.getPostID());
        assertEquals(fromDao, post);
        dao.deletePost(post.getPostID());
        fromDao = dao.getPost(post.getPostID());
        assertNull(fromDao);
    }

    @Test
    public void getAllPosts(){
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 4, 5));
        post.setPosterName("Jane");
        post.setPost("Post");
        post = dao.createPost(post);

        Post post1 = new Post();
        post1.setPostDate(LocalDate.of(2019, 4, 5));
        post1.setPosterName("Jane");
        post1.setPost("Post");
        post1 = dao.createPost(post);

        List<Post> posts = dao.getAllPosts();

        assertEquals(2, posts.size());
    }

    @Test
    public void updatePost(){
        Post post = new Post();
        post.setPostDate(LocalDate.of(2019, 4, 5));
        post.setPosterName("Jane");
        post.setPost("Post");
        post = dao.createPost(post);
        post.setPosterName("Jill");
        dao.updatePost(post, post.getPostID());
        Post fromDao = dao.getPost(post.getPostID());
        assertEquals(post, fromDao);
    }
}
