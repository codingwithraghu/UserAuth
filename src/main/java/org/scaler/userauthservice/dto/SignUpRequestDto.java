package org.scaler.userauthservice.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpRequestDto {
    private String email;
    private String password;
    private String name;
}
