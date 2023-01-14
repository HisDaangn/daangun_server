package com.daangun.clonecode.service;

import com.daangun.clonecode.model.Post;
import com.daangun.clonecode.model.Request.PostRequest;

import java.util.Optional;

public interface PostService {
    Post findById(Long postId);
    Long create(Post post);
//    Post getPost(Long id, PostRequest request);
    Post update(Long id, PostRequest request);
    Post delete(Long id, PostRequest request);
}
