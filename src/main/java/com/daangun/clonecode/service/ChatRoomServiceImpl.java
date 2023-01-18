package com.daangun.clonecode.service;



import com.daangun.clonecode.exception.chatroom.ChatRoomException;
import com.daangun.clonecode.model.ChatRoom;
import com.daangun.clonecode.repository.ChatRoomRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.LinkedList;
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
    public List<ChatRoom> findALlByPostId(Long postId) {
        List<ChatRoom> response = chatRoomRepository.countChatRoomByPostId(postId);
        return response;
    }

    @Override
    public int countChatRoomByPostId(Long postId) {
        List<ChatRoom> response = chatRoomRepository.countChatRoomByPostId(postId);
        return response.size();
    }

    @Override
    public List<ChatRoom> findAllByUserId(Long id){
        List<ChatRoom> list = new LinkedList<ChatRoom>();
        try{
           list = chatRoomRepository.findChatRoomByUserId(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

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


    @Override
    public boolean checkRoom(Long postId, Long userId) {
        int c = chatRoomRepository.checkRoom(postId, userId);
        if(c>0) return true;
        return false;
    }

    @Override
    public ChatRoom findChatRoomByPostAndUser(Long postId, Long userId) {
        return chatRoomRepository.findChatRoomByPostAndUser( postId,  userId);
    }
}
