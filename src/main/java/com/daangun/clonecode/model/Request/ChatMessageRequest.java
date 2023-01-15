package com.daangun.clonecode.model.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class ChatMessageRequest {

    private Long chatRoomId;
    private Long writerId;
    private String message;

}
