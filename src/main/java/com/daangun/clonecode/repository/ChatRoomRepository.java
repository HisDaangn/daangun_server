package com.daangun.clonecode.repository;

import com.daangun.clonecode.model.ChatRoom;
import com.daangun.clonecode.model.Request.ChatRoomRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    @Query("select r from ChatRoom r " +
    "where r.pubId = :userId " +
    "or r.subId = :userId "+
    "order by r.created_at desc ")
    List<ChatRoom> findChatRoomByUserId(Long userId);


    @Query("select r from ChatRoom r where r.roomId = :roomId")
    ChatRoom findByRoomId(String roomId);
}
