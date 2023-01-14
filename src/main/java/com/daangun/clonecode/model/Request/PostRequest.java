package com.daangun.clonecode.model.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class PostRequest {
    private String photoURL;
    private Long writerId;
    private String title;
    private int price;
    private String content;
    private int viewCnt;
}
