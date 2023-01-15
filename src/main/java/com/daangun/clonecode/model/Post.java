package com.daangun.clonecode.model;


import com.daangun.clonecode.model.Request.PostRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE post SET deleted = true Where id = ?")

public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoURL;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private User writer;

    private int price;
    private String content;
    private int viewCnt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime expose_at;

    public static Post from(User writer, PostRequest request){
        return Post.builder()
                .photoURL(request.getPhotoURL())
                .title(request.getTitle())
                .writer(writer)
                .price(request.getPrice())
                .content(request.getContent())
                .viewCnt(request.getViewCnt())
                .expose_at(LocalDateTime.now())
                .build();
    }
    public void update(PostRequest request){
        this.photoURL = request.getPhotoURL();
        this.title = request.getTitle();
        this.price = request.getPrice();
        this.content = request.getContent();
    }

    public void viewUp(){
        this.viewCnt++;
    }

    public void lift(){this.expose_at = LocalDateTime.now();}
}
