package com.daangun.clonecode.service;

import com.daangun.clonecode.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl {
    @Autowired
    private PostRepository postRepository;
}
