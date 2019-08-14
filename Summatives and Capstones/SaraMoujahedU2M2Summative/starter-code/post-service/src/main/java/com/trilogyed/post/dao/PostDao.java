package com.trilogyed.post.dao;


import com.trilogyed.post.model.Post;

import java.util.List;

public interface PostDao {

    Post createPost(Post post);

    Post getPost(int id);

    List<Post> getAllPosts();

    List<Post> getPostsByPoster(String poster);

    void updatePost(Post post, int id);

    void deletePost(int id);


}
