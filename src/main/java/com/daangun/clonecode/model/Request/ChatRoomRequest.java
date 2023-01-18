package com.daangun.clonecode.model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomRequest {
    private Long pubId; // seller
    private Long subId; // customer
    private Long postId;

}
