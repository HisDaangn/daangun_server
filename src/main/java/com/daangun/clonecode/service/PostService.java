package com.daangun.clonecode.service;

import com.daangun.clonecode.model.Post;
import com.daangun.clonecode.model.Request.PostRequest;

import java.util.Optional;

public interface PostService {
    Post findById(Long postId);

    Long create(Post post);

    Post update(Long id, PostRequest request);
}
