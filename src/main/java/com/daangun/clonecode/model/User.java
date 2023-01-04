package com.daangun.clonecode.model;

import com.daangun.clonecode.model.Request.UserRequest;
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
@SQLDelete(sql = "UPDATE notice SET deleted = true Where id = ?")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String e_address;


    public static User from(UserRequest request){
        return User.builder()
                .name(request.getName())
                .e_address(request.getE_address())
                .build();
    }

}
