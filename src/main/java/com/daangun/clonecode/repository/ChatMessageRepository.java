package com.daangun.clonecode.repository;

import com.daangun.clonecode.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {


    @Query("select m from ChatMessage m where m.roomId = :roomId order by m.send_at ")
    List<ChatMessage> findChatMessageByRoomId(String roomId);
}
