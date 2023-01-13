package com.daangun.clonecode.service;


import com.daangun.clonecode.model.ChatRoom;


import java.util.List;

public interface ChatRoomService {
    public ChatRoom findById(Long chatRoomId);
    public List<ChatRoom> findAllByUserId(Long id);

    void save(ChatRoom chatroom);

    ChatRoom findByRoomId(String roomId);

}
