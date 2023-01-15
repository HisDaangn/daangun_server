package com.daangun.clonecode.service;

import com.daangun.clonecode.model.Post;
import com.daangun.clonecode.model.Request.PostRequest;
import com.daangun.clonecode.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface PostService {
    Post findById(Long postId);
    Post findOne(Long postId);
    Long create(Post post);
    Post update(Long id, PostRequest request);
    void delete(Long id);

    void lift(Long id);

    List<Post> getAllItems();

}
