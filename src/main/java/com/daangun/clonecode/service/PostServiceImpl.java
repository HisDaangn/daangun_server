package com.daangun.clonecode.service;


import com.daangun.clonecode.exception.post.PostException;
import com.daangun.clonecode.model.Post;

import com.daangun.clonecode.model.Request.PostRequest;
import com.daangun.clonecode.repository.PostRepository;
import lombok.SneakyThrows;
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
    private Supplier<? extends Throwable> PostException;

    @Override
    public Post findOne(Long postId){
        Post post = postRepository.findById(postId).get();
        return post;
    }
    @SneakyThrows
    @Override
    @Transactional
    public Post findById(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(PostException);
        post.viewUp();
        return post;
    }
    @Override
    @Transactional
    public Long create(Post post) {
        Post p = postRepository.save(post);
        return p.getId();
    }
    @Override
    @Transactional
    public Post update(Long id, PostRequest request) {
        Post post = this.findOne(id);
        post.update(request);
        return post;
    }

    @Override
    @Transactional
    public void delete(Long id){
        postRepository.deleteById(id);
    }
    @Override
    @Transactional
    public Post lift(Long id) {
        Post post = this.findOne(id);
        post.lift();
        return post;
    }
}
