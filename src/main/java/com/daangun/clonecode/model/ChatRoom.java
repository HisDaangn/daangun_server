package com.daangun.clonecode.model;

import com.daangun.clonecode.model.Request.ChatRoomRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE chat_room SET deleted = true Where id = ?")
public class ChatRoom extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Post post;
    private String roomId;
    private Long pubId;
    private Long subId;
    private String pubName;
    private String subName;

    public static ChatRoom from(String subName, String pubName, Post post, ChatRoomRequest request){
        return ChatRoom.builder()
                .post(post)
                .roomId(UUID.randomUUID().toString())
                .pubId(request.getPubId())
                .subId(request.getSubId())
                .pubName(subName)
                .subName(pubName)
                .build();
    }


}
