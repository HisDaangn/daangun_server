package com.daangun.clonecode.service;

import com.daangun.clonecode.exception.chatroom.ChatRoomException;
import com.daangun.clonecode.model.ChatRoom;
import com.daangun.clonecode.repository.ChatRoomRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;
    private Supplier<? extends Throwable> ChatRoomException;


    @SneakyThrows
    @Override
    public ChatRoom findById(Long chatRoomId) {
        return chatRoomRepository.findById(chatRoomId).orElseThrow(ChatRoomException);
    }
}
