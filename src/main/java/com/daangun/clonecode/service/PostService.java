package com.daangun.clonecode.service;

import com.daangun.clonecode.model.Post;

import java.util.Optional;

public interface PostService {
    Post findById(Long postId);
}
