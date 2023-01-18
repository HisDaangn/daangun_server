package com.daangun.clonecode.model;

import com.daangun.clonecode.model.Request.UserRequest;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import javax.persistence.*;


@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE user SET deleted = true Where id = ?")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String googleId;
    private String e_address;
    private String address;
    private double temperature;


    public static User from(UserRequest request){
        return User.builder()
                .e_address(request.getE_address())
                .name(request.getName())
                .temperature(request.getTemperature())
                .googleId(request.getGoogleId())
                .address(request.getAddress())
                .build();
    }

    public void update(UserRequest request){
        this.name = request.getName();
        this.address = request.getAddress();
    }

}
