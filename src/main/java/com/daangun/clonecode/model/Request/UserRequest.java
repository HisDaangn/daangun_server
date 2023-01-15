package com.daangun.clonecode.model.Request;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserRequest {
    private String e_address;
    private String name;
    private double temperature;
    private String google_id;

}
