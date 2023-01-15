package com.daangun.clonecode.repository;

import com.daangun.clonecode.model.ChatRoom;
import com.daangun.clonecode.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
