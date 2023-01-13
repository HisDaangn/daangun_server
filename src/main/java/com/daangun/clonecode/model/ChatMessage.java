package com.daangun.clonecode.model;

import com.daangun.clonecode.model.Request.ChatMessageRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE notice SET deleted = true Where id = ?")
public class ChatMessage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chatRoomId;
    private Long writer;
    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime send_at;

    public static ChatMessage from(ChatMessageRequest request){
        return ChatMessage.builder()
                .chatRoomId(request.getChatRoomId())
                .writer(request.getWriter())
                .message(request.getMessage())
                .send_at(request.getSend_at())
                .build();
    }
}
