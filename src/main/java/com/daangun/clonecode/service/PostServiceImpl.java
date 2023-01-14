package com.daangun.clonecode.service;


import com.daangun.clonecode.model.Post;

import com.daangun.clonecode.model.Request.PostRequest;
import com.daangun.clonecode.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.beans.Transient;
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

    @Override
    public Long create(Post post) {
        Post p = postRepository.save(post);
        return p.getId();
    }

//    @Override
//    public Post getPost(Long id, PostRequest request) {
//        Post p = this.findById(id);
//        return p;
//    }

    @Override
    @Transactional
    public Post update(Long id, PostRequest request) {
        Post post = this.findById(id);
        post.update(request);
        return post;
    }

    @Override
    public Post delete(Long id, PostRequest request) {
        Post p = postRepository.findById(id).get();
        return p;
    }

}
