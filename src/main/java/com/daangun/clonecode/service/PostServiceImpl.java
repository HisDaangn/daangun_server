package com.daangun.clonecode.service;


import com.daangun.clonecode.model.Post;
import com.daangun.clonecode.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    private Supplier<? extends Throwable> PostException ;



    @Override
    public Post findById(Long postId){
        Post post = postRepository.findById(postId).get();
        return post;
    }
}
