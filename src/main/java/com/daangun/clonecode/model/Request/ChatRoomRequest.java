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
    private Long pubId;
    private Long subId;
    private Long postId;

//    public ChatRoomRequest (String roomId, Long pubId, Long subId){
//        this.roomId = roomId;
//        this.pubId = pubId;
//        this.subId = subId;
//    }

}
