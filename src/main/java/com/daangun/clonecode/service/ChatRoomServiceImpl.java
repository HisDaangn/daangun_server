package com.daangun.clonecode.service;



import com.daangun.clonecode.exception.chatroom.ChatRoomException;
import com.daangun.clonecode.model.ChatRoom;
import com.daangun.clonecode.repository.ChatRoomRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.function.Supplier;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;
    private Supplier<? extends Throwable> ChatRoomException;


    @Override
    public ChatRoom findByRoomId(String roomId) {
        ChatRoom response = chatRoomRepository.findByRoomId(roomId);
        return response;
    }

    @Override
    public int countChatRoomByPostId(Long id) {
        int cnt = chatRoomRepository.countChatRoomByPostId(id);
        return cnt;
    }

    @Override
    public List<ChatRoom> findAllByUserId(Long id){
        List<ChatRoom> list = chatRoomRepository.findChatRoomByUserId(id);
        return list;
    }

    @Override
    public void save(ChatRoom chatroom) {
             chatRoomRepository.save(chatroom);
    }

    @SneakyThrows
    @Override
    public ChatRoom findById(Long chatRoomId) {
        return chatRoomRepository.findById(chatRoomId).orElseThrow(ChatRoomException);
    }

}
