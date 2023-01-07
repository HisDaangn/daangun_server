package com.daangun.clonecode.model.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ChatRoomRequest {
    private Long pubId;
    private Long subId;

}
