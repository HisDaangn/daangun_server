package com.daangun.clonecode.model;

import com.daangun.clonecode.model.Request.ChatRoomRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE notice SET deleted = true Where id = ?")
public class ChatRoom extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Post post;


    private Long pubId;
    private Long subId;

    public static ChatRoom from(Post post, ChatRoomRequest request){
        return ChatRoom.builder()
                .post(post)
                .pubId(request.getPubId())
                .subId(request.getSubId())
                .build();
    }


}