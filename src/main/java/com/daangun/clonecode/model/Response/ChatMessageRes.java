//package com.daangun.clonecode.model.Response;
//
//import com.daangun.clonecode.model.ChatMessage;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class ChatMessageRes {
//    private Long id;
//    private Long chatRoomId;
//    private Long userId;
//    private String content;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
//    private LocalDateTime send_at;
//
//    public static ChatMessageRes from(ChatMessage message){
//        return new ChatMessageRes(message.getId(), message.getChatRoomId(),
//                message.getUserId(), message.getContent(), message.getSend_at());
//    }
//}
